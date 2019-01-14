var path = "";

$(function(){
	path = window.location.origin;
})

var common = {
	URL : {
		indexPath : function(){
			return "/html/index.html" 
		},

		loginPath : function(){
			return "/login/login.html"
		}

	},



	getUserInfo : function(){
		$.post(path+"/user/getUserInfo",
		{},
		function(result){
			if (result && result.code=="0") {
				if(result.data.imgPath!=""){
					$("#slide-out-headPortrait").attr("src","/imgs/headPortrait.png");
				}else{
					$("#slide-out-headPortrait").attr("src", path+"/img/url/?imgPath="+result.data.imgPath);
				}
				
				$("#userNickName").html(result.data.username);
			}else{
				sweetAlert({
                                title: "发生未知错误！",
                                text: "1秒后跳转到首页！",
                                timer: 1000,
                                type: "error",
                                showConfirmButton: false
                            });
					setTimeout(function () {
                                window.location.href = path+common.URL.loginPath();
                            }, 1000);
			}
		})
	},

	logout : function(){
		$.post(path+"/user/logout",
		{},
		function(result){
			if (result && result.code == 0) {  //退出到登录页面
				 window.location.href = path + common.URL.loginPath();
			}else{
				sweetAlert("退出失败", result.message, "error");
			}
		})
	},

	no_login : function(){
		$.post(path+"/user/no_login"
			,{

			},function(){

			});
	},


	index:function(){
		// common.no_login();

        //获取用户信息
		common.getUserInfo();

		//退出按钮
		$("#logout").click(function(){
            common.logout();
        });

	}

}	