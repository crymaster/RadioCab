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
                Password: <html:text property="comPass"/>
                <br/>
                <br/>
                Password Confirmation: <html:text property="comPassConfirm"/>
                <br/>
                <br/>
                Contact Person: <html:text property="comContactPerson"/>
                <br/>
                <br/>
                Designation: <html:text property="comDesignation"/>
                <br/>
                <br/>
                City: <html:select property="cityId">

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
                <html:submit  value="Register"/>
                <html:reset value="Clear"/>
            </html:form>
        </div>
        <div class="clear"></div>
    </div>
</div>
</div>