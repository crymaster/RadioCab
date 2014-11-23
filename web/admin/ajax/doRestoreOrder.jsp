<%-- 
    Document   : doRestoreOrder
    Created on : Sep 9, 2014, 2:44:48 PM
    Author     : quangphamngoc
--%>

<%@page import="beans.BillBean"%>
<%@page import="db.BillDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    String itemID = request.getParameter("id");
    boolean status = BillDB.enableBill(Integer.parseInt(itemID));
    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully restore order");
    } else {
        json.put("msg", "An error occured! Please try again");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>
