<%-- 
    Document   : doAddCustomer
    Created on : Aug 18, 2014, 3:26:10 PM
    Author     : quangphamngoc
--%>

<%@page import="db.AdminDB"%>
<%@page import="beans.AdminBean"%>
<%@page import="java.sql.Date"%>
<%@page import="beans.CustomerBean"%>
<%@page import="db.CustomerDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    
    JSONObject json = new JSONObject();
    AdminBean item = new AdminBean();
        String username = request.getParameter("userName");
        item.setAd_Account(username);
        String password = request.getParameter("password");
        item.setAd_Password(password);
        String email = request.getParameter("email");
        item.setAd_Email(email);
        String phone = request.getParameter("phone");
        item.setAd_Phone(phone);
        String role = request.getParameter("role");
        item.setRole_ID(Integer.parseInt(role));
        int insertedID = AdminDB.addAdmin(item);
        boolean status  = (insertedID == -1) ? false : true;
        json = new JSONObject();
        if (status){
            json.put("msg", "Successfully added new item");
            json.put("insertedID", insertedID);
        }
        else{
            json.put("msg", "An error occured! Please try again");
        }
        json.put("status", status);
        out.print(json);
        out.flush();
%>
