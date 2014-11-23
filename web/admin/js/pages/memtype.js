/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function() {
    $('.sidebar-menu').find('li').removeClass('active');
    $('.sb-customer').parent('li').addClass('active');

    document.title = "Member Type Management";
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
            name: {
                required: true,
                rangelength: [3, 50]
            },
            fee: {
                required: true,
                positiveNumber: true
            }
        },
        messages: {
            name: {
                required : "Required",
                rangelength: "3-50 characters"
            },
            fee: {
                required: "Required",
                positiveNumber: "Positive numbers"
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
                            $('#name').val(),
                            $('#fee').val()+"$",
                            "Enable",
                            "<a href='editMemtype.jsp?mid=" + rs.insertedID + "'>Edit</a>"
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
            fee: {
                required: true,
                positiveNumber: true
            }
        },
        messages: {
            fee: {
                required: "Required",
                positiveNumber: "Positive numbers"
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
    
     $("#perForm").validate({
        rules: {},
        messages: {},
        submitHandler: function() {
            var data_form = $('#perForm').serialize();
            console.log(data_form);
            $.ajax({
                type: 'post',
                url: $('#perForm').attr('action'),
                data: data_form,
                dataType: 'json',
                success: function(rs) {
                    if (rs.status) {
                        $('.notification').hide();
                        $('.alert-success').fadeIn('slow');
                        $('#editForm').trigger('reset');
                    }
                    else {
                        $('.notification').hide();
                        $('.msgerror').text(rs.msg);
                        $('.alert-danger').fadeIn('slow');
                    }
                    var hideNoti = setTimeout(function() {
                        $('.notification').fadeOut('slow');
                        window.location.assign("../admin/dashboard.jsp")
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


