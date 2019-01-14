var path = common.path;

var login = {
	
	URL : {
		login : function(){
			return "/user/login";
		}
	},

	login:function(){
		$("#loginBtn").click(function(){
			// var username = $("#username").val();
			// var password = $("#username").val();
			var username = "1";
			var password = "1";
			// if(username=="USERNAME"){
			// 		sweetAlert("登录失败", "请输入用户名!", "error");
			// 		return;
			// }
			$.post(path+login.URL.login(),{
				username : username,
				password : password
			},function(result){
				if (result && result.code=="0") {
					// sweetAlert({
     //                            title: "登陆成功！",
     //                            text: "1秒后跳转到首页！",
     //                            timer: 1000,
     //                            type: "success",
     //                            showConfirmButton: false
     //                          });
					// setTimeout(function () {
     //                            window.location.href = path+common.URL.indexPath();
     //                          }, 1000);
					window.location.href = path+common.URL.indexPath();
				}else{
					sweetAlert("登录失败", result.message, "error");
				}
			})
		})
	},

	
	init:function(){
		login.login();

		//回车键登录
		$(document).keyup(function(event){
		  if(event.keyCode ==13){
		    $("#loginBtn").trigger("click");
		  }
		});
	}


}