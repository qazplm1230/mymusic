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
  <title>歌手</title>
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
                            <img src="${singer.sg_coverUrl}" class="img-circle">
                          </a>
                          <div>
                            <div class="h3 m-t-xs m-b-xs" >${singer.sg_name}</div>
                            <small class="text-muted"><i class="fa fa-map-marker" >${area.a_name}</i></small>
                          </div>
                        </div>
                        <div class="panel wrapper">
                          <div class="row text-center">
                            <div class="col-xs-12">
								歌手简介：<br />
								<p>
								<c:choose>
									<c:when test="${singer.sg_introduce==null}">
										这个人很懒什么都没有留下...
									</c:when>
									<c:otherwise>
										${singer.sg_introduce}
									</c:otherwise>
								</c:choose>
								</p>
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
                          <small class="text-uc text-xs text-muted">歌手性别</small>
                          <p>								
                          	<c:choose>
								<c:when test="${singer.sg_sex=='0'}">
										女
								</c:when>
								<c:when test="${singer.sg_sex=='1'}">
										男
								</c:when>
								<c:otherwise>
										不详
								</c:otherwise>
							</c:choose>
						  </p>
                          <small class="text-uc text-xs text-muted">歌手生日</small>
                          <p>${singer.sg_birthday}</p>
                        </div>
                      </div>
                    </section>
                  </section>
                </aside>
                <aside class="bg-white">
                  <section class="vbox">
                    <header class="header bg-light lt">
                      <ul class="nav nav-tabs nav-white">
                        <li class="active"><a href="#activity" data-toggle="tab">专辑</a></li>
                        <li class=""><a href="#events" data-toggle="tab">热歌</a></li>
                      </ul>
                    </header>
                    <section class="scrollable">
                      <div class="tab-content">
                        <div class="tab-pane active" id="activity">
                          <ul class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
                           <c:forEach items="${cds}" var="cd">
                            <li class="list-group-item">
                              <a class="thumb-sm pull-left m-r-sm">
                                <img src="${cd.c_coverUrl}" class="img-circle">
                              </a>
                              <a href="cd?method=doShowOneCD&cid=${cd.c_id}" class="clear">
                                <small class="pull-right">${cd.c_publishDate}</small>
                                <strong class="block">${cd.c_name}</strong>
                                <small>${cd.c_introduce}</small>
                              </a>
                            </li>
                            </c:forEach>
                          </ul>
                        </div>
                        <div class="tab-pane" id="events">
                          <ul class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
                          	<c:forEach items="${songs}" var="song">
	                            <li class="list-group-item">
	                              <a class="thumb-sm pull-left m-r-sm">
	                                <img src="${song.s_coverUrl}" class="img-circle">
	                              </a>
	                              <a href="song?method=doShowSongDetail&s_id=${song.s_id }" class="clear">
	                                <small class="pull-right">${song.s_publishDate}</small>
	                                <strong class="block">${song.s_name}</strong>
	                                <small></small>
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