var path = common.path;

var personalInfo = {

	uploadImage : function(){
		var opt = {
            //重新指定form的action的值
            url: path+"/img/uploadImage",
            type: "post",
            dateType: "json",
            data: {
                imgType : "user"
            },
            success: function (result) {
                if (result && result.code == 0) {
                    var imgUrl = path+"/img/url/?imgPath="+result.data.localPath;
                    $("#displayImg").attr("src", imgUrl);
                    $("#headPortrait").val(result.data.localPath);

                } else {
                   sweetAlert("操作失败", result.message, "error");
                }
            },
            error: function () {
               sweetAlert("操作失败", result.message, "error");
            }
        };
        //异步提交表单
        $("#personalInfoForm").ajaxSubmit(opt);
	},


    updateUserInfo : function(){
        var imgPath =   $("#headPortrait").val();
        var username = $("#username").val();
        $.post(path+"/user/updateUserInfo",
            {
                imgPath : imgPath,
                username : username
            },function(result){
                if (result && result.code == 0) {
                   var imgUrl = path+"/img/url/?imgPath="+result.data.imgPath;
                   $("#userNickName").html(result.data.username);
                   $("#slide-out-headPortrait").attr("src", imgUrl);
                   sweetAlert("更新成功","更新成功","success");
                }else {
                   sweetAlert("操作失败", result.message, "error");
                }
            });
    },

    checkUsername : function(username){      
        $.post(path+"/user/checkUsername",
            {
                username : username
            },function(result){
                $("p").remove(".username_tips");
                if(result.code=="0"){
                     $("#username_tips").append('<p class="username_tips">用户名可使用</p>');
                }else{
                     $("#username_tips").append('<p class="username_tips">用户名不可用</p>');
                }   
            });   
    },

	init : function(){

        //获取用户信息
        common.getUserInfo();

          //更换头像
        $("#fileButton").change(function () {
            personalInfo.uploadImage();
        });

        $("#logout").click(function(){
            common.logout();
        });

        $("#submitForm").click(function(){
            personalInfo.updateUserInfo();
        })
	}


}