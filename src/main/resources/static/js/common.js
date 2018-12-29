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
}	