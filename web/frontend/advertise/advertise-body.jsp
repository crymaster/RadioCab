<%-- 
    Document   : driver-register-body
    Created on : Nov 25, 2014, 2:52:36 PM
    Author     : son
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container_12">
        <div class="grid_12">
            <h3>Taxi Company Advertisement</h3>
        </div>
        <div class="clear"></div>
        <% int count = 0; %>
        <c:forEach items="${requestScope.advs}" var="adv">
            <% if(count%3 == 0) {%>
            <div class="gallery">
            <% } %>
            <div class="grid_4">
                <a href="frontend/images/<c:out value="${adv.adv_Image}"/>" class="gal"><img src="frontend/images/<c:out value="${adv.adv_Image}"/>" alt=""></a>
                <c:out value="${adv.adv_Description}"/>
            </div>    
            <% if(count%3 == 0) {%>
            </div>
            <% } %>
            <% count++; %>
        </c:forEach>
    </div>