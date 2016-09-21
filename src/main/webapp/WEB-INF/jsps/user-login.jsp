<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>登录 - 分享平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <link rel="shortcut icon" href="${context}/res/img/favicon.ico">
        <link rel="Bookmark" href="${context}/res/img/favicon.ico">
    <link rel="stylesheet" href="${context}/res/css/bootstrap.min.css">
    <!-- 增强跨浏览器表现的一致性,引入 normalize.css 文件 -->
    <link rel="stylesheet" type="text/css" href="${context}/res/normalize.css">
    <link rel="stylesheet" type="text/css" href="${context}/res/style.css">
    <script src="${context}/res/jquery.min.js"></script>
    <script src="${context}/res/js/bootstrap.min.js"></script>
</head>

<body>
    <header class="navbar navbar-default navbar-static-top bs-docs-nav no-margin-bottom" id="top" role="banner">
        <div class="contrainer">
            <nav class="navbar navbar-default no-margin-bottom" role="navigation">
                <div class="container self-contrainer">
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
                            <li><a href="/explore">独家号</a></li>
                            <li><a href="/signin">分享</a></li>
                            <li><a href="/lastest">最新分享</a></li>
                            <!-- 登录时显示 -->
                            <!-- <li><a href="#">我的独家号</a></li> -->
                            <!-- 登录时显示 -->
                            <li><a href="/signin">我的订阅</a></li>
                            <li><a href="/search">搜索</a></li>
                            <!-- 未登录时显示 -->
                            <li><a href="/signin"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                            <li><a href="#">关于我们</a></li>
                            <li><a href="#">IO币介绍</a></li>
                            <!-- 未登录时显示 -->
                            <!-- 登录时显示 -->
                            <!-- <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Java
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">我的收藏</a></li>
                                <li><a href="./user-contribute.html">我的分享</a></li>
                                <li><a href="#">我的关注</a></li>
                                <li><a href="#">我的IO币:</a></li>
                                <li><a href="./settings.html">个人设置</a></li>
                                <li><a href="#">退出</a></li>
                            </ul>
                        </li> -->
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <div id="main">
        <div class="container">
            <h3 class="text-center">登录</h3>
            <form action="${context}/auth/identity" method="post" class="form-panel" role="form">
                <div class="form-group" style="height:34px">
                    <div class="col-lg-5 btn-adjust">
                        <div class="input-group">
                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button" disabled="disabled">邮箱</button>
                            </span>
                            <input type="text" id="email" name="email" class="form-control">
                        </div>
                        <!-- /input-group -->
                    </div>
                    <!-- /.col-lg-6 -->
                </div>
                <div class="form-group" style="height:34px">
                    <div class="col-lg-5 btn1-adjust">
                        <div class="input-group">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button" disabled="disabled">密码</button>

                            </span>
                            <input type="text" id="password" name="password" class="form-control">
                        </div>
                        <!-- /input-group -->
                    </div>
                    <!-- /.col-lg-6 -->
                </div>
                <!-- /.row -->
                <div class="form-group" style="height:34px">
                    <div class="col-lg-5 btn2-adjust">
                        <input type="submit" id="signin" class="form-control" value="登录">
                    </div>
                    <!-- /input-group -->
                    <!-- /.col-lg-6 -->
                    <!-- /.row -->
                </div>
        </div>
        </form>
    </div>
    </div>
</body>

</html>
<script>
    String.prototype.format = function (args) {
        var result = this;
        if (arguments.length > 0) {
            if (arguments.length == 1 && typeof (args) == "object") {
                for (var key in args) {
                    if (args[key] != undefined) {
                        var reg = new RegExp("({" + key + "})", "g");
                        result = result.replace(reg, args[key]);
                    }
                }
            }
            else {
                for (var i = 0; i < arguments.length; i++) {
                    if (arguments[i] != undefined) {
                        var reg = new RegExp("({)" + i + "(})", "g");
                        result = result.replace(reg, arguments[i]);
                    }
                }
            }
        }
        return result;
    }

    $(function(){
        $('#signin').on('click',function(){
            var $email = $('#email'),
                emailVal = $.trim($email.val()),
                $password = $('#password'),
                passwordVal = $.trim($password.val());

            if(emailVal.length == 0){
                alert('用户名不能为空');
                $email.focus();
                return false;
            }

            if(passwordVal.length == 0){
                alert('密码不能为空');
                $password.focus();
                return false;
            }
            
            return true;
        })
    });
</script>