<%-- 
    Document   : login-body
    Created on : Nov 26, 2014, 10:36:14 PM
    Author     : son
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container_12">

        <div class="grid_6 prefix_1">
            <h3>Login</h3>
            <c:forEach items="${requestScope.errors}" var="error">
                <bean:message key="${error}"/>
            </c:forEach>
            <html:form action="/login">
                User Name: <html:text property="username"/>
                <br/>
                <br/>
                Password: <html:password property="password"/>
                <br/>
                <br/>
                Login as: <html:radio property="type" value="company"/> Company
                <html:radio property="type" value="driver"/> Driver
                <br/>
                <br/>
                <html:submit  value="Login" styleClass="btn"/>
                <html:reset value="Clear" styleClass="btn"/>
            </html:form>
        </div>
        <div class="clear"></div>
    </div>
</div>