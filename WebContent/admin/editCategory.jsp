<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="../include/admin/adminHeader.jsp" %>
	<%@include file="../include/admin/adminNavigator.jsp" %>
<html>
<head>
<title>修改分类</title>
</head>
<body>
	<div class="workingArea">
		<ol class="breadcrumb">
			<li><a href="admin_category_findAll">所有分类</a></li>
			<li>编辑分类</li>
		</ol>
		<div class="panel panel-warning editDiv">
			<div class="panel-heading">编辑分类</div>
			<div class="panel-body">
				<form action="admin_category_update" method="post" id="editForm" enctype="multipart/form-data">
					<table class="editTable">
						<tr>
							<td>分类名称</td>
							<td>
								<input id="name" type="text" name="category.name" class="form-control" value="${category.name }" >
							</td>
						</tr>
						<tr>
							<td>分类图片</td>
							<td>
								<input id="categoryPic" type="file" name="img" >
							</td>
						</tr>
						<tr class="submitTR">
							<td colspan="2" align="center">
								<input type="hidden" name="category.id" value="${category.id }">
								<button type="submit" class="btn btn-success">提  交</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>