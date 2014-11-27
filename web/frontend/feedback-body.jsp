<%-- 
    Document   : feedback-body
    Created on : Nov 27, 2014, 6:48:30 PM
    Author     : son
--%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container_12">

        <div class="grid_6 prefix_1">
            <h3>Feedback</h3>
            <c:forEach items="${requestScope.errors}" var="error">
                <bean:message key="${error}"/>
            </c:forEach>
            <html:form action="/feedback-handler">
                Name: <html:text property="name"/>
                <br/>
                <br/>
                City: <html:select property="city">
                    <html:optionsCollection property="cityList" label="city_Name" value="city_ID"/>
                </html:select>
                <br/>
                <br/>
                Mobile: <html:text property="mobile"/>
                <br/>
                <br/>
                Email: <html:text property="email"/>
                <br/>
                <br/>
                Type: <html:select property="type">
                    <html:option value="Complaint"/>
                    <html:option value="Suggestion" />
                    <html:option value="Compliment" />
                </html:select>
                <br/>
                <br/>
                Description: <html:textarea property="description"/>
                <br/>
                <br/>
                <html:submit  value="Send" styleClass="btn"/>
                <html:reset value="Clear" styleClass="btn"/>
            </html:form>
        </div>
        <div class="clear"></div>
    </div>
</div>
