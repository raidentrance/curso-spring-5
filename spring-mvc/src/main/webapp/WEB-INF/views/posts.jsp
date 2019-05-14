<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Devs4j</title>
</head>
<body>
	<h1><spring:message code="welcome.title" /></h1>
	<c:if test="${error!=null}">
		<c:out value="${error}"></c:out>
	</c:if>
	<c:out value="Response time ${responseTime}"/>"
	<c:out value="Locale ${pageContext.response.locale}"/>"
	<h3><spring:message code="welcome.create" /></h3>
	<form method="post" >
		Id <input type="text" name="id" />
		Name <input type="text" name="name" />
		Content <input type="text" name="content" />
		Author <input type="text" name="author" />
		<input type="submit" name="create" value="create"/>
	</form>
	
	<h3>Delete</h3>
	<form method="post">
		Name <input type="text" name="name"/>
		<input type="submit" name="delete" value="delete"/>
	</form>
	<h3>List</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Content</th>
			<th>Author</th>
			<th>Link</th>
		</tr>
		<c:forEach items="${posts}" var="post">
			<tr>
				<td>${post.id}</td>
				<td>${post.name}</td>
				<td>${post.content}</td>
				<td>${post.author}</td>
				<td><a href="${contextPath}/posts/${post.id}" >View</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>