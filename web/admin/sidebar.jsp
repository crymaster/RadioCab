<%-- 
    Document   : sidebar
    Created on : Aug 9, 2014, 10:12:10 AM
    Author     : quangphamngoc
--%>
<%@page import="db.LoginDB"%>
<%@page import="db.PermissionDB"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="left-side sidebar-offcanvas">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<c:out value="../app_images/${sessionScope.adminAvatar}" />" class="img-circle" alt="User Image" />
                     
            </div>
            <div class="pull-left info">
                <p>
                    Hello, <c:if test="${not empty sessionScope.adminAccount}"> 
                    <c:out value="${sessionScope.adminAccount}" />

                </c:if>
                </p>

            </div>
        </div>
        <!-- search form -->
        <!--
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search..."/>
                <span class="input-group-btn">
                    <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                </span>
            </div>
        </form>-->
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="active">
                <a href="dashboard.jsp" class="sb-dashboard">
                    <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                </a>
            </li>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Admin", "View")){%>
            <li>
                <a href="admin.jsp" class="sb-customer">
                    <i class="fa fa-user"></i> <span>Admin</span> 
                </a>
            </li>
            <% } %>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Role", "View")){%>
            <li>
                <a href="role.jsp" class="sb-group">
                    <i class="fa fa-group"></i> <span>Role</span> 
                </a>
            </li>
            <% } %>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "City", "View")){%>
            <li>
                <a href="city.jsp" class="sb-category">
                    <i class="fa fa-location-arrow"></i> <span>City</span> 
                </a>
            </li>
            <% } %>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "MembershipType", "View")){%>
            <li>
                <a href="membertype.jsp" class="sb-package">
                    <i class="fa fa-android"></i> <span>Member Type</span> 
                </a>
            </li>
             <% } %>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Driver", "View")){%>
            <li>
                <a href="driver.jsp" class="sb-brand">
                    <i class="fa fa-user-md"></i> <span>Driver</span> 
                </a>
            </li>
            <% } %>
             <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Company", "View")){%>
            <li>
                <a href="company.jsp" class="sb-product">
                    <i class="fa fa-building-o"></i> <span>Company</span> 
                </a>
            </li>
            <% } %>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Advertise", "View")){%>
            <li>
                <a href="advertise.jsp" class="sb-product">
                    <i class="fa fa-picture-o"></i> <span>Advertise</span> 
                </a>
            </li>
            <% } %>
            <%if(PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "PaymentType", "View")){%>
            <li>
                <a href="paymenttype.jsp" class="sb-order">
                    <i class="fa fa-ticket"></i> <span>Payment Type</span> 
                </a>
            </li>
            <% } %>
            <li>
                <a href="payment.jsp" class="sb-event">
                    <i class="fa fa-bookmark-o"></i> <span>Event</span> 
                </a>
            </li>
            <li>
                <a href="feedback.jsp" class="sb-comment">
                    <i class="fa fa-comments-o"></i> <span>Comments</span> 
                </a>
            </li>
            <li>
                <a href="statistic.jsp" class="sb-statistic">
                    <i class="fa fa-pencil"></i> <span>Statistic</span> 
                </a>
            </li>
            
            
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
