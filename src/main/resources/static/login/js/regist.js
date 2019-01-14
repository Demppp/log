var path = common.path;
var loginPath = common.URL.loginPath();

var regist = {

	URL : {
		regist : function(){
			return "/user/regist";
		}
	},

	vail_username : function(username){
		return true;
	},

	vail_password : function(password){
		return true;
	},

	vail_email : function(email){
		return true;
	},

	vail_phone : function(phone){
		return true;
	},


	regist : function(){
		$("#regist").click(function(){
			var username = $("#username").val();
			// if(regist.vail_username(username)){
			// 	regist.tip("用户名格式不正确");
			// }
			var password = $("#password").val();
			var phone = $("#phone").val();
			var email = $("#email").val();

			$.post(path+regist.URL.regist(),{
				username : username,
				password : password,
				phone : phone,
				email : email
			},function(result){
				if(result && result.code=="0"){
					sweetAlert({
                                title: "注册成功！",
                                text: "1秒后跳转到登录页面！",
                                timer: 1000,
                                type: "success",
                                showConfirmButton: false
                            });
					setTimeout(function () {
                                window.location.href = path+ loginPath;
                            }, 1000);
				}else{
					sweetAlert("注册失败", "用户名"+result.message, "error");
				}
			});
		})
	},

	tip : function(msg){
		sweetAlert("注册失败", msg, "error");
					return;
	},

	init : function(){
		regist.regist();
	}

}