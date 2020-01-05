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
  <title>我的歌单</title>
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
	a:hover{
		cursor:pointer;
	}
</style>

</head>
<body class="">

<!-- 模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">创建新歌单</h4>
      </div>
    <form id="doSubmit" action="songlist" method="post">
      <div class="modal-body">
          <div class="form-group">
            <label for="recipient-name" class="control-label">歌单名:</label>
            <!-- 隐藏的表单域 -->
            <input name="method" value="doCreateNewSongList" type="hidden" class="form-control" id="recipient-name">
            <input id="sl_name" name="sl_name" type="text" class="form-control">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">一句话描述歌单：</label>
            <textarea id="sl_introduce" name="sl_introduce" class="form-control"></textarea>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">类型选择：</label><br/>
            <input name="sl_tags" type="radio" value="KTV/伤感/流行" >KTV/伤感/流行<br/>
             <input name="sl_tags" type="radio" value="华语/流行/怀旧" >华语/流行/怀旧<br/>
              <input name="sl_tags" type="radio" value="粤语/摇滚/感动" >粤语/摇滚/感动<br/>
               <input name="sl_tags" type="radio" value="钢琴/轻音乐/古典" >钢琴/轻音乐/古典<br/>
                <input name="sl_tags" type="radio" value="日语/孤独/ACG" >日语/孤独/ACG
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button id="send" type="button" class="btn btn-primary">保存</button>
      </div>
    </form>
    </div>
  </div>
</div>

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
              <h2 class="font-thin m-b">我的歌单</h2>
	             <!-- 提示行弹出提示创建歌单成功或者失败 -->
					<div id="alert" status="${status }" class="alert alert-success hidden" role="alert">
					</div>
              <div class="form-group">
                  <!-- 弹出模态框  -->
					<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  					创建歌单
					</button>
              </div>
              		<c:forEach items="${mysList }" var="songlist">
		                <div class="col-xs-12 col-sm-4">
		                  <div class="item">
		                    <div class="pos-rlt">
		                      <div class="item-overlay opacity r r-2x bg-black">
		                        <div class="center text-center m-t-n">
		                          <a href="songlist?method=doShowSongListDetail&sl_id=${songlist.sl_id }"><i class="fa fa-play-circle i-2x"></i></a>
		                        </div>
		                      </div>
		                      <div class="top">
		                        <span class="badge bg-dark m-l-sm m-t-sm">${songlist.sl_tags }</span>
		                        <div class="dropdown" style="float:right">
								  <button id="dLabel" type="button" class="btn btn-xs btn-info" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   	 管理
								    <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu user_sl" >
								  	<li><a>分享</a></li>
								  	<li slId="${songlist.sl_id }"><a>删除</a></li>
								  </ul>
								</div>
		                      </div>
		                      <a><img src="${songlist.sl_coverUrl }" alt="" class="r r-2x img-full"></a>
		                    </div>
		                    <div class="padder-v">
		                      <a href="songlist?method=doShowSongListDetail&sl_id=${songlist.sl_id }" class="text-ellipsis">${songlist.sl_name }</a>
		                      <a  class="text-ellipsis text-xs text-muted">${songlist.sl_introduce }</a>
		                    </div>
		                  </div>
		                </div>
              		</c:forEach>
              	<div>
              	<div class="row row-sm"></div>
              <h3 class="font-thin m-b">收藏歌单</h3>
              <div class="row row-sm">
               	<c:forEach items="${user.collectionSonglists }" var="cSonglist" varStatus="status">
               		<div class="col-xs-6 col-sm-4 col-md-3">
	                  <div class="item">
	                    <div class="pos-rlt">
	                      <div class="item-overlay opacity r r-2x bg-black">
	                        <div class="center text-center m-t-n">
	                          <a href="songlist?method=doShowSongListDetail&sl_id=${cSonglist.sl_id }"><i class="fa fa-play-circle i-2x"></i></a>
	                        </div>
	                      </div>
	                        <div class="top">
		                        <span class="badge bg-dark m-l-sm m-t-sm">${cSonglist.sl_tags }</span>
		                        <div class="dropdown" style="float:right">
								  <button id="dLabel" type="button" class="btn btn-xs btn-info" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								   	 管理
								    <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu collection_sl">
								  	<li><a>分享</a></li>
								  	<li slId="${cSonglist.sl_id }"><a>删除</a></li>
								  </ul>
								</div>
		                      </div>
	                      <a><img src="${cSonglist.sl_coverUrl }" alt="" class="r r-2x img-full"></a>
	                    </div>
	                    <div class="padder-v">
	                      <a href="songlist?method=doShowSongListDetail&sl_id=${cSonglist.sl_id }" class="text-ellipsis">${cSonglist.sl_introduce }</a>
	                      <a class="text-ellipsis text-xs text-muted">${cSonglist.sl_name }</a>
	                    </div>
	                  </div>
	                </div>  
               	</c:forEach>
              </div>
              <ul class="pagination pagination">
                <li><a href="jsp/my-songlist.jsp"><i class="fa fa-chevron-left"></i></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="jsp/my-songlist.jsp">2</a></li>
                <li><a href="jsp/my-songlist.jsp">3</a></li>
                <li><a href="jsp/my-songlist.jsp">4</a></li>
                <li><a href="jsp/my-songlist.jsp">5</a></li>
                <li><a href="jsp/my-songlist.jsp"><i class="fa fa-chevron-right"></i></a></li>
              </ul>
            </section>
          </section>
          <a href="jsp/my-songlist.jsp" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
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
	$(function(){
			/* 提交按钮点击事件 */
			$("#send").click(function(){
				var sl_name = $("#sl_name").val();
				var sl_introduce = $("#sl_introduce").val();
				if(sl_name!="" && sl_introduce!=""){
					$("#doSubmit").submit();
					$("#myModal").modal("hide");
				}
			});
			
			/* 提示框 */
			var alertBox = $("#alert");
			var status = alertBox.attr("status");
			if (status == 1) {
				alertBox.addClass("alert-warning");
				alertBox.removeClass("hidden");
				alertBox.html("<b>创建失败</b>");
				alertBox.hide(3000);
			} else if (status == 2) {
				alertBox.addClass("alert-success");
				alertBox.removeClass("hidden");
				alertBox.html("<b>创建成功</b>");
				alertBox.hide(3000);
			};
			
		//取消传播时间
		$(".user_sl").on("click","li",function(e){
			//取消传播时间
			e.stopPropagation();
			//获取父节点
			var parent = $(this).parent().parent().parent().parent().parent().parent();
			//异步发送请求到后台处理删除
			var sl_id = $(this).attr("slId");
			$.get("songlist",{method:"doDeleteUserSonglist",sl_id:sl_id},function(data){
				console.log(data);
				if(data == "0"){
					
				}else if(data == "1"){
					parent.remove();
				}
			});
		});
		
		//取消传播时间
		$(".collection_sl").on("click","li",function(e){
			//取消传播时间
			e.stopPropagation();
			//获取父节点
			var parent = $(this).parent().parent().parent().parent().parent().parent();
			//异步发送请求到后台处理删除
			var sl_id = $(this).attr("slId");
			$.get("songlist",{method:"doDeleteCollectionSonglist",sl_id:sl_id,},function(data){
				console.log(data);
				if(data == "0"){
					
				}else if(data == "1"){
					parent.remove();
				}
			});
		});
		
	});
	</script>
</body>
</html>
