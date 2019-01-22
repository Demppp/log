var path = common.path;
var index = {

	URL : {
		to_blogDetails : function(){
			return "/blog/showBlogDetails";
		}
	},

	to_blogDetails:function(){
		var id = $(this).find("p").eq(0).val();
		var blog_id = $("#blog_p").val();
		var url = path+index.URL.to_blogDetails()+"/"+blog_id;
		window.open(url);
	},

	index:function(){

		// common.no_login();

		// //侧边导航条
  //       $("#button-collapse").sideNav();

  //       //获取用户信息
		// common.getUserInfo();

		// //退出按钮
		// $("#logout").click(function(){
  //           common.logout();
  //       });


  		//侧边导航条
        $("#button-collapse").sideNav();
  		common.index();

  		//跳转blog页面
  		// $("ul li").click(function(){
  		// 	index.to_blogDetails();
  		// })
	}
}