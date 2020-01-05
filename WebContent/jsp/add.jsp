<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">    
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <title>歌曲增加页</title>  
  </head>
  <body>  	
  	<div class="container">
  	  <div class="panel panel-default">
  	  	 <div class="panel-heading text-center">
  	  	    <h2>歌曲增加页</h2>
  	  	    
  	  	 </div>
  	  	  <div class="panel-body">
  	  	    <div id="addmess" class="alert text-center hide" role="alert">
			</div>
  	  	    <!-- 表单开始 -->
  	  	    <form class="form-horizontal" action="user?method=doAddSong" method="post">
			  <div class="form-group">
			    <label for="inputS_name" class="col-sm-2 control-label">歌名</label>
			    <div class="col-sm-10">
			      <input name="s_name" type="text" class="form-control" id="inputS_name" placeholder="请输入歌名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputS_singername" class="col-sm-2 control-label">歌手</label>
			    <div class="col-sm-10">
			      <input name="s_singername" type="text" class="form-control" id="inputS_singername" placeholder="请输入歌手">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">语种</label>
			    <div class="col-sm-10">       
         			  <input type="checkbox" name="spoken" value="国语"> 国语 
         			  <input type="checkbox" name="spoken" value="粤语"> 粤语 
         			  <input type="checkbox" name="spoken" value="日语"> 日语
         			  <input type="checkbox" name="spoken" value="韩语"> 韩语 
         			  <input type="checkbox" name="spoken" value="欧美"> 欧美  
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-primary">增加歌曲</button>
			    </div>
			  </div>
			</form>

  	  	 </div>
  	  </div>
  	 
  	</div>
  </body>
  <script>
   $(function(){
	   $("#addmess").removeClass("hide");
	   var show= -1;
	   <%
	   	  Integer n =(Integer)request.getAttribute("n");
	   	  if(n==null){
	   		  out.println("show=-1;");
	   	  }else if(n== 0){
	   		  out.println("show=0;");
	   	  }else if(n==1){
	   		  out.println("show=1;");
	   	  }
	   %>
    
	   if(show==1){
		   $("#addmess").addClass("alert-success");
		   $("#addmess").html("<strong>增加成功</trong>");
		   $("#addmess").show();   
	   }else if(show==0){
		   $("#addmess").addClass("alert-danger");
		   $("#addmess").html("<strong>增加失败</trong>");
		   $("#addmess").show();
	   }else{
		   //不做事
	   }
	   
	   setTimeout(function(){
		   $("#addmess").hide(400);   
	   },2000);
	   
   });
  </script>
</html>