<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="app">
<head>  
    <base href="<%=basePath%>">
  <meta charset="utf-8" />
  <title>专辑详情</title>
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
          <section class="vbox" id="bjax-el">
            <section class="scrollable wrapper-lg">
              <div class="row">
                <div class="col-sm-8">
                  <div class="panel wrapper-lg">
                    <div class="row">
                      <div class="col-sm-5">
                        <img src="images/m10.jpg" class="img-full m-b">
                      </div>
                      <div class="col-sm-7">
                        <h2 class="m-t-none text-black">${detailCD.c_name }</h2>
                        <div class="clearfix m-b-lg">
                          <a class="thumb-sm pull-left m-r">
                            <img src="${detailCD.singer.sg_coverUrl }" class="img-circle">
                          </a>
                          <div class="clear">
                            <a href="singer?method=doShowSingerDetail&sg_id=${detailCD.singer.sg_id}" class="text-info">${detailCD.singer.sg_name }</a>
                            <small class="block text-muted">${detailCD.c_songCount } 歌曲 / ${detailCD.c_collectionCount } 收藏</small>
                          </div>
                        </div>
                        <div class="m-b-lg">
                          <a class="btn btn-info">播放</a> <a class="btn btn-default">收藏</a>
                        </div>
                        <div>
                       		   发布时间: <span class="badge bg-dark m-l-sm m-t-sm"><fmt:formatDate value="${detailCD.c_publishDate }" pattern="yyyy-MM-dd" /></span>
                        </div>
                      </div>
                    </div>
                    <div class="m-t">
                      	简介：<p>${detailCD.c_introduce }</p>
                    </div>
                    <h4 class="m-t-lg m-b">歌曲列表</h4>
                    <ul class="list-group list-group-lg">
                     <c:forEach items="${detailCD.songs }" var="song">
                     	<li class="list-group-item">
	                        <div class="pull-right m-l">
	                          <a  class="m-r-sm"><i class="icon-cloud-download"></i></a>
	                          <a ><i class="icon-plus"></i></a>
	                        </div>
	                        <a  class="jp-play-me m-r-sm pull-left">
	                          <i class="icon-control-play text"></i>
	                          <i class="icon-control-pause text-active"></i>
	                        </a>
	                        <div class="clear text-ellipsis">
	                          <span>${song.s_name }</span>
	                          <span class="text-muted"> -- <fmt:formatNumber value="${(song.s_time)/60 }" pattern=".00" /></span>
	                        </div>
	                      </li>
                     </c:forEach>
                    </ul>
                  </div>
                </div>
                <div class="col-sm-4">
                  <div class="panel panel-default">
                    <div class="panel-heading">相似专辑</div>
                    <div class="panel-body">
                      <c:forEach items="${sameCds }" var="cd">
                      	 <article class="media">
	                        <a class="pull-left thumb-md m-t-xs">
	                          <img src="${cd.c_coverUrl }">
	                        </a>
	                        <div class="media-body">                        
	                          <a href="cd?method=doShowOneCD&cid=${cd.c_id}" class="font-semibold">${cd.c_name }</a>
	                          <div class="text-xs block m-t-xs"><a>${cd.c_introduce }</a></div>
	                        </div>
	                      </article>
                      </c:forEach>
                    </div>
                  </div>
                </div>
              </div>
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
  
  <script src="js/app.plugin.js"></script>
  <script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/demo.js"></script>

</body>
</html>
