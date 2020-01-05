<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html>
<html >
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">    
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <title>歌曲列表页</title>  
  </head>
   <body>  	
  	<div class="container">
  	  <div class="panel panel-default">
  	  	 <div class="panel-heading text-center">
  	  	    <h2>歌曲列表页</h2>
  	  	 </div>
  	  	  <div class="panel-body">
  	  	   <a class="btn btn-info" href="jsp/add.jsp">添加歌曲</a> 
  	  	     <table class="table table-hover table-striped">
  	  	     	<thead>
  	  	     		<tr>
  	  	     			<th>编号</th>
  	  	     			<th>歌名</th>
  	  	     			<th>歌手</th>
  	  	     			<th>语种</th> 
  	  	     			<th>操作</th> 
  	  	     		</tr>
  	  	     	</thead>
  	  	     	<tbody>	  	     	
  	  	     	  <c:forEach items="${pagebean.data}" var="song">
  	     			<tr>
  	     			<td>${song.s_id }</td>
  	     			<td>${song.s_name }</td>
  	     			<td>${song.s_singername }</td>
  	     			<td>${song.s_languageType}</td>
  	     			<td>
  	     			    <a class="btn btn-danger" href="user?method=doDeleteSong&s_id=${song.s_id}&page=${pagebean.currPage}">删除</a>
  	     				
  	     				<a onclick="updatefm(this)" class="btn btn-info" href="#" data-toggle="modal" data-target="#updateModal" >
  	     				修改
  	     				</a>
  	     				
		            </td>
  	     			</tr>
  	     			
  	     		  </c:forEach>	 	  	     		 
  	  	     	</tbody>
  	  	     </table>
  	  	 </div>
  	  </div>
  	  
  	  
  	  <!-- 分页  -->
  	  <nav aria-label="Page navigation">
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:forEach begin="${pagebean.beginNum }" end="${pagebean.endNum }" varStatus="i">
		       <c:choose>
		          <c:when test="${pagebean.currPage == i.index}">
		              <li class='active'><a href="#">${i.index}</a></li>
		          </c:when>
		          <c:otherwise>
		              <li><a href="user?method=doShowSong&page=${i.index}">${i.index}</a></li>
		          </c:otherwise>
		       </c:choose>	       
		    </c:forEach>
		    
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>	 
  	</div>
  	
  		
<!-- 修改模态框 -->
<div class="modal fade" id="updateModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">请输入要修改的内容</h4>
      </div>
      <div class="modal-body">
                   
        <!-- 表单开始 -->
  	  	    <form name="subform" class="form-horizontal" action="user?method=doUpdateSong&page=${pagebean.currPage}" method="post">
			  <div class="form-group">
			    <label for="inputS_name" class="col-sm-2 control-label">歌名</label>
			    <div class="col-sm-10">
			    <input id="s_id" type="hidden" name="s_id" value="">
			      <input name="s_name" type="text" class="form-control" id="s_name" placeholder="请输入歌名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputS_singername" class="col-sm-2 control-label">歌手</label>
			    <div class="col-sm-10">
			      <input name="s_singername" type="text" class="form-control" id="s_singername" placeholder="请输入歌手">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">语种</label>
			    <div class="col-sm-10">       
         			  <input type="checkbox" name="spoken" value="国语"> 国语 
         			  <input type="checkbox" name="spoken" value="粤语"> 粤语
         			  <input type="checkbox" name="spoken" value="韩语"> 韩语 
         			  <input type="checkbox" name="spoken" value="日语"> 日语
         			  <input type="checkbox" name="spoken" value="欧美"> 欧美
			    </div>
			     </div>
			  
			 		  
			  <div class="modal-footer">
			    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>          
                <a onclick="subform.submit()" class="btn btn-success" >保存</a>            
              </div>	
              	  
			</form>
            
      </div>   
    </div>
  </div>
</div>	 	
</body>
  <script>
  function delcfm(wid){
	  $("#delcfmModel").modal();  	  
  }
  
  function updatefm(a){
	  var tds=$(a).parent().siblings();
	  
	  var s_id=$(tds[0]).html();
	  var s_name=$(tds[1]).html();
	  var s_singername=$(tds[2]).html();
	  $("#s_id").val(s_id);
	  $("#s_name").val(s_name);
	  $("#s_singername").val(s_singername);
	  
	  $("#updateModel").modal();
  }
  
  </script>
</html>