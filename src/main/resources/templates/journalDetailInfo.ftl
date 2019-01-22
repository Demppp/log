<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ozc Journal｜文章详情页</title>


    <!--Materialize  CSS-->
    <link href="https://cdn.bootcss.com/material-design-icons/3.0.1/iconfont/material-icons.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/materialize/0.97.8/css/materialize.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!--样式-->

    <!--页面样式-->
    <style>
        body {
            background-image: url(../static/imgs/register&loginBG.gif);
            background-repeat: repeat;
        }
    </style>

</head>


<body>

<div class="container">
    <div class="divider"></div>
    <h2>${journal.title}</h2>
    <br>
    <div class="divider" style="border: 1px solid #cccccc;"></div>

    <div class="section">
    ${journal.textWithHtml}
    </div>
</div>


<!--jQuery -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/materialize/0.97.8/js/materialize.min.js"></script>


</body>
</html>