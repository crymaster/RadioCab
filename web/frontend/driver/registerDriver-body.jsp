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
            <h3>Driver Registration</h3>
            <c:forEach items="${requestScope.errors}" var="error">
                <div class="error"><bean:message key="${error}"/></div>
            </c:forEach>
            <html:form action="/register-driver-handler" enctype="multipart/form-data">
                Driver User Name: <html:text property="drvUsername"/>
                <br/>
                <br/>
                Password: <html:password property="drvPass"/>
                <br/>
                <br/>
                Password Confirmation: <html:password property="drvPassConfirm"/>
                <br/>
                <br/>
                Full Name: <html:text property="drvName"/>
                <br/>
                <br/>
                Contact Person: <html:text property="drvContactPerson"/>
                <br/>
                <br/>
                City: <html:select property="cityId">
                    <html:optionsCollection property="cityList" label="city_Name" value="city_ID"/>
                </html:select>
                <br/>
                <br/>
                Address: <html:text property="drvAddress"/>
                <br/>
                <br/>
                Mobile: <html:text property="drvMobile"/>
                <br/>
                <br/>
                Telephone: <html:text property="drvTel"/>
                <br/>
                <br/>
                Email: <html:text property="drvEmail"/>
                <br/>
                <br/>
                Image: <html:file property="image" />
                <br/>
                <br/>
                Experience: <html:textarea property="drvExp"/>
                <br/>
                <br/>
                Description: <html:textarea property="drvDescription"/>
                <br/>
                <br/>
                Payment: <html:select property="paymentType">
                    <html:optionsCollection property="paymentTypeList" label="paytype_Name" value="paytype_ID"/>
                </html:select>
                <br/>
                <br/>
                <html:submit  value="Register" styleClass="btn"/>
                <html:reset value="Clear" styleClass="btn"/>
            </html:form>
        </div>
        <div class="grid_4">
            <a href="drivers.do" class="bigLink">Search for driver</a>
        </div>
        <div class="clear"></div>
    </div>
</div>
