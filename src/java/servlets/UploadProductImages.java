/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import db.ConfigApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.simple.JSONObject;

/**
 *
 * @author quangphamngoc
 */
@WebServlet(urlPatterns = "/admin/uploadProductImage")
@MultipartConfig
public class UploadProductImages extends HttpServlet {
 private boolean status;
    private String msg;
    private String name;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(msg);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            for (Part part : request.getParts()) {

                InputStream is = request.getPart(part.getName()).getInputStream();
                int i = is.available();
                byte[] b = new byte[i];
                is.read(b);

                String fileName = getFileName(part);
                File file = null;
                
                
                File fileToGetPath = new File(getServletContext().getRealPath("/"));
                Path buildWebPath = fileToGetPath.toPath();
                Path rootPath = buildWebPath.getParent().getParent();
                String filePath = rootPath.toString() + "/web/" + ConfigApp.UPLOAD_PRODUCT_IMAGE_FOLDER + "/"; 
                
                if (fileName.lastIndexOf("\\") >= 0) {
                    file = new File(filePath
                            + fileName.substring(fileName.lastIndexOf("\\")));
                } else {
                    file = new File(filePath
                            + fileName.substring(fileName.lastIndexOf("\\") + 1));
                }

                // rename if file exists
                int idx = 1;
                while (file.exists()) { // keep renaming as file_(2) , file_(3) etc.
                    String path = file.getAbsolutePath();
                    int iDot = path.lastIndexOf(".");
                    file = new File(path.substring(0, iDot)
                            + "_(" + ++idx + ")" + path.substring(iDot));

                }
                filePath = file.getPath();
                

                FileOutputStream os = new FileOutputStream(filePath);
                os.write(b);
                is.close();
                status = true;
                msg = filePath;
                name = file.getName().toString();
            }
        } catch (Exception ex) {
            status = false;
            msg = ex.getMessage();
        }
        JSONObject json = new JSONObject();
        json.put("status", status);
        json.put("msg", msg);
        json.put("fileName", name);
        PrintWriter out = response.getWriter();
        out.print(json);
    }
    
    private String getFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");

        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
