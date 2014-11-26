<%-- 
    Document   : header
    Created on : Nov 23, 2014, 5:41:32 PM
    Author     : Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--==============================header=================================-->
<header>
    <div class="menu_block ">
        <div class="container_12">
            <div class="grid_12">
                <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                    <ul class="sf-menu">
                        <li class="current"><a href="homepage.do">Home</a></li>
                        <li><a href="companies.do">Companies</a></li>
                        <li><a href="drivers.do">Drivers</a></li>
                        <li><a href="advertises.do">Advertises</a></li>
                        <li><a href="services.do">Services</a></li>
                        <li><a href="feedback.do">Feedback</a></li>
                        <% boolean loggedIn = false; %>
                        <c:forEach items="${cookie}" var="item">
                            <c:if test="${item.key == 'rcUsername'}">
                                <% loggedIn = true;%>
                                <li><a href="profile.do">Profile</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${loggedIn == false}">
                            <li><a href="login.do">Login</a></li>
                        </c:if>
                    </ul>
                </nav>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <div class="clear"></div>
</header>