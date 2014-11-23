<%-- 
    Document   : doUnconfirmOrder
    Created on : Sep 8, 2014, 8:52:26 AM
    Author     : quangphamngoc
--%>
<%@page import="beans.BillBean"%>
<%@page import="db.BillDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    String itemID = request.getParameter("id");
    boolean status = BillDB.unconfirmBill(Integer.parseInt(itemID));
    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully unconfirm order");
    } else {
        json.put("msg", "An error occured! Please try again");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>
