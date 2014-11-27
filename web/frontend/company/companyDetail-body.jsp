<%-- 
    Document   : companyDetail-body
    Created on : Nov 27, 2014, 12:17:47 PM
    Author     : son
--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content">
    <div class="container_12">
        <div class="grid_4 prefix_1">
            <h3 style="padding-top: 80px; text-align: center"><c:out value="${company.com_Name}"/></h3>
            <img src="frontend/images/page2_img1.jpg" alt="" class="img_inner fleft">
        </div>
        <div class="grid_4 prefix_1">
            <div style="padding-top:30px">
                <ul class="list li">
                    <li class="list_count">1</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Contact Person</a></div>
                        <c:out value="${company.com_Contactperson}"/>&nbsp;
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">2</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Designation</a></div>
                        <c:out value="${company.com_Designation}"/>
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">3</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">City</a></div>
                        <c:out value="${company.city_Name}"/>&nbsp;
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">4</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Address</a></div>
                        <c:out value="${company.com_Address}"/>&nbsp;
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">5</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Mobile</a></div>
                        <c:out value="${company.com_Mobile}"/>&nbsp;
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">6</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Telephone</a></div>
                        <c:out value="${company.com_Tel}"/>&nbsp;
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">7</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Fax</a></div>
                        <c:out value="${company.com_Fax}"/>&nbsp;
                    </li>
                </ul>
                <ul class="list li">
                    <li class="list_count">8</li>
                    <li class="extra_wrapper">
                        <div class="text1 color2"><a href="#">Email</a></div>
                        <c:out value="${company.com_Email}"/>&nbsp;
                    </li>
                </ul>
            </div>
        </div>
        <div class="clear"></div>

    </div>
</div>