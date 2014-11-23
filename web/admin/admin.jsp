<%-- 
    Document   : customer
    Created on : Aug 18, 2014, 3:04:50 PM
    Author     : quangphamngoc
--%>

<%@page import="db.PermissionDB"%>
<%@page import="db.RoleDB"%>
<%@page import="beans.RoleBean"%>
<%@page import="db.AdminDB"%>
<%@page import="beans.AdminBean"%>
<%@page import="utils.AppUtil"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    if (!PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Admin", "View")) {
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    } 
%>
    <div class="wrapper row-offcanvas row-offcanvas-left">
        <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">                
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Admin
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Admin</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">


                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">List Admins</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body table-responsive">
                                <table id="dataTable" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Avatar</th>
                                            <th>Username</th>
                                            <th>Role</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>Status</th>
                                            <th>Edit</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <%
                                        List<AdminBean> items = AdminDB.getAllAdmins();
                                        for (AdminBean item : items) {%>
                                    <tr>
                                        <td><%=item.getAd_ID()%></td>
                                        <td><img width="30px" height="30px" src="../app_images/<%=item.getAd_Avatar()%>" class="img-circle"/></td>
                                        <td><%=AppUtil.formatNullString(item.getAd_Account())%> </td>
                                        <td><%=AppUtil.formatNullString(item.getRole_Name())%></td>
                                        <td><%=AppUtil.formatNullString(item.getAd_Email())%></td>
                                        <td><%=AppUtil.formatNullString(item.getAd_Phone())%></td>
                                        <td><%=AppUtil.formatNullString(item.getAd_Status_InString())%></td>
                                        <% if(item.getAd_ID() == Integer.parseInt(session.getAttribute("adminID").toString()) || item.getRole_Name().equalsIgnoreCase("super admin") || !PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Admin", "Edit")){ %>
                                        <td></td>
                                        <% } else { %>
                                        <td><a href="editAdmin.jsp?aid=<%=item.getAd_ID()%>">Edit</a>  </td>
                                        <% } %>
                                    </tr>
                                    <%
                                        }
                                    %>


                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Avatar</th>
                                        <th>Username</th>
                                        <th>Role</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>
                                    <%
                if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Admin", "Create")) {
             %>
            <button class="btn btn-primary" id="dialog_active">New admin</button>
            <br/>
            <div class="row">
                <div class="col-md-8">

                    <div class="box box-primary" id="dialog" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">Add new item</h3>
                        </div>
                        <br/>
                        <%
                            List<RoleBean> listRole = RoleDB.getAllAvailableRole();
                            if (listRole.size() == 0) {
                        %>
                        <div class="alert alert-warning alert-dismissable notification">
                            <i class="fa fa-warning"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Warning!</b> <span class="msgsuccess">You must have at least one available role before adding an admin</span>
                            <br/><a href="role.jsp">Click here to go to role site</a>
                        </div>
                        <br/>
                        <% } else { %>
                        <div class="alert alert-success alert-dismissable notification msg-success" style="display: none">
                            <i class="fa fa-check"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Notice!</b> <span class="msgsuccess">Successfully added new item</span>
                        </div>
                        <div class="alert alert-danger alert-dismissable notification msg-error" style="display: none">
                            <i class="fa fa-ban"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Error!</b> <span class="msgerror">Successfully added new item</span>
                        </div>

                        <form role="form" id="form" method="post" action="ajax-add/doAddAdmin.jsp">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="userName">Username</label>
                                    <input type="text" class="form-control" name="userName" id="userName" placeholder="Enter username">
                                </div>

                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
                                </div>

                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
                                </div>

                                <div class="form-group">
                                    <label for="phone">Phone </label>
                                    <input type="text" class="form-control" name="phone" id="phone" placeholder="Enter phone">
                                </div>

                                <div class="form-group">
                                    <label for="role">Role</label>
                                    <select class="form-control" id="role"  name ="role">
                                        <%
                                            if (listRole.size() != 0) {
                                                for (RoleBean role : listRole) {
                                        %>
                                        <option value="<%=role.getRole_ID()%>"><%=role.getRole_Name()%></option>
                                        <% }
                                            } else {

                                            }%>

                                    </select>
                                </div>

                            </div>

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="reset" class="btn btn-primary">Cancel</button>
                            </div>
                        </form>
                        <% }%>
                    </div>

                </div>

            </div>   <!-- /.row -->
            <% } %>
        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<script src="js/pages/admin.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
