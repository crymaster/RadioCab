<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.RoleDB"%>
<%@page import="beans.RoleBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    RoleBean item = new RoleBean();
    String stt = request.getParameter("status");
    item.setRole_status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setRole_ID(Integer.parseInt(itemID));
    boolean status = RoleDB.editRole(item);

    json = new JSONObject();
    if (status) {
        json.put("msg", "Successfully edit item");
    } else {
        json.put("msg", "An error occured! Please try again");
    }
    json.put("status", status);
    out.print(json);
    out.flush();
%>