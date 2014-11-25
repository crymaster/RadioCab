<%-- 
    Document   : layout
    Created on : Nov 23, 2014, 5:45:54 PM
    Author     : Son
--%>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title><tiles:getAsString name="title"/></title>
        <meta charset="utf-8">
        <meta name = "format-detection" content = "telephone=no" />
        <link rel="icon" href="frontend/images/favicon.ico">
        <link rel="shortcut icon" href="frontend/images/favicon.ico" />
        <link rel="stylesheet" href="frontend/css/booking.css">
        <link rel="stylesheet" href="frontend/css/camera.css">
        <link rel="stylesheet" href="frontend/css/form.css">
        <link rel="stylesheet" href="frontend/css/owl.carousel.css">
        <link rel="stylesheet" href="frontend/css/style.css">
        <script src="frontend/js/jquery.js"></script>
        <script src="frontend/js/jquery-migrate-1.2.1.js"></script>
        <script src="frontend/js/script.js"></script>
        <script src="frontend/js/superfish.js"></script>
        <script src="frontend/js/jquery.ui.totop.js"></script>
        <script src="frontend/js/jquery.equalheights.js"></script>
        <script src="frontend/js/jquery.mobilemenu.js"></script>
        <script src="frontend/js/jquery.easing.1.3.js"></script>
        <script src="frontend/js/owl.carousel.js"></script>
        <script src="frontend/js/camera.js"></script>
        <script src="frontend/js/TMForm.js"></script>
        <!--[if (gt IE 9)|!(IE)]><!-->
        <script src="frontend/js/jquery.mobile.customized.min.js"></script>
        <!--<![endif]-->
        <script src="frontend/js/booking.js"></script>
        <script>
            $(document).ready(function () {
                jQuery('#camera_wrap').camera({
                    loader: false,
                    pagination: false,
                    minHeight: '444',
                    thumbnails: false,
                    height: '28.28125%',
                    caption: true,
                    navigation: true,
                    fx: 'mosaic'
                });
                $().UItoTop({easingType: 'easeOutQuart'});
            });
        </script>
        <!--[if lt IE 8]>
                <div style=' clear: both; text-align:center; position: relative;'>
                        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
                                <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
                        </a>
                </div>
                <![endif]-->
        <!--[if lt IE 9]>
                <script src="js/html5shiv.js"></script>
                <link rel="stylesheet" media="screen" href="css/ie.css">
        <![endif]-->
    </head>

    <body class="page1" id="top">
        <div class="main">

            <tiles:insert attribute="header"/>
            
            <tiles:insert attribute="body"/> 
        </div>

        <tiles:insert attribute="footer"/> 
        <script>
            $(function () {
                $('#bookingForm').bookingForm({
                    ownerEmail: '#'
                });
            })
            $(function () {
                $('#bookingForm input, #bookingForm textarea').placeholder();
            });
        </script>
    </body>
</html>