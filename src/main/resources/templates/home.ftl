<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>${title}</title>
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
	
	
	<link rel="stylesheet" href="${request.contextPath}/index/css/menu.css">
	<script src="${request.contextPath}/index/js/jquery1111.min.js" type="text/javascript"></script>
	<script src="${request.contextPath}/index/js/script.js"></script>
	
	<!-- Owl Carousel Assets -->
    <link href="owl-carousel/owl.carousel.css" rel="stylesheet">
	
	
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
</head>

<body>
	<div class="wrap-body">
		<div id='cssmenu' class="align-center">
			<ul>
			   <li class="active"><a href='${request.contextPath}/index/index.html'><span>Home</span></a></li>
			   <li class=' has-sub'><a href='#'><span>Blog</span></a>
			   	  <ul id="head_blog_ul">
				   	  <#list BLogDetailsList as blog>				   	  	
				   	  	  <li class='last'>
				   	  	  	<a href='${request.contextPath}/blog/showBlogDetails/${blog.id}'>
				   	  	  		<span>
				   	  	  			<p value="${blog.id}">${blog.title}</p>
				   	  	  		</span>
				   	  	  	</a>
				   	  	  </li>				   	  	
				   	  </#list>
			   	  </ul>
			   </li>			
			   <li><a href='/index/single.html'><span>About</span></a></li>
			   <li class='last' id="personal_center">
			   		<a href='#' id="button-collapse" data-activates="slide-out"><span>Setting</span></a>
			   </li>

			</ul>
		</div>
		<header class="">
			<div class="logo">
				<hr class="line-1">
				<a href="#">Vintauge</a>
				<span>Lorem ipsum dolor sit amet</span>
				<hr class="line-1">
			</div>
			<div id="owl-slide" class="owl-carousel">
				<div class="item">
					<img src="images/slider1.jpg" />
				</div>
				<div class="item">
					<img src="images/slider2.jpg" />
				</div>
				<div class="item">
					<img src="images/slider3.jpg" />
					
				</div>
			</div>
		</header>
		<!--////////////////////////////////////Container-->
		<section id="container">
			<div class="wrap-container">
				<div id="main-content">
					<div class="wrap-content">
						<div class="zerogrid">
							<div class="row">
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="images/11.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															Art and design have always been related, but today, experimentation and personal expression are the name of the game. Homeowners are using art to make a personal statement – your art choice has ...
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">Vital Films presents INSIGHT</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="images/12.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															Art and design have always been related, but today, experimentation and personal expression are the name of the game. Homeowners are using art to make a personal statement – your art choice has ...
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">Branding and Advertisement</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
							</div>
							<div class="row">
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="images/13.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															Art and design have always been related, but today, experimentation and personal expression are the name of the game. Homeowners are using art to make a personal statement – your art choice has ...
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">Branding and Advertisement</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="images/14.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															Art and design have always been related, but today, experimentation and personal expression are the name of the game. Homeowners are using art to make a personal statement – your art choice has ...
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">Branding and Advertisement</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
							</div>
							<div class="row">
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="images/1.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															Art and design have always been related, but today, experimentation and personal expression are the name of the game. Homeowners are using art to make a personal statement – your art choice has ...
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">Branding and Advertisement</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
								<div class="col-1-2">
									<article>
										<div class="post-thumbnail-wrap">
											<a href="single.html" class="portfolio-box">
												<img src="images/2.jpg" alt="">
												<div class="portfolio-box-caption">
													<div class="portfolio-box-caption-content">
														<div class="project-text">
															Art and design have always been related, but today, experimentation and personal expression are the name of the game. Homeowners are using art to make a personal statement – your art choice has ...
														</div>
													</div>
												</div>
											</a>
										</div>
										<div class="entry-header ">
											<h3 class="entry-title">Branding and Advertisement</h3>
											<div class="l-tags"><a href="#">Design</a> / <a href="#">Illustrations</a> / <a href="#">Typography</a></div>
										</div>
									</article>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
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

     <li>
      <a class="waves-effect" href="/html/details/editBlog.html">
         <i class="material-icons prefix pink-text text-accent-1">mode_edit</i>编写新的博客
      </a>
    </li>

    <li><a class="waves-effect" href="/jounal/showJournals">
      <i class="material-icons pink-text text-accent-1">search</i>查看日志</a></li>
    <li id="logout"><a class="waves-effect"><i class="material-icons pink-text text-accent-1">settings_power</i>退出登陆</a>
    </li>
</ul>


		<!-- carousel -->
		<script src="owl-carousel/owl.carousel.js"></script>

		<!-- 自己的js-->
		<script type="text/javascript" src="/js/common.js"></script>
		<script type="text/javascript" src="/js/index.js"></script>
		<script>
		$(document).ready(function() {
		  $("#owl-slide").owlCarousel({
			autoPlay: 3000,
			items : 1,
			itemsDesktop : [1199,1],
			itemsDesktopSmall : [979,1],
			itemsTablet : [768, 1],
			itemsMobile : [479, 1],
			navigation: true,
			navigationText: ['<i class="fa fa-chevron-left fa-5x"></i>', '<i class="fa fa-chevron-right fa-5x"></i>'],
			pagination: false
		  });

		  $(".button-collapse").sideNav();		       
		  index.index();
		});
		</script>
	</div>
</body>
</html>