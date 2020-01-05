<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en" class="app">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="js/jPlayer/jplayer.flat.css"
	type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link rel="stylesheet" href="css/app.css" type="text/css" />
<style type="text/css">
#input{
	width:260px;
	border-radius:10px;
}
.left{
	width:20%;
	float:left;
	color:darkgreen;
	font-weight:900;
	border-right:1px solid gray;
}
.right{
	background-color: gainsboro;
	width:80%;
	float:left;
}
#container {
	background-color:white;
	position: absolute;
	top: 61px;
	left: 162px;
	border: 1px solid gray;
	width: 260px;
	border-radius:5px;
	text-align:center;
	opacity:1;
	display:none
}
.suggest{
	padding:0px;
	margin:0px;
}
.suggest li {
	cursor: pointer;
	list-style: none;
	font-size: 14px;
	color:black;
	font-weight:900;
}
#songList li span{
	font-size: 10px;
	margin-left:45px;
	color:gray;
} 
.suggest li:hover {
	background-color: yellowgreen;
}
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		//监听搜索button按钮点击事件
		$('#button').click(function() {
			//根据搜索内容跳转到指定页面
			window.location.href = "user";

		});

		//监听键盘按键抬起动作
		$('#input').keyup(function() {
			var code = event.keyCode;
			var value = $('#input').val();
			//监听键盘回车键
			if(code == 13) {
				//根据搜索内容跳转到指定页面
				window.location.href = "user";
			}
			//不断发送ajax请求
			$.post("search",{method:"doSearch",someName:value},function(data){
					//处理响应结果：
					var songArr = data.songs;
					var singerArr = data.singers;
					//将前面的提示行置空
					$("#songList").empty();
					$("#singerList").empty();
					$("#sleft").css("padding-top","0px");
					$("#sgleft").css("padding-top","0px");
					$("#sleft").outerHeight('22px');
					$("#sgleft").outerHeight('22px');
					//循环遍历歌曲集合
					for(var i = 0; i < songArr.length; i++) {
						$("#songList").append($("<li sid="+songArr[i].s_id+">" + songArr[i].s_name+"<span>"+songArr[i].singer.sg_name + "</span></li>"));
						if(i>=5){
							break;
						}
					};
					for(var i = 0; i < singerArr.length; i++) {
						$("#singerList").append($("<li sgid="+singerArr[i].sg_id+">" + singerArr[i].sg_name+"</li>"));
						if(i>=5){
							break;
						}
					};
					//动态设置div的高度
					var h1 = $("#songList").innerHeight();
					if(h1!=0){
						$("#sleft").outerHeight(h1+'px');
						$("#sleft").css("padding-top",h1/2-7+"px");
					}else{
						h1 = $("#sleft").outerHeight();
					}
					var h2 = $("#singerList").innerHeight();
					if(h2!=0){
						$("#sgleft").outerHeight(h2+'px');
						$("#sgleft").css("padding-top",h2/2-7+"px");
					}else{
						h2 = $("#sgleft").outerHeight();
					}
					$("#hr").css("margin","0px");
					$("#hr").css("border","1px solid gray");
					$("#hr").css("width","99%");
					var h3 = $("#hr").outerHeight();
					$("#container").innerHeight(h1+h2+h3+'px');
					$("#container").show();
				
			});
		});

		//给提示的行添加点击事件
		$("#songList").on('click','li', function() {
			window.location.href = "song?method=doShowSongDetail&s_id="+$(this).attr("sid");
		});
		
		$("#singerList").on('click','li', function() {
			window.location.href = "singer?method=doShowSingerDetail&sg_id="+$(this).attr("sgid");
		});
		
		//监听鼠标离开事件
		$(document).on('click',function(){
			$("#container").hide();
		});
		
	});
		
</script>

</head>

<header
	class="bg-white-only header header-md navbar navbar-fixed-top-xs">
	<div class="navbar-header aside bg-info nav-xs">
		<a class="btn btn-link visible-xs"
			data-toggle="class:nav-off-screen,open" data-target="#nav,html">
			<i class="icon-list"></i>
		</a> <a href="user" class="navbar-brand text-lt"> <i
			class="icon-earphones"></i> <img src="images/logo.png" alt="."
			class="hide"> <span class="hidden-nav-xs m-l-sm">Musik</span>
		</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
			data-target=".user"> <i class="icon-settings"></i>
		</a>
	</div>
	<ul class="nav navbar-nav hidden-xs">
		<li><a href="#nav,.navbar-header"
			data-toggle="class:nav-xs,nav-xs" class="text-muted"> <i
				class="fa fa-indent text"></i> <i class="fa fa-dedent text-active"></i>
		</a></li>
	</ul>
	<!-- 搜索框  -->
	<form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-btn">
					<button id="button" type="submit" class="btn btn-sm bg-white btn-icon rounded">
						<i class="fa fa-search"></i>
					</button>
				</span> <input  autocomplete="off" id="input" type="text" value="" class="form-control input-sm rounded"
					placeholder="搜索歌曲、歌手···">
			</div>
		</div>
	</form>
	<!-- 提示栏 -->
	<div id="container">
		<div id="songDiv">
			<div id="sleft" class="left">歌曲</div>
			<div id="sright" class="right">
				<ul id="songList" class="suggest"></ul>
			</div>
		</div>
		<hr id="hr"/>
		<div id="singerDiv">
			<div id="sgleft" class="left">歌手</div>
			<div id="sgright" class="right">
				<ul id="singerList" class="suggest"></ul>
			</div>
		</div>
	</div>
	<!-- 用户栏 -->
	<div class="navbar-right ">
		<ul class="nav navbar-nav m-n hidden-xs nav-user user">
			<li class="dropdown"><a href="#"
				class="dropdown-toggle bg clear" data-toggle="dropdown"> <span
					class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
						<c:choose>
							<c:when test="${user==null}">
								<img src="resource/u_images/default-none.png" alt="默认头像框">
							</c:when>
							<c:otherwise>
								<img src="${user.u_photo }" alt="头像">
							</c:otherwise>
						</c:choose>
				</span> ${user.u_loginId } <b class="caret"></b>
			</a>
				<ul class="dropdown-menu animated fadeInRight">
					<li><c:choose>
							<c:when test="${user==null}">
								<a href="jsp/signin.jsp">个人中心</a>
							</c:when>
							<c:otherwise>
								<a href="jsp/user.jsp">个人中心</a>
							</c:otherwise>
						</c:choose></li>
					<li class="divider"></li>
					<c:choose>
						<c:when test="${user==null}">
							<li><a href="jsp/signin.jsp">登录</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="user?method=doLogout">退出</a></li>
						</c:otherwise>
					</c:choose>
				</ul></li>
		</ul>
	</div>
</header>