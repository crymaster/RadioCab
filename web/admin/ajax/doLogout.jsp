<%-- 
    Document   : doLogout
    Created on : Apr 9, 2013, 3:18:45 AM
    Author     : Quang
--%>

<%
    session.setAttribute("adminID", "");
    session.setAttribute("adminAccount", "");
    session.setAttribute("adminAvatar", "");
    session.removeAttribute("adminAvatar");
    session.removeAttribute("adminID");
    session.removeAttribute("adminAccount");
    response.sendRedirect("../login.jsp");
%>
