<%-- 
    Document   : doAddCustomer
    Created on : Aug 18, 2014, 3:26:10 PM
    Author     : quangphamngoc
--%>

<%@page import="db.CompanyDB"%>
<%@page import="beans.CompanyBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    CompanyBean item = new CompanyBean();
    String memtype = request.getParameter("memtype");
    item.setMem_ID(Integer.parseInt(memtype));
    String city = request.getParameter("city");
    item.setCity_ID(Integer.parseInt(city));
    String uname = request.getParameter("uname");
    item.setCom_uName(uname);
    String password = request.getParameter("password");
    item.setCom_Pass(password);
    String name = request.getParameter("name");
    item.setCom_Name(name);
    String contact = request.getParameter("contact");
    item.setCom_Contactperson(contact);
    String des = request.getParameter("des");
    item.setCom_Designation(des);
    String productImage = request.getParameter("productImageName");
    item.setCom_Image(productImage);
    String address = request.getParameter("address");
    item.setCom_Address(address);
    String mobile = request.getParameter("mobile");
    item.setCom_Mobile(mobile);
    String tel = request.getParameter("tel");
    item.setCom_Tel(tel);
    String fax = request.getParameter("fax");
    item.setCom_Fax(fax);
    String email = request.getParameter("email");
    item.setCom_Email(email);
    
    int insertedID = CompanyDB.addComapny(item);
    boolean status = (insertedID == -1) ? false : true;
    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully added new item");
        json.put("insertedID", insertedID);
    } else {
        json.put("msg", "An error occured! Please try again");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>
