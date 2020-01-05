<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="app">
<head>  
    <base href="<%=basePath%>">
  <meta charset="utf-8" />
  <title>注册</title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="css/animate.css" type="text/css" />
  <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="css/font.css" type="text/css" />
  <link rel="stylesheet" href="css/app.css" type="text/css" />  
    <style type="text/css">
  	#radio input{
  		margin-left:80px;
  	}
  </style>	

</head>
<body class="bg-info dker">
  <section id="content" class="m-t-lg wrapper-md animated fadeInDown">
    <div class="container aside-xl">
      <a class="navbar-brand block" href="index.html"><span class="h1 font-bold">Musik</span></a>
      <section class="m-b-lg">
        <header class="wrapper text-center">
          <strong style="color:red">${fail }</strong>
          <strong>${success }</strong>
        </header>
        <form action="user" method="post" onsubmit="return check()">
          <div class="form-group">
          	<!-- 隐藏表单域传值 -->
          	<input type="hidden" name="method" value="doUserRegister" class="form-control rounded input-lg text-center no-border">
            <input id="userName" type="text" placeholder="用户名" name="userName" class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="form-group">
            <input id="pwd1" type="password" placeholder="密码" name="pwd" class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="form-group">
             <input id="pwd2" type="password" placeholder="确认密码" class="form-control rounded input-lg text-center no-border">
          </div>
          <div id="radio" class="form-group">
          	<input type="radio" name="sex" value="0">女
          	<input type="radio" checked="checked" name="sex" value="1">男
          </div>
          <button class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><span class="m-r-n-lg">注册</span></button>
          <div class="line line-dashed"></div>
          <p class="text-muted text-center"><small>已经有账号?</small></p>
          <a href="jsp/signin.jsp" class="btn btn-lg btn-info btn-block btn-rounded">去登录</a>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder clearfix">
      <p>
        <small>Web app framework base on Bootstrap<br>&copy; 2018</small>
      </p>
    </div>
  </footer>
  <!-- / footer -->
  <script src="js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="js/bootstrap.js"></script>
  <!-- App -->
  <script src="js/app.js"></script>  
  <script src="js/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/app.plugin.js"></script>
  <script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/demo.js"></script>
  <script type="text/javascript">
 		var success1 = true;
 		var success2 = true;
 		var success3 = true;
 		var userName = $('#userName');
 		var pwd1 = $('#pwd1');
 		var pwd2 = $('#pwd2');
 		//验证用户名
 		userName.blur(function(){
 			var value = userName.val();
 			if(""==value||value==null){
 				//去除节点后面的所有同一级节点
 				userName.nextAll().remove();
 				userName.after("<span style='color:red'>用户名不能为空</span>");
 				success1 = false;
 			}else{
 				userName.nextAll().remove();
 				userName.after("<span style='color:green'>ok</span>");
 				success1 = true;
 			}
 		});
 		//验证密码
 		pwd1.blur(function(){
 			var value = pwd1.val();
 			if(value==null||value==""){
 				pwd1.nextAll().remove();
 				pwd1.after("<span style='color:red'>密码不能为空</span>");
 				success2 = false;
 			}else{
 				pwd1.nextAll().remove();
 				pwd1.after("<span style='color:green'>ok</span>");
 				success2 = true;
 			}
 		});
 		//验证确认密码
 		pwd2.blur(function(){
 			var value = pwd2.val();
 			if(value==null||value==""){
 				pwd2.nextAll().remove();
 				pwd2.after("<span style='color:red'>密码不能为空</span>");
 				success3 = false;
 			}else if(pwd1.val() != value){
 				pwd2.nextAll().remove();
 				pwd2.after("<span style='color:red'>两次密码不匹配</span>");
 				success3 = false;
 			}else{
 				pwd2.nextAll().remove();
 				pwd2.after("<span style='color:green'>ok</span>");
 				success3 = true;
 			}
 		});
 		
 		//判断前面的验证都通过了没
 		function check(){
 			if(success1 && success2 && success3){
 					return true;
 			}else{
 					return false;
 			}
 		};
 	
  </script>

</body>
</html>
