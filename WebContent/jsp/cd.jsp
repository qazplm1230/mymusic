<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="app">
<head>  
    <base href="<%=basePath%>">
  <meta charset="utf-8" />
  <title>专辑</title>
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
            <section class="scrollable padder-lg">
            
              <h2 class="font-thin m-b">新碟上架</h2>
              <div class="row row-sm">
              	<c:forEach items="${newCds }" var="newCd">
              		 <div class="col-xs-1 col-sg-0">
	                  <div class="item">
	                    <div class="pos-rlt">
	                      <div class="item-overlay opacity r r-2x bg-black">
	                        <div class="center text-center m-t-n">
	                          <a href="cd?method=doShowOneCD&cid=${newCd.c_id}"><i class="fa fa-play-circle i-2x"></i></a>
	                        </div>
	                      </div>
	                      <a><img src="${newCd.c_coverUrl }" alt="" class="r r-2x img-full"></a>
	                    </div>
	                    <div class="padder-v">
	                      <a href="cd?method=doShowOneCD&cid=${newCd.c_id}" class="text-ellipsis">${newCd.c_name }</a>
	                      <a href="singer?method=doShowSingerDetail&sg_id=${newCd.singer.sg_id}" class="text-ellipsis text-xs text-muted">${newCd.singer.sg_name }</a>
	                       <span class="badge bg-dark m-l-sm m-t-sm"><fmt:formatDate value="${newCd.c_publishDate }" pattern="yyyy-MM-dd" /></span>
	                    </div>
	                  </div>
	                </div>
              	</c:forEach>
              </div>
              <h3 class="font-thin m-b">全部专辑</h3>
              <div class="row row-sm">
               <c:forEach items="${cds}" var="c">
                <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                  <div class="item">
                    <div class="pos-rlt">
                      <div class="item-overlay opacity r r-2x bg-black">
                        <div class="center text-center m-t-n">
                          <a href="cd?method=doShowOneCD&cid=${c.c_id}"><i class="fa fa-play-circle i-2x"></i></a>
                        </div>
                      </div>
                      <a><img src="${c.c_coverUrl}" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                      <a href="cd?method=doShowOneCD&cid=${c.c_id}" class="text-ellipsis">${c.c_name}</a>
                      <a href="singer?method=doShowSingerDetail&sg_id=${c.singer.sg_id}" class="text-ellipsis text-xs text-muted">${c.singer.sg_name }</a>
                    </div>
                  </div>
                </div> 
                </c:forEach>             
               </div>        
              
             
              <ul class="pagination pagination">
                <li><a href="cd?method=doShowNewCDS"><i class="fa fa-chevron-left"></i></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="cd?method=doShowNewCDS">2</a></li>
                <li><a href="cd?method=doShowNewCDS">3</a></li>
                <li><a href="cd?method=doShowNewCDS">4</a></li>
                <li><a href="cd?method=doShowNewCDS">5</a></li>
                <li><a href="cd?method=doShowNewCDS"><i class="fa fa-chevron-right"></i></a></li>
              </ul>
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
