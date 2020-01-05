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
  <title>听歌</title>
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
#songlist li a{
	cursor:pointer;
}
</style>

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
          <section class="w-f-md">
            <section class="hbox stretch bg-black dker">
              <!-- side content -->
              <aside class="col-sm-5 no-padder" id="sidebar">
                <section class="vbox animated fadeInUp">
                  <section class="scrollable">
                    <div class="m-t-n-xxs item pos-rlt">
                      <div class="bottom gd bg-info wrapper-lg">
                        <span class="pull-right text-sm">${firstSonglist.sl_collectionCount}<br>收藏</span>
                        <span class="h2 font-thin">${firstSonglist.sl_name}</span>
                      </div>
                      <img class="img-full" src="${firstSonglist.sl_coverUrl}" alt="...">
                    </div>
                    <ul class="list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto">
                    	<c:forEach items="${usersongs}" var="song">
	                      <li class="list-group-item">
	                        <div class="pull-right m-l">
	                          <a  class="m-r-sm"><i class="icon-cloud-download"></i></a>
	                          <a  class="m-r-sm"><i class="icon-plus"></i></a>
	                          <a onclick="rSong(this);"><i class="icon-close"></i></a>
	                        </div>
	                        <a href="#" onclick="playSong(${song.s_id});" class="jp-play-me m-r-sm pull-left">
	                          <i class="icon-control-play text"></i>
	                          <i class="icon-control-pause text-active"></i>
	                        </a>
	                        <div class="clear text-ellipsis">
	                          <span>${song.s_name}</span>
	                          <span class="text-muted"> -- <fmt:formatNumber type="number" value='${song.s_time/60}' maxFractionDigits="0"/>:
	                          <fmt:formatNumber type="number" value='${song.s_time%60}' maxFractionDigits="0"/></span>
	                        </div>
	                      </li>
                      	</c:forEach>
                    </ul>
                  </section>
                </section>
              </aside>
              <!-- / side content -->
              <section class="col-sm-4 no-padder bg">
                <section class="vbox">
                  <section class="scrollable hover">
                    <ul class="list-group list-group-lg no-bg auto m-b-none m-t-n-xxs">
                    	<c:forEach items="${userSonglists}" var="songlist">
	                      <li class="list-group-item clearfix">
	                        <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
	                          <i class="icon-control-play text"></i>
	                          <i class="icon-control-pause text-active"></i>
	                        </a>
	                        <a class="pull-left thumb-sm m-r">
	                          <img src="${songlist.sl_coverUrl}" alt="...">
	                        </a>
	                        <a class="clear" href="songlist?method=doShowSongListDetail&sl_id=${songlist.sl_id }">
	                          <span class="block text-ellipsis">${songlist.sl_name}</span>
	                          <small class="text-muted">${songlist.sl_introduce}</small>
	                        </a>
	                      </li>
                     	</c:forEach>
                    </ul>
                  </section>
                </section>
              </section>
              <section class="col-sm-3 no-padder lt">
                <section class="vbox">
                  <section class="scrollable hover">
                    <div class="m-t-n-xxs">
                      <div class="item pos-rlt">
                        <a href="user" class="item-overlay active opacity wrapper-md font-xs">
                          <span class="block h3 font-bold text-info">发现</span>
                          <span class="text-muted">寻找你喜欢的音乐</span>
                          <span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>
                        </a>
                        <a href="user">
                          <img class="img-full" src="images/m40.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="user" class="item-overlay active opacity wrapper-md font-xs text-right">
                          <span class="block h3 font-bold text-warning text-u-c">聆听</span>
                          <span class="text-muted">寻找心灵的节奏</span>
                          <span class="bottom wrapper-md block"><i class="icon-arrow-right i-lg pull-left"></i> -</span>
                        </a>
                        <a href="user">
                          <img class="img-full" src="images/m41.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="user" class="item-overlay active opacity wrapper-md font-xs">
                          <span class="block h3 font-bold text-success text-u-c">分享</span>
                          <span class="text-muted">分享你最喜爱的歌曲</span>
                          <span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>
                        </a>
                        <a href="user">
                          <img class="img-full" src="images/m42.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="user" class="item-overlay active opacity wrapper-md font-xs text-right">
                          <span class="block h3 font-bold text-white text-u-c">2018</span>
                          <span class="text-muted">发现, 聆听,分享</span>
                          <span class="bottom wrapper-md block"><i class="icon-arrow-right i-lg pull-left"></i> -</span>
                        </a>
                        <a href="user">
                          <img class="img-full" src="images/m44.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="user" class="item-overlay active opacity wrapper-md font-xs">
                          <span class="block h3 font-bold text-danger-lter text-u-c">Top10</span>
                          <span class="text-muted">精选歌曲</span>
                          <span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>
                        </a>
                        <a href="user">
                          <img class="img-full" src="images/m45.jpg" alt="...">
                        </a>
                      </div>
                    </div>
                  </section>
                </section>
              </section>
            </section>
          </section>
          
          
          <footer class="footer bg-dark">
								<div id="jp_container_N">
									<div class="jp-type-playlist">
										<div id="jplayer_N" class="jp-jplayer hide"></div>
										<div class="jp-gui">
											<div class="jp-interface">
												<div class="jp-controls">
													<!-- audio中如果出现controls属性则说明会弹出界面框 -->
													<audio id="audio" ontimeupdate="updateTime(this);" >
           											</audio>
													<!-- 上一首  -->
													<div>
														<a id="backward" class="jp-previous"><i
															class="icon-control-rewind i-lg"></i></a>
													</div>
													<!-- 播放或暂停  -->
													<div >
														<a id="play" onclick="change();"><i class="icon-control-play i-2x"></i></a>
													</div>
													<!-- 下一首  -->
													<div>
														<a id="forward" class="jp-next"><i
															class="icon-control-forward i-lg"></i></a>
													</div>
													<!-- 显示播放列表  -->
													<div>
														<a id="showlist" data-toggle="dropdown" data-target="#playlist"><i
															class="icon-list"></i></a>
													</div>
													<div class="jp-progress hidden-xs">
														<div class="jp-seek-bar dk">
															<div class="jp-play-bar bg-info"></div>
															<!-- 正在播放的歌曲名 -->
															<div id="currentM" style="position:absolute;bottom:15px;left:350px">
																	<strong id="rmusic"></strong>
															</div>
														</div>
													</div>
													<!-- 播放的时长  -->
													<div
														class="hidden-xs hidden-sm text-xs text-muted">
														<span id="nowTime"></span>
													</div>
													<!-- 歌曲的时长  -->
													<div
														class="hidden-xs hidden-sm text-xs text-muted">
														<span id="stime"></span>
													</div>
													<!-- 静音图标 -->
													<div class="hidden-xs hidden-sm">
														<a id="mute" class="jp-mute" title="mute"><i
															class="icon-volume-2"></i></a> <a id="unmute" class="jp-unmute hid"
															title="unmute"><i class="icon-volume-off"></i></a>
													</div>
													<!-- 音量条 -->
													<div class="hidden-xs hidden-sm jp-volume">
														<div class="jp-volume-bar dk">
															<div id="volume" onchange="setVolume()" class="jp-volume-bar-value lter"></div>
														</div>
													</div>
													<!-- 随机播放 -->
													<div>
														<a id="randoms" class="jp-shuffle" title="shuffle"><i
															class="icon-shuffle text-muted"></i></a> <a
															class="jp-shuffle-off hid" title="shuffle off"><i
															class="icon-shuffle text-lt"></i></a>
													</div>
													<!-- 循环播放 -->
													<div>
														<a id="sequence" class="jp-repeat" title="repeat"><i
															class="icon-loop text-muted"></i></a> <a
															class="jp-repeat-off hid" title="repeat off"><i
															class="icon-loop text-lt"></i></a>
													</div>
												</div>
											</div>
										</div>
										<!-- 歌曲播放列表 -->
										<div class="jp-playlist dropup" id="playlist">
											<ul id="songlist" class="dropdown-menu aside-xl dker">
												
											</ul>
										</div>
									</div>
								</div>
							</footer>
							
							
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
		
		//删除播放歌单
		 function rSong(a){
			//删除该节点
			 var li = $(a).parent().parent();
			 li.remove();
		 }
	</script>
</body>
</html>