<%-- 
    Document   : editCustomer
    Created on : Aug 18, 2014, 3:11:09 PM
    Author     : quangphamngoc
--%>

<%@page import="beans.RoleBean"%>
<%@page import="db.RoleDB"%>
<%@page import="java.util.List"%>
<%@page import="db.AdminDB"%>
<%@page import="beans.AdminBean"%>
<%@page import="utils.AppUtil"%>
<%@page import="db.ConfigApp"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    String id = request.getParameter("aid");
    AdminBean item = AdminDB.getAdminByID(Integer.parseInt(id));
%>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">                
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                <%=item.getAd_Account()%>
                <small>Edit Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="admin.jsp"> Admin</a></li>
                <li class="active">Edit Admin's profile</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="col-md-8 col-md-push-2">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title"> <%=item.getAd_Account()%>'s profile</h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->

                    <form role="form" id="editForm" action="ajax-edit/doEditAdmin.jsp">
                        <div class="box-body">
                            <%
                                List<RoleBean> listRole = RoleDB.getAllAvailableRole();

                            %>

                            <div class="form-group">
                                <label for="role">Role</label>
                                <select class="form-control" id="role"  name ="role">
                                    <%                                            if (listRole.size() != 0) {
                                            for (RoleBean role : listRole) {
                                    %>
                                    <option value="<%=role.getRole_ID()%>"><%=role.getRole_Name()%></option>
                                    <% }
                                        } else {

                                        }%>

                                </select>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" value="<%=item.getAd_Email()%>" placeholder="Enter email">
                            </div>

                            <div class="form-group">
                                <label for="phone">Phone</label>
                                <input type="number" class="form-control" name="phone" id="phone" value="<%=item.getAd_Phone()%>" placeholder="Enter phone">
                            </div>

                            <div class="form-group">
                                <label for="status">Status</label>
                                <select class="form-control" id="status"  name ="status">
                                    <option value="<%=ConfigApp.statusOKValue%>"><%=ConfigApp.statusOK%></option>
                                    <option value="<%=ConfigApp.statusNotOKValue%>"><%=ConfigApp.statusNotOK%></option>
                                </select>
                                <script>
                                    $(function() {
                                        $("#role").val(<%=item.getRole_ID()%>);
                                        $("#status").val(<%=item.getAd_Status()%>);
                                    });
                                </script>
                            </div>
                            <input type="hidden" name="itemID" value="<%=item.getAd_ID()%>" >
                        </div><!-- /.box-body -->

                        <br/>
                        <div class="alert alert-success alert-dismissable notification" style="display: none">
                            <i class="fa fa-check"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Notice!</b> <span class="msgsuccess">Successfully edited item!</span>
                            <br> Click <a href="admin.jsp">here</a> to view admin list
                        </div>
                        <div class="alert alert-danger alert-dismissable notification" style="display: none">
                            <i class="fa fa-ban"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Error!</b> <span class="msgerror">Please try again</span>
                        </div>
                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>


                </div><!-- /.box -->
            </div><!--/.col (right) -->

        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<script src="js/pages/admin.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>