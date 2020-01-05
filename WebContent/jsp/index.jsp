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
<title>主页</title>
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
				<section class="hbox stretch">
					<section>
						<section class="vbox">
							<section class="scrollable padder-lg w-f-md" id="bjax-target">
								<h2 class="font-thin m-b">
									发现专辑<span class="musicbar animate inline m-l-sm"
										style="width:20px;height:20px"> <span
										class="bar1 a1 bg-primary lter"></span> <span
										class="bar2 a2 bg-info lt"></span> <span
										class="bar3 a3 bg-success"></span> <span
										class="bar4 a4 bg-warning dk"></span> <span
										class="bar5 a5 bg-danger dker"></span>
									</span>
								</h2>
								<div class="row row-sm">
									<c:forEach items="${cds }" var="cd">
										<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
											<div class="item">
												<div class="pos-rlt">
													<div class="bottom">
														<span class="badge bg-info m-l-sm m-b-sm">${cd.c_songCount }</span>
													</div>
													<div class="item-overlay opacity r r-2x bg-black">
														<div class="text-info padder m-t-sm text-sm">
															<c:choose>
																<c:when test="${cd.c_collectionCount < 100 }">
																	<i class="fa fa-star"></i>
																</c:when>
																<c:when test="${cd.c_collectionCount < 1000 }">
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																</c:when>
																<c:when test="${cd.c_collectionCount < 10000 }">
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																</c:when>
																<c:when test="${cd.c_collectionCount < 100000 }">
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																</c:when>
																<c:otherwise>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																	<i class="fa fa-star"></i>
																</c:otherwise>
															</c:choose>
															<i class="fa fa-star-o text-muted"></i>
														</div>
														<div class="center text-center m-t-n">
															<a href="cd?method=doShowOneCD&cid=${cd.c_id}"><i class="icon-control-play i-2x"></i></a>
														</div>
														<div class="bottom padder m-b-sm">
															<a href="user" class="pull-right"> <i
																class="fa fa-heart-o"></i>
															</a> <a href="user"> <i class="fa fa-plus-circle"></i>
															</a>
														</div>
													</div>
													<a ><img src="${cd.c_coverUrl }" alt=""
														class="r r-2x img-full"></a>
												</div>
												<div class="padder-v">
													<a href="cd?method=doShowOneCD&cid=${cd.c_id}" class="text-ellipsis">${cd.c_name }</a> <a
														 class="text-ellipsis text-xs text-muted">${cd.c_introduce }</a>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<div class="row">
									<div class="col-md-7">
										<h3 class="font-thin">新歌</h3>
										<div class="row row-sm">
											<c:forEach items="${songs }" var="song" begin="0" end="11">
												<div class=" col-sm-2">
													<div class="item">
														<div class="pos-rlt">
															<div class="item-overlay opacity r r-2x bg-black">
																<div class="center text-center m-t-n">
																	<a onclick="playSong(${song.s_id});"><i class="fa fa-play-circle i-2x"></i></a>
																</div>
															</div>
															<a href="user"><img src="${song.s_coverUrl }" alt=""
																class="r r-2x img-full"></a>
														</div>
														<div class="padder-v">
															<a href="song?method=doShowSongDetail&s_id=${song.s_id }" class="text-ellipsis">${song.s_name }-${song.s_languageType}</a>
															<a href="singer?method=doShowSingerDetail&sg_id=${song.singer.sg_id }" class="text-ellipsis text-xs text-muted">${song.singer.sg_name }</a>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
									<div class="col-md-5">
										<h3 class="font-thin">排行榜</h3>
										<c:forEach items="${orderSongs }" var="orderSong"
											varStatus="id" begin="0" end="4">
											<div class="list-group bg-white list-group-lg no-bg auto">
												<a href="song?method=doShowSongDetail&s_id=${orderSong.s_id }" class="list-group-item clearfix"> <span
													class="pull-right h2 text-muted m-l">${id.index+1}</span> <span
													class="pull-left thumb-sm avatar m-r"> <img
														src="${orderSong.s_coverUrl }" alt="...">
												</span> <span class="clear"> <span>${orderSong.s_name }</span>
														<small class="text-muted clear text-ellipsis">${orderSong.singer.sg_name }</small>
												</span>
												</a>
											</div>
										</c:forEach>
									</div>
								</div>
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
					</section>
					<!-- side content -->
					<aside class="aside-md bg-light dk" id="sidebar">
						<section class="vbox animated fadeInRight">
							<section class="w-f-md scrollable hover">
								<h4 class="font-thin m-l-md m-t">推荐歌单</h4>
								<ul class="list-group no-bg no-borders auto m-t-n-xxs">
									<c:forEach items="${songlists }" var="songlist">
										<li class="list-group-item"><span
											class="pull-left thumb-xs m-t-xs avatar m-l-xs m-r-sm">
												<img src="${songlist.sl_coverUrl }" alt="..."
												class="img-circle"> <i class="on b-light right sm"></i>
										</span>
											<div class="clear">
												<div>
													<a href="songlist?method=doShowSongListDetail&sl_id=${songlist.sl_id }">${songlist.sl_name }</a>
												</div>
												<small class="text-muted">${songlist.sl_introduce }</small>
											</div></li>
									</c:forEach>
								</ul>
							</section>
						</section>
					</aside>
					<!-- / side content -->
				</section>
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
	<script type="text/javascript"
		src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
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
		
	</script>
</body>
</html>