<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <!DOCTYPE html>
<html lang="en" class="app">
<head>  
    <base href="<%=basePath%>">
  <meta charset="utf-8" />
  <title>个人中心</title>
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
<body class="">
<section class="vbox">
    	<!-- 引入头部jsp -->
		<jsp:include page="header.jsp"></jsp:include>

		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<aside class="bg-black dk nav-xs aside hidden-print" id="nav">
					<section class="vbox">


						<!-- 引入左边导航栏jsp -->
						<jsp:include page="left.jsp"></jsp:include>
            

          </section>
        </aside>
        <!-- /.aside -->
        <section id="content">
          <section class="vbox">
            <section class="scrollable">
              <section class="hbox stretch">
                <aside class="aside-lg bg-light lter b-r">
                  <section class="vbox">
                    <section class="scrollable">
                      <div class="wrapper">
                        <div class="text-center m-b m-t">
                          <a class="thumb-lg">
                            <img src="${user.u_photo }" class="img-circle">
                          </a>
                          <div>
                            <div class="h3 m-t-xs m-b-xs">${user.u_loginId }</div>
                            <small class="text-muted">${user.u_sex }</small>
                          </div>   
                          <button type="button" class="btn btn-primary">修改个人信息</button>             
                        </div>
                        <div class="panel wrapper">
                          <div class="row text-center">
                            <div class="col-xs-6">
                                <span class="m-b-xs h4 block">245</span>
                                <small class="text-muted">粉丝</small>
                              </a>
                            </div>
                            <div class="col-xs-6">
                              <a >
                                <span class="m-b-xs h4 block">55</span>
                                <small class="text-muted">关注</small>
                              </a>
                            </div>
                          </div>
                        </div>
                        <div class="btn-group btn-group-justified m-b">
                          <a class="btn btn-success btn-rounded" data-toggle="button">
                          </a>
                          <a class="btn btn-dark btn-rounded">
                          </a>
                        </div>
                        <div>
                          <small class="text-uc text-xs text-muted">邮箱</small>
                          <p>${user.u_email }</p>
                          <small class="text-uc text-xs text-muted">电话</small>
                          <p>${user.u_phone }</p>
                        </div>
                      </div>
                    </section>
                  </section>
                </aside>
                <aside class="bg-white">
                  <section class="vbox">
                    <header class="header bg-light lt">
                      <ul class="nav nav-tabs nav-white">
                        <li class="active"><a href="#activity" data-toggle="tab">我的听歌记录</a></li>
                        <li class=""><a href="#events" data-toggle="tab">我收藏的歌手</a></li>
                        <li class=""><a href="#interaction" data-toggle="tab">我收藏的专辑</a></li>
                      </ul>
                    </header>
                    <section class="scrollable">
                      <div class="tab-content">
                        <div class="tab-pane active" id="activity">
                          <ul class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
                            <c:forEach items="${user.heardSongs }" var="hearSong">
                            	<li class="list-group-item">
	                              <a class="thumb-sm pull-left m-r-sm">
	                                <img src="${hearSong.song.s_coverUrl }" class="img-circle">
	                              </a>
	                              <a href="song?method=doShowSongDetail&s_id=${hearSong.song.s_id }" class="clear">
	                                <small class="pull-right">${hearSong.hsh_date }</small>
	                                <strong class="block">${hearSong.song.s_name }</strong>
	                                <small>${hearSong.song.s_languageType }</small>
	                              </a>
	                            </li>
                            </c:forEach>
                          </ul>
                        </div>
                        <div class="tab-pane" id="events">
                          <ul class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
                          	<c:forEach items="${user.collectionSgs }" var="singer">
                          		<li class="list-group-item">
		                              <a class="thumb-sm pull-left m-r-sm">
		                                <img src="${singer.sg_coverUrl }" class="img-circle">
		                              </a>
		                              <a href="singer?method=doShowSingerDetail&sg_id=${singer.sg_id }" class="clear">
		                                <small class="pull-right">收藏：${singer.sg_collectionCount}</small>
		                                <strong class="block">${singer.sg_name }</strong>
		                                <small>${singer.sg_introduce }</small>
		                              </a>
                           		 </li>
                          	</c:forEach>
						  </ul>
                        </div>
                        <div class="tab-pane" id="interaction">
                            <ul class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
                           		<c:forEach items="${user.collectionCds }" var="cd">
                           			<li class="list-group-item">
		                              <a class="thumb-sm pull-left m-r-sm">
		                                <img src="${cd.c_coverUrl }" class="img-circle">
		                              </a>
		                              <a href="cd?method=doShowOneCD&cid=${cd.c_id}" class="clear">
		                                <small class="pull-right">收藏：${cd.c_collectionCount }</small>
		                                <strong class="block">${cd.c_name }</strong>
		                                <small>${cd.c_introduce }</small>
		                              </a>
		                            </li>
                           		</c:forEach>
						  </ul>
                        </div>
                      </div>
                    </section>
                  </section>
                </aside>
              </section>
            </section>
          </section>
          <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
        </section>
      </section>
    </section>    
  </section>
  <script src="js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="js/bootstrap.js"></script>
  <!-- App -->
  <script src="js/app.js"></script>  
  <script src="js/slimscroll/jquery.slimscroll.min.js"></script>
  <script src="js/charts/easypiechart/jquery.easy-pie-chart.js"></script>
  <script src="js/app.plugin.js"></script>
  <script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/demo.js"></script>

</body>
</html>