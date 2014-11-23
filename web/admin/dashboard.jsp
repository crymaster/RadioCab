

<jsp:include page="header.jsp"></jsp:include>

    <div class="wrapper row-offcanvas row-offcanvas-left">
        <!-- Left side column. contains the logo and sidebar -->

    <jsp:include page="sidebar.jsp"></jsp:include>
        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Dashboard
                    <small>Control panel</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Dashboard</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">

                <!-- Small boxes (Stat box) -->
                <div class="row">
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                            <div class="inner">
                                <h3>
                                <%--
                                    int orderCount = BillDB.countNewOrder();
                                    out.print(orderCount);
                                --%>
                            </h3>
                            <p>
                                New Orders
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-bag"></i>
                        </div>
                        <a href="order.jsp" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-purple">
                        <div class="inner">
                            <h3>
                                <%--=ProductDB.countTotalProduct()--%>
                            </h3>
                            <p>
                                Products
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-ios7-briefcase-outline"></i>
                        </div>
                        <a href="product.jsp" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3>
                                <%--
                                    int userCount = CustomerDB.totalCustomerCount();
                                    out.print(userCount);
                                --%>
                            </h3>
                            <p>
                                User Registrations
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-add"></i>
                        </div>
                        <a href="admin.jsp" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div><!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-maroon">
                        <div class="inner">
                            <h3>
                                <%--=//OfferDB.totalActiveEvent()--%><sup style="font-size: 20px"></sup>
                            </h3>
                            <p>
                                Active Events
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-ios7-pricetag-outline"></i>
                        </div>
                        <a href="events.jsp" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
            </div><!-- /.row -->


            <div class="row">
                <div class="col-lg-4 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-blue">
                                <div class="inner">
                                    <h3>
                                        <%--=//CategoryDB.countTotalCategory() --%>
                                    </h3>
                                    <p>
                                        Categories
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-ios7-cart-outline"></i>
                                </div>
                                <a href="category.jsp" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div>
                <div class="col-lg-4 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3>
                                <%--=GroupDB.countTotalGroup() --%>
                            </h3>
                            <p>
                                Groups
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-pie-graph"></i>
                        </div>
                        <a href="group.jsp" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
                <div class="col-lg-4 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3>
                                <%--=ProviderDB.countTotalBrand() --%>
                            </h3>
                            <p>
                                Brands
                            </p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-stats-bars"></i>
                        </div>
                        <a href="provider.jsp" class="small-box-footer">
                            More info <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
            </div><!-- /.row -->

            <!-- Main row -->


        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<!-- add new calendar event modal -->
<script src="js/pages/home.js" type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>