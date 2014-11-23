<%-- 
    Document   : editCustomer
    Created on : Aug 18, 2014, 3:11:09 PM
    Author     : quangphamngoc
--%>

<%@page import="beans.RoleBean"%>
<%@page import="db.RoleDB"%>
<%@page import="java.util.List"%>
<%@page import="utils.AppUtil"%>
<%@page import="db.ConfigApp"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    String id = request.getParameter("rid");
    RoleBean item = RoleDB.getRoleByID(Integer.parseInt(id));
%>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">                
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                <%=item.getRole_Name()%>
                <small>Edit Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="role.jsp"> Roles</a></li>
                <li class="active">Edit Role's profile</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="col-md-8 col-md-push-2">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title"> <%=item.getRole_Name()%>'s profile</h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->
                    
                    <form role="form" id="editForm" action="ajax-edit/doEditRole.jsp">
                        <div class="box-body">

                            <div class="form-group">
                                <label for="status">Status</label>

                                <select class="form-control" id="status"  name ="status">
                                    <%
                                        if (item.getRole_status()== 1) {
                                    %> 
                                    <option value="<%=ConfigApp.statusOKValue%>" selected="selected"><%=ConfigApp.statusOK%></option>
                                    <option value="<%=ConfigApp.statusNotOKValue%>"><%=ConfigApp.statusNotOK%></option>
                                    <%
                                        } else { 
                                    %>
                                    <option value="<%=ConfigApp.statusOKValue%>"><%=ConfigApp.statusOK%></option>
                                    <option value="<%=ConfigApp.statusNotOKValue%>" selected="selected"><%=ConfigApp.statusNotOK%></option>
                                    <% } %>
                                </select>
                            </div>
                                    <input type="hidden" name="itemID" value="<%=item.getRole_ID()%>" >
                            </div><!-- /.box-body -->

                            <br/>
                    <div class="alert alert-success alert-dismissable notification" style="display: none">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <b>Notice!</b> <span class="msgsuccess">Successfully edited item!</span>
                        <br> Click <a href="role.jsp">here</a> to view role list
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

<script src="js/pages/role.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>