/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function() {

    $('.sidebar-menu').find('li').removeClass('active');
    $('.sb-customer').parent('li').addClass('active');

    document.title = "Company Management";
    $('#dataTable').dataTable({
        "bPaginate": true,
        "bLengthChange": true,
        "bFilter": true,
        "bSort": true,
        "bInfo": true,
        "bAutoWidth": true
    });

    /*
     * 
     * Upload
     */
    $(".triggerUpload").click(function() {
        $("#fileUploadInput").trigger("click");
    });

    $('#fileUploadInput').change(function()
    {
        $("#uploadForm").ajaxForm(
                {
                    success: showResponse, // post-submit callback
                    dataType: 'json'
                }).submit();
    });

    function showResponse(data) {
        console.log("link: " + data.msg);
        console.log("name: " + data.fileName);
        $("#productImageName").val(data.fileName);
        $("#productImage").val(data.fileName);
        $("#imgErr").hide();
        return false;
    }

    $("#subButton").click(function() {
        if ($("#productImageName").val().length == 0) {
            $("#imgErr").show();
        } else {
            $("#imgErr").hide();
        }
    });

    /*
     * End upload
     */

    $("#form").validate({
        rules: {
            uname: {
                required: true,
                rangelength: [6, 50]
            },
            password: {
                required: true,
                rangelength: [6, 50]
            },
            name: {
                required: true,
                rangelength: [6, 100]
            },
            contact: {
                required: true,
                rangelength: [6, 50]
            },
            des: {
                required: true,
                rangelength: [6, 50]
            },
            productImage: {
                required: true,
            },
            address: {
                required: true,
                rangelength: [6, 100]
            },
            mobile: {
                required: true,
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            },
            tel: {
                required: true,
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            },
            fax: {
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            },
            email: {
                required: true,
                rangelength: [3, 50]
            }
        },
        messages: {
            uname: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            password: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            name: {
                required: "Required",
                rangelength: "6-100 characters"
            },
            contact: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            des: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            address: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            mobile: {
                required: "Required",
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            },
            tel: {
                required: "Required",
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            },
            fax: {
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            },
            email: {
                required: "Required",
                rangelength: "3-50 characters"
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
                        var temp = new Date();
                        var m = temp.getMonth() + 1;
                        var time = temp.getFullYear() + "-" + m + "-" + temp.getDate() + " " + temp.getHours() + ":" + temp.getMinutes() + ":" + temp.getSeconds() + "." + temp.getMilliseconds();
                        $('#dataTable').dataTable().fnAddData([
                            rs.insertedID,
                            "<img width='30px' height='30px' src='../product_images/" + $("#productImageName").val() + "' class='img-circle'/>",
                            $('#memtype').val(),
                            $('#uname').val(),
                            $('#name').val(),
                            $('#mobile').val(),
                            $('#tel').val(),
                            $('#email').val(),
                            time,
                            "Enable",
                            "<a href='editCompany.jsp?cid=" + rs.insertedID + "'>Edit</a> "
                        ]);
                        console.log(rs.msg);
                        /*$('html, body').animate({
                         scrollTop: $('.msgsuccess').offset().top-30
                         }, 2000);*/
                        $('#form').trigger('reset');
                        $("#dialog").fadeOut();
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
            uname: {
                required: true,
                rangelength: [6, 50]
            },
            password: {
                required: true,
                rangelength: [6, 50]
            },
            name: {
                required: true,
                rangelength: [6, 100]
            },
            contact: {
                required: true,
                rangelength: [6, 50]
            },
            des: {
                required: true,
                rangelength: [6, 50]
            },
            address: {
                required: true,
                rangelength: [6, 100]
            },
            mobile: {
                required: true,
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            },
            tel: {
                required: true,
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            },
            fax: {
                floatNumber: true,
                positiveNumber: true,
                rangelength: [10, 20]
            },
            email: {
                required: true,
                rangelength: [3, 50]
            }
        },
        messages: {
            uname: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            password: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            name: {
                required: "Required",
                rangelength: "6-100 characters"
            },
            contact: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            des: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            address: {
                required: "Required",
                rangelength: "6-50 characters"
            },
            mobile: {
                required: "Required",
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            },
            tel: {
                required: "Required",
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            },
            fax: {
                floatNumber: "Decimal numbers",
                positiveNumber: "Positive numbers",
                rangelength: "10-20 characters"
            },
            email: {
                required: "Required",
                rangelength: "3-50 characters"
            }
        },
        submitHandler: function() {
            var data_form = $('#editForm').serialize();
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
                    if (xhr.status == "500") {
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


