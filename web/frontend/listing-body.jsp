<%-- 
    Document   : listing-body
    Created on : Nov 23, 2014, 6:34:17 PM
    Author     : Son
--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<div class="content">
    <div class="container_12">

        <div class="grid_6 prefix_1">
            <h3>Company Registration</h3>

            <html:form action="/register-company">
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
                <html:submit  value="Register"/>
                <html:reset value="Clear"/>
            </html:form>
        </div>
        <div class="clear"></div>
    </div>
</div>