<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<section class="w-f-md scrollable">
	<div class="slim-scroll" data-height="auto"
		data-disable-fade-out="true" data-distance="0" data-size="10px"
		data-railOpacity="0.2">
		<!-- nav -->
		<nav class="nav-primary hidden-xs">
			<ul class="nav bg clearfix">
				<li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
					Discover</li>
				<li><a href="user"> <i
						class="icon-disc icon text-success"></i> <span class="font-bold">推荐</span>
				</a></li>
				<li><a href="song?method=doShowSongType"> <i
						class="icon-music-tone-alt icon text-info"></i> <span
						class="font-bold">歌曲</span>
				</a></li>
				<li><a href="songlist?method=doShowTopSongList"> <i
						class="icon-drawer icon text-primary-lter"></i> <b
						class="badge bg-primary pull-right"></b> <span class="font-bold">歌单</span>
				</a></li>
				<li><a href="cd?method=doShowNewCDS" > <i
						class="icon-list icon  text-info-dker "></i> <span
						class="font-bold">专辑</span>
				</a></li>
				<li>
					<c:choose>
						<c:when test="${user!=null }">
							<a href="songlist?method=doShowUserSongList&u_id=${user.u_id }"> 
							<i class="icon-music-tone "></i>
							<span class="font-bold">我的听歌</span>
							</a>
						</c:when>
						<c:otherwise>
							<a href="jsp/signin.jsp"> 
							<i class="icon-music-tone "></i>
							<span class="font-bold">我的听歌</span>
							</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${user==null }">
							<a href="jsp/signin.jsp"> 
						</c:when>
						<c:otherwise>
							<a href="user?method=doShowMySonglist"> 
						</c:otherwise>
					</c:choose>
						<i class="icon-user-follow "></i> 
						<span class="font-bold">我的歌单</span>
					</a>
				</li>
			</ul>
		</nav>
		<!-- / nav -->
	</div>
</section>

<footer class="footer hidden-xs no-padder text-center-nav-xs">
					<div class="bg hidden-xs ">
						<!-- 播放歌曲的封面图片  -->
						<div class="dropdown dropup wrapper-sm clearfix">
							<a> <span
								class="thumb-sm avatar pull-left m-l-xs"> <img id="imcover"
									src="resource/s_images/chunxiaqiudong.PNG" class="dker" alt="..."> <i
									class="on b-black"></i>
							</span>
							</a>
						</div>
					</div>
				</footer>
