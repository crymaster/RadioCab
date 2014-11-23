<%-- 
    Document   : logout
    Created on : Aug 9, 2014, 10:52:16 AM
    Author     : quangphamngoc
--%>

<%
    session.setAttribute("adminID", "");
    session.setAttribute("adminAccount", "");
    session.removeAttribute("adminID");
    session.removeAttribute("adminAccount");
    response.sendRedirect("login.jsp");
%>