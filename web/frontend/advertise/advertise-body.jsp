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
            <h3 style="text-align: center">Taxi Company Advertisement</h3>
            <a> <a href="order-advertise.do" class="bigLink" style="padding-top: 0px; text-align: center">Advertise your company</a>
        </div>
        <div class="clear"></div>
        <% int count = 0; %>
        <c:forEach items="${requestScope.advs}" var="adv">
            <% if(count%2 == 0) {%>
            <div class="gallery">
            <% } %>
            <% count++; %>
            <div class="grid_6">
                <a href="upload/advertise/${adv.adv_Image}" class="type" style="margin-top: 0px"><img src="upload/advertise/${adv.adv_Image}" alt=""><span class="type_caption"><c:out value="${adv.com_Name}"/></span></a>
            </div>    
            <% if(count%2 == 0) {%>
            </div>
            <% } %>
        </c:forEach>
    </div>
</div>