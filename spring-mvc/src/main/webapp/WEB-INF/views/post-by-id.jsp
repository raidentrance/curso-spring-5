<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post by id</title>
</head>
<body>
	<h1>Post by id</h1>
	<c:if test="${error!=null}">
		<c:out value="${error}"></c:out>
	</c:if>
	<table>
		<tr>
			<td>Id</td>
			<td>${post.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${post.name}</td>
		</tr>
		<tr>
			<td>Content</td>
			<td>${post.content}</td>
		</tr>
		<tr>
			<td>Author</td>
			<td>${post.author}</td>
		</tr>

	</table>
</body>
</html>