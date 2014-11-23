<%-- 
    Document   : customer
    Created on : Aug 18, 2014, 3:04:50 PM
    Author     : quangphamngoc
--%>

<%@page import="db.PermissionDB"%>
<%@page import="db.RoleDB"%>
<%@page import="beans.RoleBean"%>
<%@page import="utils.AppUtil"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    if (!PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Role", "View")) {
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
                    Role
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Roles</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">


                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">List Roles</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body table-responsive">
                                <table id="dataTable" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Status</th>
                                            <th>Edit</th>
                                            <th>Change Permission</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <%
                                        List<RoleBean> items = RoleDB.getAllRole();
                                        int currentRole = Integer.parseInt(session.getAttribute("adminRole").toString());
                                        for (RoleBean item : items) {%>
                                    <tr>
                                        <td><%=item.getRole_ID()%></td>
                                        <td><%=AppUtil.formatNullString(item.getRole_Name())%></td>
                                        <td><%=AppUtil.formatNullString(item.getStatusAsString())%></td>
                                        <% if (item.getRole_Name().equalsIgnoreCase("super admin") || item.getRole_ID() == currentRole) { %>
                                        <td></td>
                                        <td></td>
                                        <% } else {
                                             if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Role", "Edit")) {%>
                                                <td><a href="editRole.jsp?rid=<%=item.getRole_ID()%>">Edit</a></td> 
                                            <% } else {%>
                                             <td></td> 
                                            <% }
                                            if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Permission", "Edit")) {%>
                                                <td><a href="editPermission.jsp?rid=<%=item.getRole_ID()%>">Change permission</a></td> 
                                         <% } else {%>
                                        <td></td> 
                                        <% }
                                            } %>
                                    </tr>
                                    <%
                                        }
                                    %>


                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                        <th>Change Permission</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>
            <%
                if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Role", "Create")) {
            %>
            <button class="btn btn-primary" id="dialog_active">New role</button>
            <br/>
            <div class="row">

                <div class="col-md-8">

                    <div class="box box-primary" id="dialog" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">Add new item</h3>
                        </div>
                        <br/>
                        
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

                        <form role="form" id="form" method="post" action="ajax-add/doAddRole.jsp">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="name">Role name</label>
                                    <input type="text" class="form-control" name="name" id="name" placeholder="Enter username">
                                </div>

                            </div>

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="reset" class="btn btn-primary">Cancel</button>
                            </div>
                        </form>
                    </div>

                </div>

            </div>   <!-- /.row -->     
            <% }%>
        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<script src="js/pages/role.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
