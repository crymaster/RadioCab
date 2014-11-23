/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function() {

    $('.sidebar-menu').find('li').removeClass('active');
    $('.sb-customer').parent('li').addClass('active');

    document.title = "Advertise Management";
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
            productImage: {
                required: true,
            },
            des: {
                required: true
            }
        },
        messages: {
            des: {
                required: "Required"
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
                            $('#company').text(),
                            "<img width='30px' height='30px' src='../product_images/" + $("#productImageName").val() + "' class='img-circle'/>",
                            $('#des').val(),
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
            des: {
                required: true
            }
        },
        messages: {
            des: {
                required: "Required"
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
