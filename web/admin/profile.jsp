<%@page import="db.AdminDB"%>
<%@page import="db.LoginDB"%>
<%@page import="beans.AdminBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<jsp:include page="header.jsp"></jsp:include>

<%
    AdminBean curAdmin = new AdminBean();
    try{
        curAdmin = LoginDB.currentAdmin;
    } catch (Exception ex){
        int id = Integer.parseInt(request.getSession().getAttribute("adminID").toString());
        curAdmin = AdminDB.getAdminByID(id);
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
                <%=curAdmin.getAd_Account()%> 's Profile
                <small><%=curAdmin.getRole_Name()%></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Profile</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- left column -->
                <div class="col-md-6">
                    <!-- general form elements disabled -->
                    <div class="box box-warning">
                        <div class="box-header">
                            <h3 class="box-title">General Information</h3>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <form role="form">

                                <!-- fullname input -->
                                <div class="form-group">
                                    <label>Phone</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-laptop"></i>
                                        </div>
                                        <input type="text" class="form-control" data-inputmask="'alias': 'phone'" data-mask="" disabled  value="<%=curAdmin.getAd_Phone()%>"   />
                                    </div><!-- /.input group -->
                                </div>

                                <!-- fullname input -->
                                <div class="form-group">
                                    <label>Email</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-laptop"></i>
                                        </div>
                                        <input type="text" class="form-control" data-inputmask="'alias': 'email'" data-mask="" disabled  value="<%=curAdmin.getAd_Email()%>"   />
                                    </div><!-- /.input group -->
                                </div>

                            </form>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!--/.col (left) -->
                <!-- right column -->



                <div class="col-md-6">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Change password</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" id="editFormPassword" action="ajax-edit/doEditProfile.jsp?change=password">
                            <div class="box-body">
                                <div class="alert alert-success alert-dismissable notification-pw success-pw" style="display: none">
                                    <i class="fa fa-check"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    <b>Notice!</b> <span class="msgsuccess-pw">Successfully update password!</span>
                                </div>
                                <div class="alert alert-danger alert-dismissable notification-pw danger-pw" style="display: none">
                                    <i class="fa fa-ban"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    <b>Error!</b> <span class="msgdanger-pw">Please try again</span>
                                </div>
                                <div class="form-group">
                                    <label for="oldPassword">Old password</label>
                                    <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="Enter old pasword">
                                </div>
                                <div class="form-group">
                                    <label for="newPassword">New password</label>
                                    <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Enter new pasword">
                                </div>
                                <div class="form-group">
                                    <label for="confirmPassword">Confirm password</label>
                                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm new  pasword">
                                </div>

                            </div><!-- /.box-body -->
                            <input type="hidden" name="itemID" value="<%=curAdmin.getAd_ID()%>" />
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div><!-- /.box -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Change Avatar</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" id="editFormAvatar" action="ajax-edit/doEditProfile.jsp?change=avatar">
                            <div class="box-body">
                                <div class="alert alert-success alert-dismissable notification" style="display: none">
                                    <i class="fa fa-check"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    <b>Notice!</b> <span class="msgsuccess">Successfully update avatar!</span>
                                </div>
                                <div class="alert alert-danger alert-dismissable notification" style="display: none">
                                    <i class="fa fa-ban"></i>
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                    <b>Error!</b> <span class="msgsuccess">Please try again</span>
                                </div>
                                <div class="form-group">
                                    <label for="item-logo">Logo</label>
                                    <div class="input-group">

                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-danger triggerUpload">Choose file</button>
                                        </div><!-- /btn-group -->
                                        <input type="text" class="form-control" id="logo" name="logo" disabled>
                                        <input type="hidden" class="form-control" id="avatar" name="avatar">

                                    </div>
                                </div>
                                <input type="hidden" name="itemID" value="<%=curAdmin.getAd_ID()%>" />
                            </div><!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary changeAvatarSubmit">Submit</button>
                            </div>
                        </form>
                    </div><!-- /.box -->
                    <div id="divUpload" style="display: none">
                        <form id="uploadForm" enctype="multipart/form-data" action="uploadFile" method="post" novalidate="novalidate">
                            <p>
                                <label for="file">Logo</label>
                                <input type="file" name="file" id="fileUploadInput" class="sf">
                            </p>
                        </form>
                    </div>



                </div><!--/.col (right) -->
            </div>   <!-- /.row -->
        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->


<script src="js/pages/profile.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
