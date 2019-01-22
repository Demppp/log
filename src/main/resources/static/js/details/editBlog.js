var path = common.path;

var editBlog = {

	URL : {
		saveBLog: function(){
			return "/blog/saveBLog";
		}
	},
	
	uploadImg : function(){
			var opt = {
            //重新指定form的action的值
            url: path+common.URL.uploadImage(),
            type: "post",
            dateType: "json",
            data: {
                imgType : "blog"
            },
            success: function (result) {
                if (result && result.code == 0) {            
                   // sweetAlert("上传成功", result.message, "success");
                   $("#blogCoverSpan").text("上传成功!");
                   $("#blog_cover").val(result.data.localPath);
                } else {
                   sweetAlert("操作失败", result.message, "error");
                }
            },
            error: function () {
               sweetAlert("操作失败", result.message, "error");
            }
        };
	        //异步提交表单
	        $("#blogCoverFrom").ajaxSubmit(opt);
	},
		

	saveBLog : function(){
		var arrs =  editorEle.getEditorData();
		var textWithHtml = arrs[0];
		var text = arrs[1];
		var title = $("#title").val();
		var tags = $("#blog_tag input").val();
		var cover = $("#blog_cover").val();
			
		$.post(path+editBlog.URL.saveBLog(),
			{
				title 		 : title,
				text 		 : text,
				textWithHtml : textWithHtml,
				tags		 : tags,
				cover 		 : cover
			},
			function(result){
				if(result.code=="0"){
					swal({title:"发布成功！",
				        text:"",
				        type:"success"},
                        function(){
                            window.location.href = path+common.URL.editBlogPath();
                        }
				    )				
				}else{
					sweetAlert("发布失败", result.message, "error");
				}
		})
	},

	index : function(){
		//封面图
		$("#blogCoverDiv").change(function(){
			$("#blogCoverSpan").empty();
			$("#blogCoverSpan").text("");
			editBlog.uploadImg();
		});

		//侧边导航条
        $("#button-collapse").sideNav();
		common.index();

		//文本框加载
		editorEle.setImgType("blog");
		editorEle.index();

		//保存blog
		$("#edit_blog_btn").click(function(){
			editBlog.saveBLog();
		})

	}
}