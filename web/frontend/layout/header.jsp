<%-- 
    Document   : header
    Created on : Nov 23, 2014, 5:41:32 PM
    Author     : Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--==============================header=================================-->
<% boolean loggedIn = false; 
   String currentPage;
%>
<c:forEach items="${cookie}" var="item">
    <c:if test="${item.key == 'rcUsername'}">
        <% loggedIn = true;%>
    </c:if>
    <c:if test="${item.key == 'rcPage'}">
        <c:set var="currentPage" value="${item.value.value}"/>
    </c:if>
</c:forEach>
<header>
    <div class="menu_block ">
        <div class="container_12">
            <div class="grid_12">
                <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                    <ul class="sf-menu">
                        <li <c:if test="${empty currentPage}">class="current"</c:if>><a href="homepage.do">Home</a></li>
                        <li <c:if test="${currentPage == 'company'}">class="current"</c:if>><a href="companies.do">Company</a></li>
                        <li <c:if test="${currentPage == 'driver'}">class="current"</c:if>><a href="drivers.do">Driver</a></li>
                        <li <c:if test="${currentPage == 'advertise'}">class="current"</c:if>><a href="advertises.do">Advertisement</a></li>
                        <li <c:if test="${currentPage == 'feedback'}">class="current"</c:if>><a href="feedback.do">Feedback</a></li>
                            <% if (!loggedIn) {%>
                        <li <c:if test="${currentPage == 'login'}">class="current"</c:if>><a href="login.do">Login</a></li>
                            <% } else { %>
                        <li <c:if test="${currentPage == 'profile'}">class="current"</c:if>><a href="profile.do">Profile</a></li>
                        <li><a href="logout.do">Logout</a></li>
                            <% }%>
                    </ul>
                </nav>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <div class="clear"></div>
</header>