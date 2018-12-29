var path = window.location.origin;

var login = {
	URL:{	
		indexPath : function(){
			return "/html/index.html"
		}
	},

	login:function(){
		$("#loginBtn").click(function(){
			var username = $("#username").val();
			var password = $("#username").val();
			if(username=="USERNAME"){
					sweetAlert("登录失败", "请输入用户名!", "error");
					return;
			}
			$.post(path+"/user/login",{
				username : username,
				password : password
			},function(result){
				if (result && result.code=="0") {
					sweetAlert({
                                title: "登陆成功！",
                                text: "1秒后跳转到首页！",
                                timer: 1000,
                                type: "success",
                                showConfirmButton: false
                            });
					setTimeout(function () {
                                window.location.href = path+login.URL.indexPath();
                            }, 1000);
					// window.location.href = path+login.URL.indexPath();
				}
			})
		})
	},

	
	init:function(){
		login.login();
	}


}