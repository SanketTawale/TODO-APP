package com.Dao;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Entity;

public class TodoDao {

	private Connection connection;

	public TodoDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean addTodo(String name, String todo, String status) {
		boolean f = false;
		try {
			String sql = "insert into todo(name,todo,status) values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, todo);
			ps.setString(3, status);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Entity> getTodo() {
		List<Entity> list = new ArrayList<Entity>();
		Entity e = null;

		try {
			String sql = "select * from todo";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Entity();

				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setTodo(rs.getString(3));
				e.setStatus(rs.getString(4));

				list.add(e);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return list;
	}

	public Entity getEntityById(int id) {
		Entity e = null;

		try {
			String sql = "select * from todo where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				e = new Entity();

				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setTodo(rs.getString(3));
				e.setStatus(rs.getString(4));

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return e;
	}

	public boolean updateTodo(Entity e) {
		boolean f = false;

		try {
			String sql = "update todo set name=?,todo=?,status=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getTodo());
			ps.setString(3, e.getStatus());
			ps.setInt(4, e.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return f;
	}

	public boolean deleteTodo(int id) {
		boolean f = false;
		try {
			String sql = "delete from todo where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
