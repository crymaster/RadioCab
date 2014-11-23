<%-- 
    Document   : removeComment
    Created on : Sep 8, 2014, 2:58:53 PM
    Author     : quangphamngoc
--%>

<%@page import="beans.ProductBean"%>
<%@page import="db.CommentDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    String cid = request.getParameter("cid");
    String productID = request.getParameter("pid");
    boolean status = CommentDB.removeCommentFromProduct(Integer.parseInt(productID), Integer.parseInt(cid));
    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully remove  item");
        
    } else {
        json.put("msg", "Error!");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>