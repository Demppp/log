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
				$("#userNickName").html(result.username);
			}else{
				sweetAlert("ERROR", result.message, "error");
			}
		})
	},
}	