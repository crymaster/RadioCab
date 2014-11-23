<%-- 
    Document   : doRemoveOrder
    Created on : Sep 9, 2014, 2:32:54 PM
    Author     : quangphamngoc
--%>

<%@page import="beans.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="db.ProductDB"%>
<%@page import="db.BillDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%

    JSONObject json = new JSONObject();
    String billID = request.getParameter("id");
    String reason = request.getParameter("reason");
    boolean status = BillDB.disableBill(Integer.parseInt(billID),reason );
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