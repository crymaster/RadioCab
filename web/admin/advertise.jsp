<%-- 
    Document   : customer
    Created on : Aug 18, 2014, 3:04:50 PM
    Author     : quangphamngoc
--%>


<%@page import="db.CompanyDB"%>
<%@page import="beans.CompanyBean"%>
<%@page import="db.AdvertiseDB"%>
<%@page import="beans.AdvertiseBean"%>
<%@page import="db.PermissionDB"%>
<%@page import="utils.AppUtil"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    if (!PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Advertise", "View")) {
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
                    Advertise
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Advertise</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">


                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">List Advertise</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body table-responsive">
                                <table id="dataTable" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Company</th>
                                            <th>Image</th>
                                            <th>Description</th>
                                            <th>Reg date</th>
                                            <th>Status</th>
                                            <th>Edit</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <%
                                        List<AdvertiseBean> items = AdvertiseDB.getAllAdvertise();
                                        int currentRole = Integer.parseInt(session.getAttribute("adminRole").toString());
                                        for (AdvertiseBean item : items) {%>
                                    <tr>
                                        <td><%=item.getCom_ID()%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_Name())%></td>
                                        <td><img width="30px" height="30px" src="../product_images/<%=item.getAdv_Image()%>" class="img-circle"/></td>
                                        <td><%=AppUtil.formatNullString(item.getAdv_Description())%></td>
                                        <td><%=AppUtil.formatNullString(item.getAdv_Regdate().toString())%></td>
                                        <td><%=AppUtil.formatNullString(item.getStatusAsString())%></td>
                                        <% if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Advertise", "Edit")) {%>
                                        <td><a href="editAdvertise.jsp?aid=<%=item.getAdv_ID()%>">Edit</a></td> 
                                        <% } else {%>
                                        <td></td> 
                                        <% }
                                            } %>
                                    </tr>
                                </tbody>
                                <tfoot>
                                    <tr>
                                    <tr>
                                        <th>ID</th>
                                        <th>Company</th>
                                        <th>Image</th>
                                        <th>Description</th>
                                        <th>Reg date</th>
                                        <th>Status</th>
                                        <th>Edit</th>
                                    </tr>
                                    </tr>
                                </tfoot>
                            </table>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>
            <%
                if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Advertise", "Create")) {
            %>
            <button class="btn btn-primary" id="dialog_active">New advertise</button>
            <br/>
            <div class="row">

                <div class="col-md-8">

                    <div class="box box-primary" id="dialog" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">Add new item</h3>
                        </div>
                        <br/>
                        <%
                            List<CompanyBean> listSub = CompanyDB.getAllAvailableCompany();
                            if (listSub.size() == 0) {
                        %>
                        <div class="alert alert-warning alert-dismissable notification">
                            <i class="fa fa-warning"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Warning!</b> <span class="msgsuccess">You must have at least one available company before adding an advertise</span>
                            <br/><a href="company.jsp">Click here to go to company site</a>
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

                        <!-- form start -->
                        <div id="divUpload" style="display: none">
                            <form id="uploadForm" enctype="multipart/form-data" action="uploadProductImage" method="post" novalidate="novalidate">
                                <p>
                                    <label for="file">Logo</label>
                                    <input type="file" name="file" id="fileUploadInput" class="sf">
                                </p>
                            </form>
                        </div>

                        <form role="form" id="form" method="post" action="ajax-add/doAddAdvertise.jsp">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="company">Company</label>
                                    <select class="form-control" id="company"  name ="company">
                                        <%
                                            if (listSub.size() != 0) {
                                                for (CompanyBean comp : listSub) {
                                        %>
                                        <option value="<%=comp.getCom_ID()%>"><%=comp.getCom_Name()%></option>
                                        <% }
                                            } else {

                                            }%>

                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="productImage">Advertise image</label>
                                    <div class="input-group">

                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-danger triggerUpload">Choose file</button>
                                        </div><!-- /btn-group -->
                                        <input type="text" class="form-control" id="productImage" name="productImage" disabled>
                                        <input type="hidden" class="form-control" id="productImageName" name="productImageName">
                                    </div>
                                    <label id="imgErr" style="display: none; color: red">Required</label>
                                </div>

                              <div class="form-group">
                                    <label for="des">Description</label>
                                    <textarea rows="4" cols="50" type="text" class="form-control" name="des" id="des" placeholder="Enter description"></textarea>
                              </div>

                            </div>

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary" id="subButton">Submit</button>
                                <button type="reset" class="btn btn-primary">Cancel</button>
                            </div>
                        </form>
                        <% }%>
                    </div>
                </div>

            </div>   <!-- /.row -->     
            <% }%>
        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<script src="js/pages/advertises.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
