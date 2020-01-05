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
  <title>歌曲详情</title>
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
        <div id="addmess" class="alter hide" role="alert"></div>
          <section class="vbox" id="bjax-el">
            <section class="scrollable wrapper-lg">
              <div class="row">
                <div class="col-sm-8">
                  <div class="panel wrapper-lg">
                    <div class="row">
                      <div class="col-sm-5">
                        <img src="${song.s_coverUrl}" class="img-full m-b">
                      </div>
                      <div class="col-sm-7">
                        <h2 class="m-t-none text-black">${song.s_name}</h2>
                        <div class="clearfix m-b-lg">
                          <a class="thumb-sm pull-left m-r">
                            <img src="${singer.sg_coverUrl }" class="img-circle">
                          </a>
                          <div class="clear">
                            <a href="singer?method=doShowSingerDetail&sg_id=${singer.sg_id }" class="text-info">${singer.sg_name}</a>
                            <small class="block text-muted">${song.s_playCount} 播放 / ${song.s_downloadCount} 下载</small>
                          </div>
                        </div>
                        <div class="m-b-lg">
                         
                          <a class="btn btn-info" onclick="playSong(${song.s_id});" >播放</a> 
                        	<!-- 模态框 -->
                          <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="exampleModalLabel">收藏歌曲</h4>
							      </div>
							      <!-- 收藏表单 -->
							      <form action="user" method="get">
							      <div class="modal-body">
							          <div class="form-group">
							            <label for="recipient-name" class="control-label">添加到歌单：</label>
							            <input type="hidden" value="doAddLoveSongList" name="method"/>
							            <input type="hidden" value="${song.s_id}" name="s_id"/>
							            <div class="dropdown">
										  <select class="btn btn-default dropdown-toggle" name="selectsonglist">
										  	  <c:forEach items="${usersongLists}" var="usonglist">
												  <option value ="${usonglist.sl_id}">${usonglist.sl_name}</option>
											  </c:forEach>
										  </select>
										</div>
							          </div>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							        <input type="submit" class="btn btn-primary" value="加入歌单" />
							      </div>
							     </form>
							    </div>
							  </div>
							</div>
                          <button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModal">收藏</button>
                        </div>
                        <div>
                          	标签: 
	                          <a class="badge bg-light">${type.t_name}</a> 
                        </div>
                      </div>
                    </div>
                    <div class="m-t">
                    	歌词内容：
                      <p><iframe width="340" height="400 " src='${song.s_songWordUrl}'></iframe></p>
                    </div>
                    <h4 class="m-t-lg m-b">${sComments.size() } 评论</h4>
                    <section class="comment-list block">
                    	<c:forEach items="${sComments }" var="sComment">
                    		<article id="comment-id-1" class="comment-item">
		                        <a class="pull-left thumb-sm">
		                          <img src="${sComment.user.u_photo }" class="img-circle">
		                        </a>
		                        <section class="comment-body m-b">
		                          <header>
		                            <a><strong>${sComment.user.u_loginId }</strong></a>
		                            <label class="label bg-info m-l-xs">${sComment.sc_praiseCount }赞</label> 
		                            <span class="text-muted text-xs block m-t-xs">
		                              ${sComment.sc_time }
		                            </span>
		                          </header>
		                          <div class="m-t-sm">${sComment.sc_text }</div>
		                        </section>
                      		</article>
                    	</c:forEach>
                    </section>
                    <h4 class="m-t-lg m-b">我要评论</h4>
                    <form action="comment" method="post" onsubmit="return subCheck()">
                      <div class="form-group">
                        <label>评论内容：</label>
                        <input type="hidden" name="method" value="doSongComment">
                        <input type="hidden" name="sc_songId" value="${song.s_id }">
                        <textarea name="s_text" id="comment" class="form-control" rows="5"></textarea>
                      </div>
                      <div class="form-group">
                        <button id="sub" userId="${user.u_id }" class="btn btn-success">发布评论</button>
                      </div>
                    </form>
                  </div>
                </div>
                
                <div class="col-sm-4">
                  <div class="panel panel-default">
                    <div class="panel-heading">相似歌曲</div>
                    <div class="panel-body">
                    	<c:forEach items="${likesongs}" var="song">
	                      <article class="media">
	                        <a class="pull-left thumb-md m-t-xs">
	                          <img src="${song.s_coverUrl}">
	                        </a>
	                        <div class="media-body">                        
	                          <a href="song?method=doShowSongDetail&s_id=${song.s_id }" class="font-semibold">${song.s_name}</a>
	                          <div class="text-xs block m-t-xs"><a href="singer?method=doShowSingerDetail&sg_id=${song.singer.sg_id }">${song.singer.sg_name}</a> ${song.s_publishDate}</div>
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
		 
			$(function(){
				$("#addmess").removeClass("hide");
				var show = ${param.result};
				if(show=="1"){
					$("#addmess").addClass("alert-success");
					$("#addmess").html("增加成功");
					$("#addmess").show();
				}else{
					$("#addmess").addClass("alert-danger");
					$("#addmess").html("增加失败");
					$("#addmess").show();
				}
				
				setTimeout(function(){
					$("#addmess").hide(400);
				},2000);
			});
			
			// 播放器
			var Player = {
					
				// 歌曲数据
				fileData: [],
				
				// 图片数据
				imageData: [],
				
				//歌名数据
				nameData:[],
				
				// 当前播放歌曲的 索引
				currentIndex: -1,
				
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

				// 就绪
				ready: function() {
					// 初始化播放列表
					$("#showlist").click(function(){
						var mhtml = "";
						for (var i = 0; i < Player.nameData.length; i++) {
							mhtml += "<li><a index='"+i+"'>"+Player.nameData[i]+"</a></li>";
						}
						Player.$mList.html(mhtml);
						
					});
					
					// 下一曲
					$('#forward').click(function() {
						if(Player.currentIndex == -1) {
							Player.currentIndex = 0;
						} else if(Player.currentIndex == (Player.nameData.length - 1)) {
							Player.currentIndex = 0;
						} else {
							Player.currentIndex++;
						}
						console.log("Player.currentIndex : " + Player.currentIndex);
						Player.audio.src =  Player.fileData[Player.currentIndex];
						Player.audio.play();
					});

					// 上一曲
					$('#backward').click(function() {
						if(Player.currentIndex == -1) {
							Player.currentIndex = 0;
						} else if(Player.currentIndex == 0) {
							Player.currentIndex = (Player.nameData.length - 1);
						} else {
							Player.currentIndex--;
						}
						Player.audio.src = Player.fileData[Player.currentIndex];
						Player.audio.play();
					});

					// 单曲循环
					$('#sequence').click(function() {
						console.log("Player.currentIndex :", Player.currentIndex);
						Player.audio.onended = function() {
							Player.audio.load();
							Player.audio.play();
						};
					});

					// 顺序播放
					$('#btn-order').click(function() {
						console.log("Player.currentIndex :", Player.currentIndex);
						Player.audio.onended = function() {
							$('#btn-next').click();
						};
					});

					// 随机播放
					$('#randoms').click(function() {
						Player.audio.onended = function() {
							var i = parseInt((Player.nameData.length - 1) * Math.random());
							playByMe(i);
						};
					});

					// 播放指定歌曲
					function playByMe(i) {
						console.log("index:", i);
						Player.audio.src = Player.fileData[i];
						Player.audio.play();
						Player.currentIndex = i;
						Player.$rmusic.html(Player.nameData[Player.currentIndex]);
					}

					// 歌曲被点击
					$("#songlist li a").click(function() {
						playByMe($(this).attr('index'));
					});
				}
			};
			
		Player.init();
		Player.ready();
		
		// 播放/暂停
		function change() {
			if(Player.audio.paused){
				$("#play i:eq(0)").addClass("icon-control-pause").removeClass("icon-control-play");
				Player.audio.play();
			}else{
				$("#play i:eq(0)").addClass("icon-control-play").removeClass("icon-control-pause");
				Player.audio.pause();
			}
			if(Player.currentIndex == -1) {
				$('#forward').click();
			}
		};
		
		function playSong(id){
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
				change();
			});
		};
		
		//显示播放时间
		function updateTime(e){
			//初始化播放时长
			var time = fmt((e.currentTime));
			$("#nowTime").html(time);
			//初始化歌曲时长
			var durTime = fmt((e.duration));
			$("#stime").html(durTime);
		};
		
		function fmt(time){
			var minite = (time/60).toFixed(0);
			var second = (time%60).toFixed(0);
			return minite+":"+second;
		}

			
			
			
	</script>
</body>
</html>
