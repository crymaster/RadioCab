<%-- 
    Document   : customer
    Created on : Aug 18, 2014, 3:04:50 PM
    Author     : quangphamngoc
--%>

<%@page import="db.MembertypeDB"%>
<%@page import="beans.MembertypeBean"%>
<%@page import="db.CityDB"%>
<%@page import="beans.CityBean"%>
<%@page import="db.CompanyDB"%>
<%@page import="beans.CompanyBean"%>
<%@page import="db.PermissionDB"%>
<%@page import="utils.AppUtil"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    if (!PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Company", "View")) {
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
                    Company
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Company</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">


                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">List Companies</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body table-responsive">
                                <table id="dataTable" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Avatar</th>
                                            <th>Type</th>
                                            <th>Username</th>
                                            <th>Name</th>
                                            <th>Mobile</th>
                                            <th>Telephone</th>
                                            <th>Email</th>
                                            <th>Reg Date</th>
                                            <th>Status</th>
                                            <th>Edit</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <%
                                        List<CompanyBean> items = CompanyDB.getAllCompany();
                                        int currentRole = Integer.parseInt(session.getAttribute("adminRole").toString());
                                        for (CompanyBean item : items) {%>
                                    <tr>
                                        <td><%=item.getCom_ID()%></td>
                                        <td><img width="30px" height="30px" src="../product_images/<%=item.getCom_Image()%>" class="img-circle"/></td>
                                        <td><%=AppUtil.formatNullString(item.getMem_Name())%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_uName())%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_Name())%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_Mobile())%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_Tel())%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_Email())%></td>
                                        <td><%=AppUtil.formatNullString(item.getCom_RegDate().toString())%></td>
                                        <td><%=AppUtil.formatNullString(item.getStatusAsString())%></td>
                                        <% if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Company", "Edit")) {%>
                                        <td><a href="editCompany.jsp?did=<%=item.getCom_ID()%>">Edit</a></td> 
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
                                        <th>Avatar</th>
                                        <th>Type</th>
                                        <th>Username</th>
                                        <th>Name</th>
                                        <th>Mobile</th>
                                        <th>Telephone</th>
                                        <th>Email</th>
                                        <th>Reg Date</th>
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
                if (PermissionDB.checkPermission(session.getAttribute("adminRole").toString(), "Company", "Create")) {
            %>
            <button class="btn btn-primary" id="dialog_active">New company</button>
            <br/>
            <div class="row">

                <div class="col-md-8">

                    <div class="box box-primary" id="dialog" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">Add new item</h3>
                        </div>
                        <br/>
                        <%
                            List<CityBean> listSub = CityDB.getAllAvailableCity();
                            List<MembertypeBean> listSub1 = MembertypeDB.getAllAvailableMembertype();
                            if (listSub.size() == 0) {
                        %>
                        <div class="alert alert-warning alert-dismissable notification">
                            <i class="fa fa-warning"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
                            <b>Warning!</b> <span class="msgsuccess">You must have at least one available city before adding an company</span>
                            <br/><a href="city.jsp">Click here to go to city site</a>
                        </div>
                        <br/>
                        <% } else if (listSub1.size() == 0) { %>
                        <div class="alert alert-warning alert-dismissable notification">
                            <i class="fa fa-warning"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
                            <b>Warning!</b> <span class="msgsuccess">You must have at least one available member type before adding an company</span>
                            <br/><a href="memtype.jsp">Click here to go to member type site</a>
                        </div>
                        <br/>
                        <% } else { %>
                        <div class="alert alert-success alert-dismissable notification msg-success" style="display: none">
                            <i class="fa fa-check"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
                            <b>Notice!</b> <span class="msgsuccess">Successfully added new item</span>
                        </div>
                        <div class="alert alert-danger alert-dismissable notification msg-error" style="display: none">
                            <i class="fa fa-ban"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
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

                        <form role="form" id="form" method="post" action="ajax-add/doAddCompany.jsp">
                            <div class="box-body">

                                <div class="form-group">
                                    <label for="memtype">Member type</label>
                                    <select class="form-control" id="memtype"  name ="memtype">
                                        <%
                                            if (listSub1.size() != 0) {
                                                for (MembertypeBean mem : listSub1) {
                                        %>
                                        <option value="<%=mem.getMem_ID()%>"><%=mem.getMem_Name()%></option>
                                        <% }
                                            } else {

                                            }%>

                                    </select>
                                </div>


                                <div class="form-group">
                                    <label for="city">City</label>
                                    <select class="form-control" id="city"  name ="city">
                                        <%
                                            if (listSub.size() != 0) {
                                                for (CityBean city : listSub) {
                                        %>
                                        <option value="<%=city.getCity_ID()%>"><%=city.getCity_Name()%></option>
                                        <% }
                                            } else {

                                            }%>

                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="uname">Username</label>
                                    <input type="text" class="form-control" name="uname" id="uname" placeholder="Enter username">
                                </div>

                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
                                </div>

                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
                                </div>

                                <div class="form-group">
                                    <label for="contact">Contact person name</label>
                                    <input type="text" class="form-control" name="contact" id="contact" placeholder="Enter contact person name">
                                </div>

                                <div class="form-group">
                                    <label for="des">Designation</label>
                                    <input type="text" class="form-control" name="des" id="des" placeholder="Enter designation">
                                </div>

                                <div class="form-group">
                                    <label for="productImage">Company image</label>
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
                                    <label for="address">Address</label>
                                    <input type="text" class="form-control" name="address" id="address" placeholder="Enter address">
                                </div>

                                <div class="form-group">
                                    <label for="mobile">Mobile</label>
                                    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="Enter mobile number">
                                </div>

                                <div class="form-group">
                                    <label for="tel">Telephone</label>
                                    <input type="text" class="form-control" name="tel" id="tel" placeholder="Enter telephone number">
                                </div>

                                <div class="form-group">
                                    <label for="fax">Fax</label>
                                    <input type="text" class="form-control" name="fax" id="fax" placeholder="Enter fax number">
                                </div>

                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
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

<script src="js/pages/company.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
