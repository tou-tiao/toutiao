<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>我的独家号 - 分享平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <link rel="stylesheet" href="${context}/res/css/bootstrap.min.css">
    <!-- 增强跨浏览器表现的一致性,引入 normalize.css 文件 -->
    <link rel="stylesheet" type="text/css" href="${context}/res/normalize.css">
    <link rel="stylesheet" type="text/css" href="${context}/res/style.css">
    <script src="${context}/res/jquery.min.js"></script>
    <script src="${context}/res/js/bootstrap.min.js"></script>
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
                            <li><a href="./contribute.html">分享</a></li>
                            <li><a href="./lastest.html">最新分享</a></li>
                            <!-- 登录时显示 -->
                            <li><a href="./user-subs.html">我的独家号</a></li>
                            <!-- 登录时显示 -->
                            <li><a href="./sub.html">我的订阅</a></li>
                            <li><a href="./login-search.html">搜索</a></li>
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
    <br>
    <div id="main" style="margin-top:20px">
        <div class="container">
            <div class="user-info2 text-center">
                <img width="96" class="img-circle" src="../img/moon-220x150.png" alt="">
                <h4>maoli-zjp</h4>
                <div>我是创新工场高级职工</div>
            </div>
        </div>
        <br>
        <div class="container">
            <ul class="nav nav-pills nav-sub" role="tablist">
                <li role="presentation" class="active">
                    <a href="#">
                        <span>分享</span>
                        <span class="count">11</span>
                    </a>
                </li>
                <li role="presentation">
                    <a href="#">
                        <span>我的独家号</span>
                        <span class="count">2</span>
                    </a>
                </li>
                <li role="presentation">
                    <a href="#">
                        <span>关注</span>
                        <span class="count">24</span>
                    </a>
                </li>
                <li role="presentation">
                    <a href="#">
                        <span>关注者</span>
                        <span class="count">4</span>
                    </a>
                </li>
            </ul>
        </div>
        <br>
        <div class="container">
            <div class="posts">
                <div class="post">
                    <div class="btn-group-vertical upvote">
                        <a class="btn btn-default" data-toggle="tooltip" data-placement="left" title="Tooltip on left" href="#">
                            <i class="glyphicon glyphicon-thumbs-up"></i>
                            <span></span>
                        </a>
                        <a class="btn btn-default" data-toggle="tooltip" data-placement="left" title="Tooltip on left" href="#">
                            <i class="glyphicon glyphicon-heart"></i>
                            <span></span>
                        </a>
                    </div>
                    <div class="content">
                        <h3 class="title">
                                    <a href="https://g.chenjx.cn/" target="_blank">google 搜索原理系列 2.1</a>
                                    </h3>
                        <div class="meta">
                            <span>
                                        <i>
                                
                                        </i>
                                        343
                                    </span>
                                    &nbsp;
                            <span>
                                <a data-confirm="确认删除" href="#">  删除</a>
                            </span>
                        </div>
                    </div>
                    <div class="user-info">
                        <div class="user-avatar">
                            <a href="#">
                                <img width="32" src="../img/moon-220x150.png">
                            </a>
                        </div>
                        maoli-zjp</div>
                    <div class="subject-name">
                        <a href="#">侦探事务所</a>
                    </div>
                </div>
                <div class="post">
                    <div class="btn-group-vertical upvote">
                        <a class="btn btn-default" data-toggle="tooltip" data-placement="left" title="Tooltip on left" href="#">
                            <i class="glyphicon glyphicon-thumbs-up"></i>
                            <span></span>
                        </a>
                        <a class="btn btn-default" data-toggle="tooltip" data-placement="left" title="Tooltip on left" href="#">
                            <i class="glyphicon glyphicon-heart"></i>
                            <span></span>
                        </a>
                    </div>
                    <div class="content">
                        <h3 class="title">
                                    <a href="https://g.chenjx.cn/" target="_blank">google 搜索原理系列 2.0</a>
                                    </h3>
                        <div class="meta">
                            <span>
                                        <i>
                                
                                        </i>
                                        312
                                    </span>
                                    &nbsp;
                                    <span>
                                <a data-confirm="确认删除" href="#">  删除</a>
                            </span>
                        </div>
                    </div>
                    <div class="user-info">
                        <div class="user-avatar">
                            <a href="#">
                                <img width="32" src="../img/moon-220x150.png">
                            </a>
                        </div>
                        maoli-zjp</div>
                    <div class="subject-name">
                        <a href="#">侦探事务所</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
