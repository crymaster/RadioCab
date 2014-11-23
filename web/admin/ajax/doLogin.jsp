<%-- 
    Document   : doLogin
    Created on : Aug 6, 2014, 2:21:31 PM
    Author     : quangphamngoc
--%>

<%@page import="utils.AppUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="db.LoginDB"%>
<%@page import="beans.AdminBean"%>
<%@page import="org.json.simple.JSONObject" %>

<%
    String username = request.getParameter("user");
    String password = request.getParameter("pass");
    JSONObject json = new JSONObject();
    if (LoginDB.doLogin(username, password)) {
        AdminBean admin = LoginDB.currentAdmin;
        session.setAttribute("adminID", admin.getAd_ID() + "");
        session.setAttribute("adminAccount", admin.getAd_Account());
        session.setAttribute("adminAvatar", admin.getAd_Avatar());
        session.setAttribute("adminRole", admin.getRole_ID());
        session.setAttribute("adminRoleName", admin.getRole_Name());
        session.setAttribute("isLocking", "false");
        json.put("status", true);
        json.put("href", "dashboard.jsp");
        
    } else {
        json.put("status", false);
        if (LoginDB.error == 1) {
            json.put("error", "SQL Error. ");
        } else if (LoginDB.error == 2) {
            json.put("error", "Driver or Class Not Found");
        } else if (LoginDB.error == 3) {
            json.put("error", "Wrong username or password");
        } else if (LoginDB.error == 4) {
            json.put("error", "Your account has been banned");
        }
    }
    out.print(json);
    out.flush();
%>