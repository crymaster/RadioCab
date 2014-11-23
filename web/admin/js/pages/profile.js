/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function() {
    document.title = "Profile";
    /*
     * 
     * Upload
     */
    $(".triggerUpload").click(function() {
        $("#fileUploadInput").trigger("click");
    });

    $('#fileUploadInput').change(function()
    {
        console.log("changed");
        $("#uploadForm").ajaxForm(
                {
                    success: showResponse, // post-submit callback
                    dataType: 'json'
                }).submit();
    });

    function showResponse(data) {
        console.log("link: " + data.msg);
        console.log("name: " + data.fileName);
        $("#logo").val(data.fileName);
        $("#avatar").val(data.fileName);
        return false;
    }

    /*
     * End upload
     */

    $("#editFormAvatar").validate({
        rules: {
            name: "required"
        },
        messages: {
            name: "Please enter the item name"
        },
        submitHandler: function() {
            var data_form = $('#editFormAvatar').serialize();
            console.log(data_form);
            $.ajax({
                type: 'post',
                url: $('#editFormAvatar').attr('action'),
                data: data_form,
                dataType: 'json',
                success: function(rs) {
                    if (rs.status) {
                        $('.notification').hide();
                        $('.alert-success').fadeIn('slow');
                    }
                    else {
                        $('.notification').hide();
                        $('.alert-danger').fadeIn('slow');
                    }
                    var hideNotice = setTimeout(function(){
                                    $('.notification').fadeOut('slow');
                                },2000);
                    return false;
                }
            });
            return false;
        }
    });

    $("#editFormPassword").validate({
        rules: {
            oldPassword: "required",
            newPassword: {
                required : true,
                rangelength: [6, 12]
            },
            confirmPassword:{
                equalTo: "#newPassword"
            }
        },
        messages: {
            oldPassword: "Required",
            newPassword: {
                required : "Required",
                rangelength: "6-12 characters"
            },
            confirmPassword: "Mismatching"
        },
        submitHandler: function() {
            var data_form = $('#editFormPassword').serialize();
            console.log(data_form);
            $.ajax({
                type: 'post',
                url: $('#editFormPassword').attr('action'),
                data: data_form,
                dataType: 'json',
                success: function(rs) {
                    if (rs.status) {
                        $('.notification-pw').hide();
                        $('.msgsuccess-pw').text(rs.msg);
                        $('.success-pw').fadeIn('slow');
                    }
                    else {
                        $('.notification-pw').hide();
                        $('.msgdanger-pw').text(rs.msg);
                        $('.danger-pw').fadeIn('slow');
                    }
                    var hideNotice = setTimeout(function(){
                                    $('.notification-pw').fadeOut('slow');
                                },2000);
                    return false;
                }
            });
            return false;
        }
    });
});