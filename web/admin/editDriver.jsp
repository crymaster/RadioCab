<%-- 
    Document   : editCustomer
    Created on : Aug 18, 2014, 3:11:09 PM
    Author     : quangphamngoc
--%>

<%@page import="db.CityDB"%>
<%@page import="beans.CityBean"%>
<%@page import="db.DriverDB"%>
<%@page import="beans.DriverBean"%>
<%@page import="java.util.List"%>
<%@page import="utils.AppUtil"%>
<%@page import="db.ConfigApp"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    String id = request.getParameter("did");
    DriverBean item = DriverDB.getDriverByID(Integer.parseInt(id));
%>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">                
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                <%=item.getDriver_Name()%>
                <small>Edit Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="driver.jsp"> Drivers</a></li>
                <li class="active">Edit Driver's profile</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="col-md-8 col-md-push-2">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                         <img width="60px" height="60px" src="../product_images/<%=item.getDriver_Image()%>" class="img-circle img-profile"/>
                        <h3 class="box-title"> <%=item.getDriver_Name()%>'s profile
                            <br/>
                            <small>Registered from <%=item.getDriver_RegDate()%></small>
                        </h3>
                    </div><!-- /.box-header -->
                     <!-- form start -->
                    <div id="divUpload" style="display: none">
                        <form id="uploadForm" enctype="multipart/form-data" action="uploadProductImage" method="post" novalidate="novalidate">
                            <p>
                                <label for="file">Logo</label>
                                <input type="file" name="file" id="fileUploadInput" class="sf">
                            </p>
                        </form>
                    </div>

                    <form role="form" id="editForm" action="ajax-edit/doEditDriver.jsp">
                        <div class="box-body">

                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" name="name" id="name" value="<%=item.getDriver_Name()%>" placeholder="Enter name">
                            </div>

                            <div class="form-group">
                                <label for="contact">Contact person name</label>
                                <input type="text" class="form-control" name="contact" id="contact" value="<%=item.getDriver_Contactperson()%>" placeholder="Enter contact person name">
                            </div>

                            <div class="form-group">
                                <label for="city">City</label>
                                <select class="form-control" id="city"  name ="city">
                                    <%
                                        List<CityBean> listSub = CityDB.getAllAvailableCity();
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
                                <label for="address">Address</label>
                                <input type="text" class="form-control" name="address" id="address" value="<%=item.getDriver_Address()%>" placeholder="Enter address">
                            </div>
                            
                            <div class="form-group">
                                <label for="item-logo">Avatar</label>
                                <div class="input-group">

                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-danger triggerUpload">Choose file</button>
                                    </div><!-- /btn-group -->
                                    <input type="text" class="form-control" id="productImage" value="<%=item.getDriver_Image()%>"  name="productImage" disabled>
                                    <input type="hidden" class="form-control" id="productImageName" value="<%=item.getDriver_Image()%>" name="productImageName">
                                </div>
                                <label id="imgErr" style="display: none; color: red">Required</label>
                            </div>

                            <div class="form-group">
                                <label for="mobile">Mobile</label>
                                <input type="text" class="form-control" name="mobile" id="mobile" value="<%=item.getDriver_Mobile()%>" placeholder="Enter mobile number">
                            </div>

                            <div class="form-group">
                                <label for="tel">Telephone</label>
                                <input type="text" class="form-control" name="tel" id="tel" value="<%=item.getDriver_Tel()%>" placeholder="Enter telephone number">
                            </div>

                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" value="<%=item.getDriver_Email()%>" placeholder="Enter email">
                            </div>

                            <div class="form-group">
                                <label for="exp">Experience</label>
                                <input type="text" class="form-control" name="exp" id="exp" value="<%=item.getDriver_Exp()%>" placeholder="Enter experience">
                            </div>

                            <div class="form-group">
                                <label for="des">Description</label>
                                <input type="text" class="form-control" name="des" id="des" value="<%=item.getDriver_Description()%>" placeholder="Enter description">
                            </div>

                            <div class="form-group">
                                <label for="status">Status</label>
                                <select class="form-control" id="status"  name ="status">
                                    <option value="<%=ConfigApp.statusOKValue%>"><%=ConfigApp.statusOK%></option>
                                    <option value="<%=ConfigApp.statusNotOKValue%>"><%=ConfigApp.statusNotOK%></option>
                                    <option value="<%=ConfigApp.statusNotActiveValue%>"><%=ConfigApp.statusNotActive%></option>
                                </select>
                                <script>
                                    $(function() {
                                        $("#city").val(<%=item.getCity_ID()%>);
                                        $("#status").val(<%=item.getDriver_Status()%>);
                                    });
                                </script>
                            </div>
                            <input type="hidden" name="itemID" value="<%=item.getDriver_ID()%>" >
                        </div><!-- /.box-body -->

                        <br/>
                        <div class="alert alert-success alert-dismissable notification" style="display: none">
                            <i class="fa fa-check"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <b>Notice!</b> <span class="msgsuccess">Successfully edited item!</span>
                            <br> Click <a href="driver.jsp">here</a> to view driver list
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

<script src="js/pages/driver.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>