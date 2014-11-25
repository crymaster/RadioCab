<%-- 
    Document   : driver-body
    Created on : Nov 23, 2014, 6:34:17 PM
    Author     : Son
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="content">
    <div class="container_12">

        <div class="grid_6">

            <h3>Search for Driver</h3>
            <html:form action="/search-driver.do">
                Driver Name: <html:text property="drvName"/>
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
        <div class="grid_6">
            <a href="register-driver.do" class="bigLink">Are you a taxi driver? Register now</a>
        </div>
    </div>
    <div class="clear"></div>
</div>

<div class="container_12">
    <c:forEach items="${requestScope.drivers}"  var="driver">
        <div class="grid_4">
            <div class="box">
                <div class="maxheight">
                    <img src="frontend/images/page4_img1.jpg" alt="">
                    <div class="text1 color2">
                        <a href="driver-detail.do?id=<c:out value="${driver.driver_ID}"/>"><c:out value="${driver.driver_Name}"></c:out></a>
                        </div>
                        City: <c:out value="${driver.driver_Name}"/> <br/>
                    Address: <c:out value="${driver.driver_Address}"/> <br/>
                    Tel: <c:out value="${driver.driver_Tel}"/>
                    <br/>
                    <a href="driver-detail.do?id=<c:out value="${driver.driver_ID}"/>" class="btn">Read More</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div class="clear"></div>
