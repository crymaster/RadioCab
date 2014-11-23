/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function() {
    $('.sidebar-menu').find('li').removeClass('active');
    $('.sb-customer').parent('li').addClass('active');

    document.title = "Admin Management";
    $('#dataTable').dataTable({
        "bPaginate": true,
        "bLengthChange": true,
        "bFilter": true,
        "bSort": true,
        "bInfo": true,
        "bAutoWidth": true
    });

    $("#form").validate({
        rules: {
            userName: {
                required: true,
                rangelength: [6, 50]
            },
            password: {
                required: true,
                rangelength: [6, 50]
            },
            email: {
                required: true,
                rangelength: [3, 50]
            },
            phone: {
                required: true,
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            }
        },
        messages: {
            userName: {
                required : "Required",
                rangelength: "6-50 characters"
            },
            password: {
                required : "Required",
                rangelength: "6-50 characters"
            },
            email: {
                required : "Required",
                rangelength: "3-50 characters"
            },
            phone:{
                required: "Required",
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            }
        },
        submitHandler: function() {
            var data_form = $('#form').serialize();
            console.log(data_form);
            console.log($("#form"));
            $.ajax({
                type: 'post',
                url: $('#form').attr('action'),
                data: data_form,
                dataType: 'json',
                success: function(rs) {
                    if (rs.status) {
                        $('.notification').hide();

                        $('.msgsuccess').text(rs.msg);
                        $('.msg-success').fadeIn('slow');

                        $('#dataTable').dataTable().fnAddData([
                            rs.insertedID,
                            "<img width='30px' height='30px' src='../app_images/user.jpg' class='img-circle'/>",
                            $('#userName').val(),
                            $('#role').find('option:selected').text(),
                            $('#email').val(),
                            $('#phone').val(),
                            "Enable",
                            "<a href='editAdmin.jsp?aid=" + rs.insertedID + "'>Edit</a> "
                        ]);
                        console.log(rs.msg);
                        /*$('html, body').animate({
                         scrollTop: $('.msgsuccess').offset().top-30
                         }, 2000);*/
                        $('#form').trigger('reset');
                        $("#dialog" ).fadeOut();
                    }
                    else {
                        $('.notification').hide();
                        $('.msgerror').text(rs.msg);
                        $('.msg-error').fadeIn('slow');

                    }
                    var hideNoti = setTimeout(function() {
                        $('.notification').fadeOut('slow');
                    }, 2000);
                    return false;
                }
            });
            return false;
        }

    });



    $("#editForm").validate({
        rules: {
            email: {
                required: true,
                rangelength: [3, 50]
            },
            phone: {
                required: true,
                number: true,
                positiveNumber: true,
                rangelength: [10, 20]
            }
        },
        messages: {
            email: {
                required : "Required",
                rangelength: "3-50 characters"
            },
            phone:{
                required: "Required",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            }
    },
        submitHandler: function() {
            var data_form = $('#editForm').serialize();
            console.log(data_form);
            $.ajax({
                type: 'post',
                url: $('#editForm').attr('action'),
                data: data_form,
                dataType: 'json',
                success: function(rs) {
                    if (rs.status) {
                        $('.notification').hide();
                        $('.alert-success').fadeIn('slow');
                    }
                    else {
                        $('.notification').hide();
                        $('.msgerror').text(rs.msg);
                        $('.alert-danger').fadeIn('slow');
                    }
                    var hideNoti = setTimeout(function() {
                        $('.notification').fadeOut('slow');
                    }, 2000);
                    return false;
                }, error: function(xhr, ajaxOptions, thrownError) {
                    if(xhr.status == "500"){
                        $('.notification').hide();
                        $('.msgerror').text("Internal Server Error!");
                        $('.alert-danger').fadeIn('slow');
                    }
                    var hideNoti = setTimeout(function() {
                        $('.notification').fadeOut('slow');
                    }, 2000);
                }
                
            });
            return false;
        }

    });


});


