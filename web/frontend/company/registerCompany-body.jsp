<%-- 
    Document   : company-register-body
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
            <h3>Company Registration</h3>
            <c:forEach items="${requestScope.errors}" var="error">
                <div class="error"><bean:message key="${error}"/></div>
            </c:forEach>
            <html:form action="/register-company-handler">
                Company Name: <html:text property="comUsername"/>
                <br/>
                <br/>
                Password: <html:password property="comPass"/>
                <br/>
                <br/>
                Password Confirmation: <html:password property="comPassConfirm"/>
                <br/>
                <br/>
                Display Company Name: <html:text property="comName"/>
                <br/>
                <br/>
                Contact Person: <html:text property="comContactPerson"/>
                <br/>
                <br/>
                Designation: <html:text property="comDesignation"/>
                <br/>
                <br/>
                City: <html:select property="cityId">
                    <html:optionsCollection property="cityList" label="city_Name" value="city_ID"/>
                </html:select>
                <br/>
                <br/>
                Address: <html:text property="comAddress"/>
                <br/>
                <br/>
                Mobile: <html:text property="comMobile"/>
                <br/>
                <br/>
                Telephone: <html:text property="comTel"/>
                <br/>
                <br/>
                Fax: <html:text property="comFax"/>
                <br/>
                <br/>
                Email: <html:text property="comEmail"/>
                <br/>
                <br/>
                Membership: <html:select property="membershipType">
                    <html:optionsCollection property="membershipTypeList" label="mem_Name" value="mem_ID"/>
                </html:select>
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
            <a href="companies.do" class="bigLink">Search for company</a>
        </div>
        <div class="clear"></div>
    </div>
</div>
