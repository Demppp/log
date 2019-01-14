//接收后台带过来的数组
var acceptTags = new Array();
var path = common.path;
var editJounal = {


    URL : {
        uploadjournalImage : function(){
            return '/img/uploadjournalImage';
        },
        saveJounal : function(){
            return "/jounal/saveJounal";
        }
    },


	 //标签相关操作
    tagOpera: function (params) {
        if (params && params != "") {
            //去除最后一个逗号，并按照逗号进行分割成字符数组
            var strings = params.substring(0, params.lastIndexOf(",")).split(",");
            for (var indexStr in  strings) {
                var tip = {
                    tag: strings[indexStr] + ''
                };
                acceptTags.push(tip);
                tags.push(strings[indexStr].toString());
            }
        }
        //初始化标签(如果存在)
        $('.chips-placeholder').material_chip({
            data: acceptTags,
            placeholder: 'Enter a tag',
            secondaryPlaceholder: '按回车确认'
        });

        //标签的添加和修改
        $('.chips').on('chip.add', function (e, chip) {
            tags.push(chip.tag);
        });
        $('.chips').on('chip.delete', function (e, chip) {
            for (var index  in tags) {
                if (tags[index] == chip.tag) {
                    tags.splice(index, 1);
                }
            }
        });

    },


    //标签和文本编辑器
    tag_text:function(params){
    	 //标签的相关操作(增加、删除、获取值)
        editJounal.tagOpera(params);

        //文本编辑器
        var E = window.wangEditor
        var editor = new E('#editor')
        editor.customConfig.uploadImgServer = path +  editJounal.URL.uploadjournalImage() ;  // 上传图片到服务器接口
        editor.customConfig.uploadFileName = 'imgsFile'; // 参数名称
        editor.customConfig.uploadImgShowBase64 = true
        editor.customConfig.uploadImgParams = {		    
		    imgType: 'jounalImg' 
		}

		editor.customConfig.uploadImgHooks = {
			success: function (xhr, editor, result) {
		        // 图片上传并返回结果，图片插入成功之后触发
		        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
		        
		    }
		}
        //...文件上传如果用到其他参数再去看文档。http://www.wangeditor.com/index.html
        editor.create();

        $("#submitButton").click(function(){
        	var textWithHtml = editor.txt.html();
			var text = editor.txt.text();
			editJounal.saveJounal(textWithHtml,text);
		})

    },
	
	index:function(params){
		//侧边导航条
        $("#button-collapse").sideNav();
		common.index();

		editJounal.tag_text();	
       
	},

	saveJounal:function(textWithHtml,text){
		var title = $("#title").val();
        var tags = $("#tag_1 input").val();
		
		$.post(path+editJounal.URL.saveJounal(),{
				title: title,
				tags : tags,
				textWithHtml : textWithHtml,
				text : text
			},function(result){
				if(result.code=="0"){
					swal({title:"发布成功！",
				        text:"",
				        type:"success"},function(){window.location.href = path+"/html/details/editJournal.html"}
				    )				
				}else{
					sweetAlert("发布失败", result.message, "error");
				}
			});
	}

}