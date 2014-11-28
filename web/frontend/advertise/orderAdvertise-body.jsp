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

        <div class="grid_6 prefix_1">
            <h3>Advertisement Order</h3>
            <c:forEach items="${requestScope.errors}" var="error">
                <bean:message key="${error}"/>
            </c:forEach>
            <html:form action="/order-advertise-handler" enctype="multipart/form-data">
                Company Name: 
                <c:forEach items="${cookie}" var="item">
                    <c:if test="${item.key == 'rcUsername'}">
                        <c:out value="${item.value.value}"/>
                    </c:if>
                </c:forEach>
                <br/>
                <br/>
                Advertising Image: <html:file property="image"/>
                <br/>
                <br/>
                Description: <html:text property="advDescription"/>
                <br/>
                <br/>
                Payment: <html:select property="paymentType">
                    <html:optionsCollection property="paymentTypeList" label="paytype_Name" value="paytype_ID"/>
                </html:select>
                <br/>
                <br/>
                <html:submit  value="Order" styleClass="btn"/>
                <html:reset value="Clear" styleClass="btn"/>
            </html:form>
        </div>
        <div class="grid_4">
            <a href="advertises.do" class="bigLink">Show Advertisement</a>
        </div>
        <div class="clear"></div>
    </div>
</div>
