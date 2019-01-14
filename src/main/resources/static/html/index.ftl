<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="../res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="../res/css/main.css">
   <!--Materialize CSS-->
    <link href="https://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/materialize/0.97.8/css/materialize.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!--Materialize.js-->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/materialize/0.97.8/js/materialize.min.js"></script>


     <!--弹出框-->
    <script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.js"></script>
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
<!--加载meta IE兼容文件-->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
</head>
<body>
  <div class="header">
    <div class="menu-btn">
      <div class="menu"></div>
    </div>
    <h1 class="logo">
      <a href="index.html">
        <span>MYBLOG</span>
        <img src="../res/img/logo.png">
      </a>
    </h1>
    <div class="nav">
      <a href="/html/index.html" class="active">文章</a>
      <a href="/html/whisper.html">微语</a>
      <a href="/html/leacots.html">留言</a>
      <a href="/html/album.html">相册</a>
      <a href="/html/about.html">关于</a>
    </div>
    
    <p class="welcome-text" id="personal_center"> 
       <a class="#000000 black-text" id="button-collapse" data-activates="slide-out" href="javascript:;">个人中心</a>
    </p>
  </div>

  <div class="banner">
    <div class="cont w1000">
      <div class="title">
        <h3>MY<br />BLOG</h3>
        <h4>well-balanced heart</h4>
      </div>
      <div class="amount">
        <p><span class="text">访问量</span><span class="access">1000</span></p>
        <p><span class="text">日志</span><span class="daily-record">1000</span></p>
      </div>
    </div>
  </div>
  <div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
  <div class="content">
    <div class="cont w1000">
      <div class="title">
        <span class="layui-breadcrumb" lay-separator="|">
          <a href="javascript:;" class="active">设计文章</a>
          <a href="javascript:;">前端文章</a>
          <a href="javascript:;">旅游杂记</a>
        </span>
      </div>
      <div class="list-item">
        <div class="item">
          <div class="layui-fluid">
            <div class="layui-row">
              <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">
                <div class="img"><img src="../res/img/sy_img1.jpg" alt=""></div>
              </div>
              <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">
                <div class="item-cont">
                  <h3>空间立体效果图，完美呈现最终效果<button class="layui-btn layui-btn-danger new-icon">new</button></h3>
                  <h5>设计文章</h5>
                  <p>室内设计作为一门新兴的学科，尽管还只是近数十年的事，但是人们有意识地对自己生活、生产活动的室内进行安排布置，甚至美化装饰，赋予室内环境以所祈使的气氛，却早巳从人类文明伊始的时期就已存在</p>
                  <a href="details.html" class="go-icon"></a>
                </div>
            </div>
            </div>
           </div>
        </div>   
      </div>
      <div id="demo" style="text-align: center;"></div>
    </div>
  </div>


<!--侧边导航条-->
<ul id="slide-out" class="side-nav">
    <li>
        <div class="userView">
            <span class="black-text " id="userNickName">张三</span><br>
            <span id="userEmail" class="black-text email">未填邮箱地址</span>
        </div>
    </li>
    <li><a class="waves-effect" href="/html/details/personalInfo.html" id="personalInfo"><i
            class="material-icons pink-text text-accent-1">perm_identity</i>完善个人信息</a>
    </li>

    <li><a class="waves-effect" href="/music.html"><i
            class="material-icons pink-text text-accent-1">insert_chart</i>设置个人音乐</a>
    </li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="subheader">用户操作</a></li>

    <li><a class="waves-effect" href="/html/index.html"><i
            class="material-icons prefix  pink-text text-accent-1">label</i>回到首页</a>
    </li>

    <li>
      <a class="waves-effect" href="/html/details/editJournal.html">
         <i class="material-icons prefix pink-text text-accent-1">mode_edit</i>编写新的日志
      </a>
    </li>

    <li><a class="waves-effect" href="/jounal/showJournals">
      <i class="material-icons pink-text text-accent-1">search</i>查看日志</a></li>
    <li id="logout"><a class="waves-effect"><i class="material-icons pink-text text-accent-1">settings_power</i>退出登陆</a>
    </li>
</ul>


<script type="text/javascript" src="../res/layui/layui.js"></script>
<!--自己的js-->
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
<script type="text/javascript">
    layui.config({
      base: '../res/js/util/'
    }).use(['element','laypage','jquery','menu'],function(){
      element = layui.element,laypage = layui.laypage,$ = layui.$,menu = layui.menu;
      laypage.render({
        elem: 'demo',
        count: 70 //数据总数，从服务端得到
      });
      menu.init();
    })


    $(function(){
        $(".button-collapse").sideNav();
        // $("#personal_center").click(function(){         
        //    //侧边导航条
        //   $("#button-collapse").sideNav();
        // });
      
        index.index();

    })
</script>

</body>
</html>