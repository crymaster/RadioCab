<%-- 
    Document   : listing-body
    Created on : Nov 23, 2014, 6:34:17 PM
    Author     : Son
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="content">
    <div class="container_12">

        <div class="grid_6 prefix_1">

            <h3>Search for Company</h3>
            <html:form action="/search-company.do">
                Company Name: <html:text property="comName"/>
                <br/>
                <br/>
                City: 
                <html:select property="cityId">
                    <html:optionsCollection property="cityList" label="city_Name" value="city_ID"/>
                </html:select>
                <br/>
                <br/>
                <html:submit value="Search" styleClass="btn"/>
            </html:form>
        </div>
        <div class="grid_5">
            <a href="register-company.do" class="bigLink">Register your company</a>
        </div>
    </div>
    <div class="clear"></div>
</div>

<div class="container_12">
    <c:forEach items="${requestScope.companies}"  var="company">
        <div class="grid_4">
            <div class="box">
                <div class="maxheight">
                    <img src="frontend/images/page4_img1.jpg" alt="">
                    <div class="text1 color2">
                        <a href="company-detail.do?id=<c:out value="${company.com_ID}"/>"><c:out value="${company.com_Name}"></c:out></a>
                        </div>
                        City: <c:out value="${company.city_Name}"/> <br/>
                    Address: <c:out value="${company.com_Address}"/> <br/>
                    Tel: <c:out value="${company.com_Tel}"/>
                    <br/>
                    <a href="company-detail.do?id=<c:out value="${company.com_ID}"/>" class="btn">Read More</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div class="clear"></div>
