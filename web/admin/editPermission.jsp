<%-- 
    Document   : editGroup
    Created on : Aug 19, 2014, 1:23:41 AM
    Author     : quangphamngoc
--%>

<%@page import="db.ActionDB"%>
<%@page import="beans.ActionBean"%>
<%@page import="db.RoleDB"%>
<%@page import="beans.RoleBean"%>
<%@page import="db.PermissionDB"%>
<%@page import="beans.PermissionBean"%>
<%@page import="java.util.List"%>
<%@page import="db.ConfigApp"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    String id = request.getParameter("rid");
    List<ActionBean> listAct = ActionDB.getAllAction();
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
                <small>Edit Permission Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="role.jsp"> Role</a></li>
                <li class="active">Edit Permission</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="col-md-8 col-md-push-2">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title"> <%=item.getRole_Name()%></h3>
                    </div><!-- /.box-header -->
                    <!-- form start -->

                    <form role="form" id="perForm" action="ajax-edit/doEditPermission.jsp">
                        <div class="box-body">
                            <%
                                String previous = "";
                                for (ActionBean act : listAct) {
                                    if (previous.equalsIgnoreCase(act.getActModel())) {
                                        continue;
                                    }
                                    previous = act.getActModel();
                                    List<ActionBean> temp = ActionDB.getActionByModule(act.getActModel());
                            %>
                            <div class="form-group">
                                <label><%=act.getActModel()%> Management</label> <br/>
                                <% for (ActionBean mini : temp) {
                                        PermissionBean test = PermissionDB.getPermission(Integer.parseInt(id), mini.getActID());
                                        if (test.getPerStatus() == 1) {

                                %>  
                                    <input type="checkbox" checked="checked" class="form-control" name="<%=mini.getActID()%>" id="<%=mini.getActID()%>" value="1" > <%=mini.getActAction()%>
                                <% } else {%>
                                    <input type="checkbox" class="form-control" name="<%=mini.getActID()%>" id="<%=mini.getActID()%>" value="1" > <%=mini.getActAction()%>
                                <% } }%>
                            </div>
                            <%  }%>
                        </div>
                        <input type="hidden" name="itemID" value="<%=item.getRole_ID()%>" >
                        </div><!-- /.box-body -->

                        <br/>
                        <div class="alert alert-success alert-dismissable notification" style="display: none">
                            <i class="fa fa-check"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Notice!</b> <span class="msgsuccess">Successfully edited item!</span>
                            <br> Click <a href="group.jsp">here</a> to view group list
                        </div>
                        <div class="alert alert-danger alert-dismissable notification" style="display: none">
                            <i class="fa fa-ban"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Error!</b> <span class="msgsuccess">Please try again</span>
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