var path = common.path;
var blogDetailsInfo = {
	URL : {
		saveComment : function(){
			return "/comment/saveComment";
		},
		showBlogDetails : function(){
			return "/blog/showBlogDetails";
		}
	},

	saveComment : function(){
		var comment = $("#comment_textarea").val();
		var blogId = $("#blogId").val();
		$.post(path+blogDetailsInfo.URL.saveComment(),
			{
				comment : comment,
				blogId : blogId
			},
			function(result){
				if(result.code=="0"){
					window.location.href = path+blogDetailsInfo.URL.showBlogDetails()+"/"+blogId;
				}else{
					sweetAlert("发布失败", result.message, "error");
				}
			})
	},

	pageinit : function(){
		 new Page({
			        id: 'pagination',
			        pageTotal: 50, //必填,总页数
			        pageAmount: 10,  //每页多少条
			        dataTotal: 500, //总共多少条数据
			        curPage:1, //初始页码,不填默认为1
			        pageSize: 5, //分页个数,不填默认为5
			        showPageTotalFlag:true, //是否显示数据统计,不填默认不显示
			        showSkipInputFlag:true, //是否支持跳转,不填默认不显示
			        getPage: function (page) {
			            //获取当前页数
			           console.log(page);
			        }
   				 })
	},


	index : function(){
		$("#commentButton").click(function(){
			blogDetailsInfo.saveComment();
		})

		blogDetailsInfo.pageinit();
	}
}