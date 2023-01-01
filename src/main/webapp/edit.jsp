<%@page import="com.util.DbConnect"%>
<%@page import="com.entity.Entity"%>
<%@page import="com.Dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Todo || TODO</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="component/navbar.jsp"%>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Add Todo</h3>

						<%
						int id = Integer.parseInt(request.getParameter("id"));

						TodoDao dao = new TodoDao(DbConnect.getConnection());
						Entity e = dao.getEntityById(id);
						%>


						<form action="update" method="post">

							<input type="hidden" value="<%=e.getId()%>" name="id">

							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="username"
									value="<%=e.getName()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">TODO</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="todo"
									value="<%=e.getTodo()%>">
							</div>

							<div class="form-group ">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">

									<%
									if ("Pending".equals(e.getStatus())) {
									%>
									<option value="Pending">Pending</option>
									<option value="Complete">Complete</option>
									<%
									} else {
									%>
									<option value="Complete">Complete</option>
									<option value="Pending">Pending</option>
									<%
									}
									%>
								</select>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>