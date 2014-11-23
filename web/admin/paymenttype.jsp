<%-- 
    Document   : customer
    Created on : Aug 18, 2014, 3:04:50 PM
    Author     : quangphamngoc
--%>

<%@page import="db.PaymenttypeDB"%>
<%@page import="beans.PaymenttypeBean"%>
<%@page import="db.PermissionDB"%>
<%@page import="utils.AppUtil"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    if (!PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "PaymentType", "View")) {
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
                    Payment Type
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Payment Type</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">


                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">List types</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body table-responsive">
                                <table id="dataTable" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>For</th>
                                            <th>Name</th>
                                            <th>Fee</th>
                                            <th>Status</th>
                                            <th>Edit</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <%
                                        List<PaymenttypeBean> items = PaymenttypeDB.getAllPaymenttype();
                                        int currentRole = Integer.parseInt(session.getAttribute("adminRole").toString());
                                        for (PaymenttypeBean item : items) {%>
                                    <tr>
                                        <td><%=item.getPaytype_ID()%></td>
                                        <td><%=AppUtil.formatNullString(item.getPaytype_For())%></td>
                                        <td><%=AppUtil.formatNullString(item.getPaytype_Name())%></td>
                                        <td><%=AppUtil.formatMoneyNumber(item.getPaytype_Fee())%></td>
                                        <td><%=AppUtil.formatNullString(item.getStatusAsString())%></td>
                                        <% if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "PaymentType", "Edit")) {%>
                                        <td><a href="editPaytype.jsp?pid=<%=item.getPaytype_ID()%>">Edit</a></td> 
                                        <% } else {%>
                                        <td></td> 
                                        <% }
                                            } %>
                                    </tr>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>For</th>
                                        <th>Name</th>
                                        <th>Fee</th>
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
                if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "PaymentType", "Create")) {
            %>
            <button class="btn btn-primary" id="dialog_active">New type</button>
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

                        <form role="form" id="form" method="post" action="ajax-add/doAddPaytype.jsp">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="fors">Payment type for</label>
                                    <select class="form-control" id="fors"  name ="fors">
                                        <option value="Company">Company</option>
                                        <option value="Driver">Driver</option>
                                        <option value="Advertise">Advertise</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="name">Payment type</label>
                                    <select class="form-control" id="name"  name ="name">
                                        <option value="Monthly">Monthly</option>
                                        <option value="Quarterly">Quarterly</option>
                                    </select>
                                </div>

                                <input type="hidden" class="form-control" name="day" id="day">

                                <div class="form-group">
                                    <label for="fee">Fee</label>
                                    <input type="text" class="form-control" name="fee" id="fee" placeholder="Enter number">
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

<script src="js/pages/paytype.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
