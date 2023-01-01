<%@page import="com.Dao.TodoDao"%>
<%@page import="com.entity.Entity"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>HOME || TODO</title>
<%@include file="component/all_css.jsp"%>
</head>

<body>
	<%@include file="component/navbar.jsp"%>


	<h1 class="text-center text-success">TODO-APP</h1>

	<%
	String sucMsg = (String) session.getAttribute("sucMsg");
	if (sucMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=sucMsg%></div>
	<%
	session.removeAttribute("sucMsg");
	}
	%>

	<%
	String failedMsg = (String) session.getAttribute("failedMsg");
	if (failedMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=failedMsg%></div>
	<%
	session.removeAttribute("failedMsg");
	}
	%>

	<div class="container">

		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">TODO</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				TodoDao dao = new TodoDao(DbConnect.getConnection());
				List<Entity> entity = dao.getTodo();
				for (Entity e : entity) {
				%>
				<tr>
					<th scope="row"><%=e.getId()%></th>
					<th scope="col"><%=e.getName()%></th>
					<td><%=e.getTodo()%></td>
					<td><%=e.getStatus()%></td>
					<td>
					<a href="edit.jsp?id=<%=e.getId() %>" class="btn btn-sm btn-success">Edit</a> 
					<a href="delete?id=<%=e.getId() %>" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>