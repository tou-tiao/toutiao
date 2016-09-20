<!DOCTYPE html>
<html>

<head>
    <title>分享 - 分享平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <link rel="stylesheet" href="../res/css/bootstrap.min.css">
    <!-- 增强跨浏览器表现的一致性,引入 normalize.css 文件 -->
    <link rel="stylesheet" type="text/css" href="../res/normalize.css">
    <link rel="stylesheet" type="text/css" href="../res/style.css">
    <script src="../res/jquery.min.js"></script>
    <script src="../res/js/bootstrap.min.js"></script>
</head>

<body>
    <header class="navbar navbar-default no-margin-bottom" id="top" role="banner">
        <div class="contrainer">
            <nav class="navbar navbar-default no-margin-bottom" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">星月博客</a>
                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="./explore.html">独家号</a></li>
                            <li><a href="#">分享</a></li>
                            <li><a href="./lastest.html">最新分享</a></li>
                            <!-- 登录时显示 -->
                            <li><a href="./user-subs.html">我的独家号</a></li>
                            <!-- 登录时显示 -->
                            <li><a href="./sub.html">我的订阅</a></li>
                            <li><a href="#">搜索</a></li>
                            <!-- 未登录时显示 -->
                            <!-- <li><a href="#">登录</a></li>
                        <li><a href="#">关于我们</a></li>
                        <li><a href="#">IO币介绍</a></li> -->
                            <!-- 未登录时显示 -->
                            <!-- 登录时显示 -->
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Maoli-zjp
                                <b class="caret"></b>
                            </a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">我的收藏</a></li>
                                    <li><a href="./user-contribute.html">我的分享</a></li>
                                    <li><a href="#">我的关注</a></li>
                                    <li><a href="#">我的IO币:</a></li>
                                    <li><a href="./settings.html">个人设置</a></li>
                                    <li><a href="./index-no-login.html">退出</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <div id="main" style="margin-top: 20px">
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">我要分享</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group" style="height:24px">
                        
                        	<label class="required col-sm-2 labal-share">
                              独家号
                            </label>
                            <div class="col-sm-10">
                                <span">
                            		<label for="post_subject_id">
                            			<input class="required" type="radio" checked="checked" id="post_subject_id"> maoli-zjp
                            		</label>
                            	</span>
                            </div>
                        </div>
                            
                      
                        <div class="form-group" style="height:34px">
                            <div class="col-lg-9">
                                <div class="input-group">
                                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button" disabled="disabled">文章标题</button>
                            </span>
                                    <input type="text" class="form-control">
                                </div>
                                <!-- /input-group -->
                            </div>
                            <!-- /.col-lg-6 -->
                        </div>
                        <div class="form-group" style="height:34px">
                            <div class="col-lg-9">
                                <div class="input-group">
                                    <span class="input-group-btn">
                                <button class="btn btn-default" type="button" disabled="disabled">原始链接</button>

                            </span>
                                    <input type="text" class="form-control">
                                </div>
                                <!-- /input-group -->
                            </div>
                            <!-- /.col-lg-6 -->
                        </div>
                        <!-- /.row -->
                        <div class="form-group" style="height:34px">
                            <div class="col-lg-9">
                                <input type="submit" class="form-control" value="提交">
                            </div>
                            <!-- /input-group -->
                            <!-- /.col-lg-6 -->
                            <!-- /.row -->
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</body>

</html>
