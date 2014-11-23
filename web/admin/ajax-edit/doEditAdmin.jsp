<%-- 
    Document   : doEditCustomer
    Created on : Aug 18, 2014, 4:09:20 PM
    Author     : quangphamngoc
--%>

<%@page import="db.AdminDB"%>
<%@page import="beans.AdminBean"%>
<%@page import="java.sql.Date"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    AdminBean item = new AdminBean();
    String email = request.getParameter("email");
    item.setAd_Email(email);
    String phone = request.getParameter("phone");
    item.setAd_Phone(phone);
    String role = request.getParameter("role");
    item.setRole_ID(Integer.parseInt(role));
    String stt = request.getParameter("status");
    item.setAd_Status(Integer.parseInt(stt));
    String itemID = request.getParameter("itemID");
    item.setAd_ID(Integer.parseInt(itemID));
    boolean status = AdminDB.editAdmin(item);

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