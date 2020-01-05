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
  <title>歌单</title>
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
            <div id="masonry" class="pos-rlt animated fadeInUpBig">
              <div class="item">
                <div class="carousel slide auto" data-interval="3000">
                  <div class="carousel-inner">
                    <div class="item active">
                      <div class="item-overlay opacity animated fadeInDown wrapper bg-info">
                        <p class="text-white">${songlists[0].sl_accessCount }</p>
                        <div class="center text-center m-t-n">
                          <a href="songlist?method=doShowSongListDetail&sl_id=${songlists[0].sl_id }"><i class="icon-control-play i-2x"></i></a>
                        </div>
                      </div>
                      <div class="bottom wrapper bg-info gd">
                        <div class="m-t m-b"><a href="songlist?method=doShowSongListDetail&sl_id=${songlists[0].sl_id }" class="b-b b-info h4 text-u-c text-lt font-bold">${songlist.sl_name }s" class="b-b b-danger h2 text-u-c text-lt font-bold">${songlists[0].sl_name }</a></div>
                        <p class="hidden-xs">${songlists[0].sl_introduce }</p>
                      </div>
                      <a><img src="resource/sl_images/piano.PNG" alt="" class="img-full"></a>
                    </div>
                    <div class="item">
                      <div class="item-overlay opacity animated fadeInDown wrapper bg-info">
                        <p class="text-white">01</p>
                        <div class="center text-center m-t-n">
                          <a href="songlist?method=doShowSongListDetail&sl_id=${songlists[0].sl_id }"><i class="icon-control-play i-2x"></i></a>
                        </div>
                      </div>
                      <div class="bottom wrapper bg-info gd">
                        <div class="m-t m-b"><a href="songlist?method=doShowSongListDetail&sl_id=${songlists[0].sl_id }" class="b-b b-info h4 text-u-c text-lt font-bold">${songlist.sl_name }" class="b-b b-warning h2 text-u-c text-lt font-bold">${songlists[0].sl_name }</a></div>
                        <p class="hidden-xs">${songlists[0].sl_introduce }</p>
                      </div>
                      <a><img src="${songlists[0].sl_coverUrl }" alt="" class="img-full"></a>
                    </div>
                  </div>
                </div>
              </div>
              <c:forEach items="${songlists }" var="songlist" begin="1">
              		<div class="item">
		                <div class="item-overlay gd animated fadeInUp wrapper bg-info">
		                  <p class="text-white">${songlist.sl_accessCount }</p>
		                  <div class="center text-center m-t-n">
		                    <a href="songlist?method=doShowSongListDetail&sl_id=${songlist.sl_id }"><i class="icon-control-play i-2x"></i></a>
		                  </div>
		                </div>
		                <div class="bottom gd bg-info wrapper">
		                  <div class="m-t m-b"><a href="songlist?method=doShowSongListDetail&sl_id=${songlist.sl_id }" class="b-b b-info h4 text-u-c text-lt font-bold">${songlist.sl_name }</a></div>
		                  <p class="hidden-xs">${songlist.sl_introduce }</p>
		                </div>
		                <a ><img src="${songlist.sl_coverUrl }" alt="" class="img-full"></a>
		              </div>
              </c:forEach>
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
    <script src="js/masonry/tiles.min.js"></script>
  <script src="js/masonry/demo.js"></script>
  <script src="js/app.plugin.js"></script>
  <script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="js/jPlayer/demo.js"></script>

</body>
</html>
