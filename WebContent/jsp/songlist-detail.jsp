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
  <title>歌单详情</title>
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
                        <img src="${songlist.sl_coverUrl }" class="img-full m-b">
                      </div>
                      <div class="col-sm-7">
                        <h2 class="m-t-none text-black">${songlist.sl_name }</h2>
                        <div class="clearfix m-b-lg">
                          <a class="thumb-sm pull-left m-r">
                            <img src="${songlist.user.u_photo }" class="img-circle">
                          </a>
                          <div class="clear">
                            <a class="text-info">${songlist.user.u_loginId }</a>
                            <small class="block text-muted">${songlist.sl_accessCount } 访问 / 225 收藏</small>
                          </div>
                        </div>
                        <div class="m-b-lg">
                          <a class="btn btn-info">播放</a> <a class="btn btn-default">收藏</a>
                        </div>
                        <div>
                          	标签: <a class="badge bg-light">${songlist.sl_tags }</a>
                        </div>
                      </div>
                    </div>
                    <div class="m-t">
                      	专辑简介：<p>${songlist.sl_introduce }</p>
                    </div>
                    <h4 class="m-t-lg m-b">歌曲列表</h4>
                    <ul id="slist" class="list-group list-group-lg">
                     	<c:forEach items="${songlist.songs }" var="song"> 
                     		<li class="list-group-item">
		                        <div class="pull-right m-l">
		                          <a  class="m-r-sm"><i class="icon-cloud-download"></i></a>
		                          <a ><i class="icon-plus"></i></a>
		                          <c:if test="${user.u_id == songlist.user.u_id }">
		                          	<a songId="${song.s_id }" slId="${songlist.sl_id }" onclick="rSong(this);"><i class="icon-close"></i></a>
		                          </c:if>
		                        </div>
		                        <!-- audio中如果出现controls属性则说明会弹出界面框 -->
								<audio id="audio">
           						</audio> 
		                        <a class="dispaly" onclick="playSong(${song.s_id},this);" class="jp-play-me m-r-sm pull-left">
		                          <i class="icon-control-play"></i>
		                        </a>
		                        <div class="clear text-ellipsis">
		                          <span>${song.s_name }</span>
		                          <span class="text-muted"> -- <fmt:formatNumber value="${(song.s_time)/60 }" pattern=".00" /></span>
		                        </div>
		                      </li>
                     	</c:forEach>
                    </ul>
                    <h4 class="m-t-lg m-b">${comments.size() } 评论</h4>
                    <section class="comment-list block">
                    	<c:forEach items="${comments }" var="comment">
                    		<article id="comment-id-1" class="comment-item">
		                        <a class="pull-left thumb-sm">
		                          <img src="${comment.user.u_photo }" class="img-circle">
		                        </a>
		                        <section class="comment-body m-b">
		                          <header>
		                            <a><strong>${comment.user.u_loginId }</strong></a>
		                             <label class="label bg-dark m-l-xs">${comment.slc_praiseCount }赞</label> 
		                            <span class="text-muted text-xs block m-t-xs">
		                              ${comment.slc_time }
		                            </span>
		                          </header>
		                          <div class="m-t-sm">${comment.slc_text }</div>
		                        </section>
		                      </article>
                    	</c:forEach>
                    </section>
                    <h4 class="m-t-lg m-b">我要评论</h4>
                    <form action="comment" method="post" onsubmit="return subCheck()">
                      <div class="form-group">
                        <label>评论内容：</label>
                        <input type="hidden" name="method" value="doSongListComment">
                        <input type="hidden" name="slc_songlistId" value="${songlist.sl_id }">
                        <textarea id="comment" name="slc_text" class="form-control" rows="5"></textarea>
                      </div>
                      <div class="form-group">
                        <button id="sub" userId="${user.u_id }" class="btn btn-success">发布评论</button>
                      </div>
                    </form>
                  </div>
                </div>
                <div class="col-sm-4">
                  <div class="panel panel-default">
                    <div class="panel-heading">相似歌单</div>
                    <div class="panel-body">
                      <c:forEach items="${songlists }" var="slist">
                      		<article class="media">
		                        <a href="songlist?method=doShowSongListDetail&sl_id=${slist.sl_id }" class="pull-left thumb-md m-t-xs">
		                          <img src="${slist.sl_coverUrl }">
		                        </a>
		                        <div class="media-body">                        
		                          <a href="songlist?method=doShowSongListDetail&sl_id=${slist.sl_id }" class="font-semibold">${slist.sl_name }</a>
		                          <div class="text-xs block m-t-xs"><a>${slist.sl_introduce }</a></div>
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
	<script type="text/javascript">
		var isClick = false;	
		//点击检查
		 $("#sub").click(function(){
			 var userId = $("#sub").attr("userId");
			 var comment = $("#comment").val();
			 if(userId == null || userId == ""){
				 window.location.href = "jsp/signin.jsp";
			 }else if(comment!=null && comment!=""){
				 console.log(comment);
				 isClick = true;
			 }
				 
		 });
		//提交检查
		 function subCheck(){
			 if(isClick){
				 return true;
			 }else{
				 return false;
			 }
		 };
		 
		 function rSong(a){
			 //通过获取该歌曲的id和歌单id，发送异步请求，删除该歌曲
			 var songId = $(a).attr("songId");
			 var slId = $(a).attr("slId");
			 $.get("songlist",{method:"doRemoveSongFromSonglist",s_id:songId,sl_id:slId},function(data){
				 //删除成功与否的结果信息
				 var value = data;
				 if(value == 0){
					 
				 }else if(value == 1){
					 //删除该节点
					 var li = $(a).parent().parent();
					 li.remove();
				 }
			 });
		 }
		 
		 
		// 播放器
			var Player = {
					
				// 歌曲数据
				fileData: [],
				
				// 图片数据
				imageData: [],
				
				//歌名数据
				nameData:[],
				
				// 当前播放歌曲的 索引
				currentIndex: 0,
				
				//图片元素
				$image: $('#imcover'),
				
				//  播放器元素jquery对象
				$audio: $('audio'),

				// 歌曲列表
				$mList: $('#songlist'),
				
				//正在播放的歌曲
				$rmusic: $('#rmusic'),
				
				//初始化
				init: function(){
					// 控制
					Player.audio = Player.$audio.get(0);
					// 初始化歌曲数据
					Player.fileData[0] = "resource/s_file/张国荣 - 春夏秋冬.mp3";
					// 初始化图片数据
					Player.imageData[0] = "resource/s_images/chunxiaqiudong.PNG";
					//初始化歌名数据
					Player.nameData[0] = "春夏秋冬";
					//初始化当前歌名
					Player.$rmusic.html(Player.nameData[0]);
					//初始化当前图片路径
					Player.$image.attr("src",Player.imageData[0]);
					//初始化当前文件路径
					Player.audio.src =  Player.fileData[0];
				},

			};
			
		Player.init();
		
		// 播放/暂停
		function change(i) {
			if(Player.audio.paused && Player.fileData[0] != "null"){
				$(i).children().addClass("icon-control-pause").removeClass("icon-control-play");
				Player.audio.src =  Player.fileData[Player.currentIndex];
				Player.audio.play();
			}else{
				$(i).children().addClass("icon-control-play").removeClass("icon-control-pause");
				Player.audio.pause();
				return;
			}
		};
		
		function playSong(id,btn){
			if(!Player.audio.paused){
				$(btn).children().addClass("icon-control-play").removeClass("icon-control-pause");
				Player.audio.pause();
				return;
			}else{
				$.get("song",{method:"doGsonSong",songId:id+""},function(data){
					var song = data;
					// 初始化歌曲数据
					Player.fileData[0] = song.s_songUrl;
					// 初始化图片数据
					Player.imageData[0] = song.s_coverUrl;
					//初始化歌名数据
					Player.nameData[0] = song.s_name;
					//初始化当前歌名
					Player.$rmusic.html(Player.nameData[0]);
					//初始化当前图片路径
					Player.$image.attr("src",Player.imageData[0]);
					//初始化当前文件路径
					Player.audio.src =  Player.fileData[0];
					//播放
					change(btn);
				});
				
			}
		};
		
	</script>
</body>
</html>