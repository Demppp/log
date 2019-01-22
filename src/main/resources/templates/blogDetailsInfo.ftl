<!DOCTYPE html>
<html lang="en"> 
<head>

    <!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>Vintauge</title>
	<meta name="description" content="Free Responsive Html5 Css3 Templates ">
	<meta name="author" content="#">
	
    <!-- Mobile Specific Metas
	================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS
	================================================== -->
  	<link rel="stylesheet" href="${request.contextPath}/index/css/zerogrid.css">
	<link rel="stylesheet" href="${request.contextPath}/index/css/style.css">
	
	<!-- Custom Fonts -->
    <link href="${request.contextPath}/index/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	
	
	<!--jQuery -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/materialize/0.97.8/js/materialize.min.js"></script>


	<link rel="stylesheet" href="${request.contextPath}/index/css/menu.css">
	<script src="${request.contextPath}/index/js/script.js"></script>
	
	<!-- Owl Carousel Assets -->
    <link href="${request.contextPath}/index/owl-carousel/owl.carousel.css" rel="stylesheet">
	
	<!--Materialize  CSS-->
    <link href="https://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/materialize/0.97.8/css/materialize.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 	

    <!--自己的js-->
    <script type="text/javascript" src="${request.contextPath}/js/common.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/ftl/blogDetailsInfo.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/page/myPagination.js"></script>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/js/page/myPagination.css">

    <style type="text/css">
    	 .avatar{
            border-radius:50px;
            display:block;
            height:50px;
            width:50px
        }
    </style>
	
</head>
	<script type="text/javascript">
		$(function(){
			blogDetailsInfo.index();		
		})
	</script>
<body>
	<div class="wrap-body">		
		<header class="">
			<div class="logo">
				<hr class="line-1">
				<a href="#">${blogDTO.title}</a>
				<span>${blogDTO.tagName}</span>
				<hr class="line-1">
			</div>
		</header>
		<!--////////////////////////////////////Container-->
		<input type="text"  hidden="hidden" id="blogId" value="${blogDTO.id}">
		<section id="container">
			<div class="wrap-container">
				<!-----------------Content-Box-------------------->
				<article class="single-post zerogrid">
					<div class="row wrap-post"><!--Start Box-->
						<div class="entry-header">
							<span class="time">${blogDTO.createTime}</span>
						</div>
						<div class="post-thumbnail-wrap">
							<img src="${request.contextPath}/img/url/?imgPath=${blogDTO.cover}">
						</div>
						<div class="entry-content">
							<div class="excerpt">
								${blogDTO.textWithHtml}
							</div>	
						</div>
					</div>
				</article>

				<!--留言板-->
				<div class="zerogrid">
					<div class="comments-are">
						<div id="comment">
							<h3>评论</h3>
							<form name="form1" id="comment_form" method="post" action="">
								<label>
								<span>你想对作者说什么:</span>
								<textarea id="comment_textarea"></textarea>
								</label>
								<center><input id="commentButton" type="button"  value="提交"></center>
							</form>
						</div>
					</div>
				</div>
				<!--评论-->
				<#list commentDTOList as commentDTO>
					<div class="zerogrid">
	                  <div class="img">
	                    <img src="${request.contextPath}/img/url/?imgPath=${commentDTO.userImgPath}" class="avatar">
	                  </div>
	                  <div class="text">
	                    <p class="tit">
	                    		<span class="name">${commentDTO.username}</span><br/>
	                    		<span class="data">${commentDTO.operateTime}</span>
	                    </p>
	                    <p class="ct">${commentDTO.comment}</p>
	                  </div>
                    </div>
				</#list>
				<!--分页-->
				<div id="pagination" class="pagination"></div>
			</div>
		</section>
	</div>
</body>
</html>