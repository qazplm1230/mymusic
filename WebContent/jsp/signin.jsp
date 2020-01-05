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
  <title>登录</title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="css/animate.css" type="text/css" />
  <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="css/font.css" type="text/css" />
  <link rel="stylesheet" href="css/app.css" type="text/css" />  

</head>
<body class="bg-info dker">
  <section id="content" class="m-t-lg wrapper-md animated fadeInUp">    
    <div class="container aside-xl">
      <a class="navbar-brand block" href="index.html"><span class="h1 font-bold">Musik</span></a>
      <section class="m-b-lg">
        <header class="wrapper text-center">
          <strong style="color:red">${result }</strong>
        </header>
        <form action="user" method="post" onsubmit="return check()">
          <div class="form-group">
         	 <input type="hidden" name="method" value="doUserLogin" class="form-control rounded input-lg text-center no-border">
            <input id="userName" type="text" placeholder="用户名" name="userName" class="form-control rounded input-lg text-center no-border">
          </div>
          	
          <div class="form-group">
             <input id="pwd" type="password" placeholder="密码" name="pwd" class="form-control rounded input-lg text-center no-border">
          </div>
          <button class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">登录</span></button>
          <div class="text-center m-t m-b"><a ><small>忘记密码?</small></a></div>
          <div class="line line-dashed"></div>
          <p class="text-muted text-center"><small>还没有创建账号?</small></p>
          <a href="jsp/signup.jsp" class="btn btn-lg btn-info btn-block rounded">创建一个账号</a>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder">
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
 		var userName = $('#userName');
 		var pwd = $('#pwd');
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
 		pwd.blur(function(){
 			var value = pwd.val();
 			if(value==null||value==""){
 				pwd.nextAll().remove();
 				pwd.after("<span style='color:red'>密码不能为空</span>");
 				success2 = false;
 			}else{
 				pwd.nextAll().remove();
 				pwd.after("<span style='color:green'>ok</span>");
 				success2 = true;
 			}
 		});
 		//判断前面的验证都通过了没
 		function check(){
 			if(success1 && success2){
 					return true;
 			}else{
 					return false;
 			}
 		};
 	
  </script>
</body>
</html>