//接收后台带过来的数组
var acceptTags = new Array();

var editJounal = {

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
	
	index:function(params){
		common.index();

        //标签的相关操作(增加、删除、获取值)
        editJounal.tagOpera(params);

        //文本编辑器
        var E = window.wangEditor
        var editor = new E('#editor')
        editor.customConfig.uploadImgServer = path + '/upload';  // 上传图片到服务器接口
        editor.customConfig.uploadFileName = 'imgsFile'; // 参数名称
        //...文件上传如果用到其他参数再去看文档。http://www.wangeditor.com/index.html
        editor.create();
	}

}