<%-- 
    Document   : editCustomer
    Created on : Aug 18, 2014, 3:11:09 PM
    Author     : quangphamngoc
--%>

<%@page import="db.AdvertiseDB"%>
<%@page import="beans.AdvertiseBean"%>
<%@page import="db.CompanyDB"%>
<%@page import="beans.CompanyBean"%>
<%@page import="java.util.List"%>
<%@page import="utils.AppUtil"%>
<%@page import="db.ConfigApp"%>
<jsp:include page="header.jsp"></jsp:include>
<%
    String id = request.getParameter("aid");
    AdvertiseBean item = AdvertiseDB.getAdvertiseByID(Integer.parseInt(id));
    List<CompanyBean> listSub = CompanyDB.getAllAvailableCompany();
%>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">                
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                <%=item.getCom_Name()%>
                <small>'s Advertise Edit Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="driver.jsp"> Advertises</a></li>
                <li class="active">Edit Advertise's profile</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="col-md-8 col-md-push-2">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <img width="60px" height="60px" src="../product_images/<%=item.getAdv_Image()%>" class="img-circle img-profile"/>
                        <h3 class="box-title"> <%=item.getCom_Name()%> Advertise's profile
                            <br/>
                            <small>Registered from <%=item.getAdv_Regdate()%></small>
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

                    <form role="form" id="editForm" method="post" action="ajax-edit/doEditAdvertise.jsp">
                        <div class="box-body">

                            <div class="form-group">
                                <label for="comp">Company</label>
                                <select class="form-control" id="comp"  name ="comp">
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
                                <label for="item-logo">Advertise image</label>
                                <div class="input-group">

                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-danger triggerUpload">Choose file</button>
                                    </div><!-- /btn-group -->
                                    <input type="text" class="form-control" id="productImage" value="<%=item.getAdv_Image()%>"  name="productImage" disabled>
                                    <input type="hidden" class="form-control" id="productImageName" value="<%=item.getAdv_Image()%>" name="productImageName">
                                </div>
                                <label id="imgErr" style="display: none; color: red">Required</label>
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
                                        $("#comp").val(<%=item.getCom_ID()%>);
                                        $("#status").val(<%=item.getAdv_Status()%>);
                                    });
                                </script>
                            </div>

                            <div class="form-group">
                                <label for="des">Description</label>
                                <textarea rows="4" cols="50" type="text" class="form-control" name="des" id="des" placeholder="Enter description"><%=item.getAdv_Description()%>
                                </textarea>
                            </div>

                            <input type="hidden" name="itemID" value="<%=item.getCom_ID()%>" >

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
                            <button type="submit" class="btn btn-primary" id="subButton">Submit</button>
                        </div>
                    </form>  
                </div><!-- /.box -->
            </div><!--/.col (right) -->

        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<script src="js/pages/advertises.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>