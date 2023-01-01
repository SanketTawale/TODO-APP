package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.TodoDao;
import com.entity.Entity;
import com.util.DbConnect;

@WebServlet("/update")
public class UpdateServlate extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status=req.getParameter("status");
		
		TodoDao dao=new TodoDao(DbConnect.getConnection());
		
		Entity e=new Entity();
		e.setId(id);
		e.setName(username);
		e.setTodo(todo);
		e.setStatus(status);
		
		boolean f=dao.updateTodo(e);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("sucMsg", "Todo Updated Successfully");
			resp.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("failedMsg", "Something wrong on servlet");
			resp.sendRedirect("index.jsp");
		}
		
	}
	
	

}
