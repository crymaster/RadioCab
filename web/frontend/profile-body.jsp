<%-- 
    Document   : profile
    Created on : Nov 27, 2014, 1:02:46 AM
    Author     : son
--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="content">
    <div class="container_12">
        <div class="grid_5">
            <h3 style="text-align: center">
                <c:if test="${not empty company}">
                    <c:out value="${company.com_uName}"/>
                </c:if>
                <c:if test="${not empty driver}">
                    <c:out value="${driver.driver_uName}"/>
                </c:if>
            </h3>
            <c:if test="${not empty company}">
                <img src="upload/company/${company.com_Image}" alt="" style="padding-left:50px"/>
            </c:if>
            <c:if test="${not empty driver}">
                <img src="upload/driver/${driver.driver_Image}" alt="" style="padding-left:50px"/>
            </c:if>
        </div>
        <div class="grid_3 ">
            <div class="map" style="padding-top: 150px">
                <c:if test="${not empty company}">
                    <div class="text1 color2">Company Info</div>
                    Company Name: <c:out value="${company.com_Name}"/> <br/>
                    Contact Person:<span class="color1"><c:out value="${company.com_Contactperson}"/></span><br/>
                    Designation:<span class="color1"><c:out value="${company.com_Designation}"/></span><br/>
                    <address>
                        <dl>
                            <dt>Address: <c:out value="${company.com_Address}"/>
                            </dt>
                            <dd>City: <c:out value="${company.city_Name}"/></dd>
                            <dd><span>Mobile: </span> <c:out value="${company.com_Mobile}"/></dd>
                            <dd><span>Telephone: </span> <c:out value="${company.com_Tel}"/></dd>
                            <dd><span>FAX: </span><c:out value="${company.com_Fax}"/></dd>
                            <dd>E-mail: <a href="#" class="color1"><c:out value="${company.com_Email}"/></a></dd>
                        </dl>
                    </address>
                </c:if>

                <c:if test="${not empty driver}">
                    <div class="text1 color2">Driver info</div>
                    Driver Name: <c:out value="${driver.driver_Name}"/><br/>
                    Contact Person:<span class="color1"><c:out value="${driver.driver_Contactperson}"/></span><br/>
                    <address>
                        <dl>
                            <dt>Address: <c:out value="${driver.driver_Address}"/>
                            </dt>
                            <dd>City: <c:out value="${driver.city_Name}"/></dd>
                            <dd><span>Mobile: </span> <c:out value="${driver.driver_Mobile}"/></dd>
                            <dd><span>Telephone: </span> <c:out value="${driver.driver_Tel}"/></dd>
                            <dd>E-mail: <a href="#" class="color1"><c:out value="${driver.driver_Email}"/></a></dd>
                            <dd>Experience: <c:out value="${driver.driver_Exp}"/></dd>
                            <dd>Description: <c:out value="${driver.driver_Description}"/></dd>
                        </dl>
                    </address>
                </c:if>
            </div>
        </div>
        <div class="grid_3">
            <div class="map" style="padding-top: 150px">
                <c:if test="${not empty company}">
                    <div class="text1 color2">Company Payment</div>
                </c:if>
                <c:forEach items="${cPayment}" var="payment">
                    Type:  <c:if test="${payment.adv_ID !=0}">Advertising Fee<br/></c:if>
                    <c:if test="${payment.adv_ID == 0}">Company Fee<br/></c:if>
                    From: <span class="color1"><fmt:formatDate pattern="dd/MM/yyyy" value="${payment.pay_Time}" /></span><br/>
                    To: <span class="color1"><fmt:formatDate pattern="dd/MM/yyyy" value="${payment.pay_TimeExpired}"/></span><br/>
                    Amount: <span class="color1"><c:out value="${payment.pay_Total}"/>$</span><br/>
                    <c:if test="${payment.pay_Status == 1}">
                        Status: <span class="color1">Paid</span><br/>
                    </c:if>
                    <c:if test="${payment.pay_Status == 2}">
                        Status: <span class="color1">Not Paid</span><br/>
                    </c:if>
                    <br/>
                </c:forEach>
                <c:if test="${not empty driver}">
                    <div class="text1 color2">Driver Payment</div>
                </c:if>
                <c:if test="${not empty dPayment}">
                    From: <span class="color1"><fmt:formatDate pattern="dd/MM/yyyy" value="${dPayment.pay_Time}" /></span><br/>
                    Expired date: <span class="color1"><fmt:formatDate pattern="dd/MM/yyyy" value="${dPayment.pay_TimeExpired}"/></span><br/>
                    Amount: <span class="color1"><c:out value="${dPayment.pay_Total}"/>$</span>
                    <c:if test="${payment.pay_Status == 1}">
                        Status: <span class="color1">Paid</span><br/>
                    </c:if>
                    <c:if test="${payment.pay_Status == 2}">
                        Status: <span class="color1">Not Paid</span><br/>
                    </c:if>
                </c:if>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>