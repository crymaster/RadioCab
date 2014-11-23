<%-- 
    Document   : doRemoveProductFromPackage
    Created on : Sep 7, 2014, 1:11:46 AM
    Author     : quangphamngoc
--%>


<%@page import="beans.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="db.ProductDB"%>
<%@page import="db.PackageDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    
    String packid = request.getParameter("packid");
    String productID = request.getParameter("productid");
    boolean status = PackageDB.removeProductFromPackage(Integer.parseInt(packid), Integer.parseInt(productID));
    out.print("Test");
    response.sendRedirect("../editPackage.jsp?id="+packid);
   
%>