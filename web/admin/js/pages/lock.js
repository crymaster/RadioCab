$(function(){
    document.title = "Lock Screen";

   // check either fields are blank or not
   $('.submit').click(function(){
      if ($('.password').val() == ""){
          $('.password').focus();
          $('#login-error').text('Please enter password').hide().fadeIn();
          setTimeout(function(){
              $('#login-error').text('');
          }, 4000);
          return false;
      }
      
      $("#login-error").text("Processing...");
      
      
      //check username and password with server side
      var username = $('.userid').val(),
          password = $('.password').val();
        $.ajax({
                type: 		"post",
                url: 		"ajax/doLogin.jsp",
                data: 		{user: username, pass: password},
                dataType:       "json",
                success:	function(res) {
                    
                    if (res.status){
                        window.location.href = res.href;
                    }else{
                        $("#login-error").text(res.error).hide().fadeIn("slow");
                        setTimeout(function(){
                            $('#login-error').text('');
                        }, 4000);
                    }
                }
        });
      return false;
   });
});