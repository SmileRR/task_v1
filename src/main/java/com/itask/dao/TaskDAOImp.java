package com.itask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itask.dom.Task;

public class TaskDAOImp<T> implements IBaseDAO<T> {

	private Connection con;
	private PreparedStatement stat = null;

	public TaskDAOImp(Connection con) {
		this.con = con;
	}

	@Override
	public boolean save(T entity) throws Exception {
		// TODO Auto-generated method stub
		Task t = (Task) entity;

		stat = con.prepareStatement("INSERT INTO APP.TASK(ID,TITLE,DESCRIPTION, DURATION,START_DT,END_DT,OWNER) "
				+ "VALUES(?,?,?,?,current_timestamp,current_timestamp,?)");
		stat.setInt(1, t.getSeq());
		stat.setString(2, t.getTitle());
		stat.setString(3, t.getDescription());
		stat.setInt(4, t.getDuration());
//		stat.setString(5, t.getStartDate().toString());
//		stat.setString(6, t.getEndDate().toString());
		stat.setString(5, t.getOwner());
		int n = stat.executeUpdate();
		System.out.println("update count:"+n);
		return true;
	}
	
	@Override
	public boolean saveAll(List<T> list) throws Exception {
		// TODO Auto-generated method stub
		stat = con.prepareStatement("INSERT INTO APP.TASK(ID,TITLE,DESCRIPTION, DURATION,START_DT,END_DT,OWNER) "
				+ "VALUES(?,?,?,?,current_timestamp,current_timestamp,?)");
		stat.addBatch("DELETE FROM APP.TASK");
		
		for(Task t : (List<Task>)list){
			stat.setInt(1, t.getSeq());
			stat.setString(2, t.getTitle());
			stat.setString(3, t.getDescription());
			stat.setInt(4, t.getDuration());
//			stat.setString(5, t.getStartDate().toString());
//			stat.setString(6, t.getEndDate().toString());
			stat.setString(5, t.getOwner());
			stat.addBatch();
		}
		int[] n = stat.executeBatch();
		System.out.println("update count:"+n);
		return true;
	}
	
	@Override
	public boolean update(T entity) throws Exception {
		// TODO Auto-generated method stub
		// Task t = (Task)entity;
		// stat = con.prepareStatement("INSERT INTO TASK(ID,TITLE,DESCRIPTION,
		// DURATION,START_DT,END_DT,OWNER) "
		// + "VALUES(?,?,?,?,?,?,?)");
		return false;
	}

	@Override
	public boolean merge(T entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		stat = con.prepareStatement("DELETE FROM APP.TASK WHERE ID=?");
		stat.setInt(1, id);
		return false;
	}

	@Override
	public T findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Task t =null;
		stat = con.prepareStatement(
				"SELECT ID,TITLE,DESCRIPTION, DURATION,START_DT,END_DT,OWNER FROM APP.TASK WHERE ID=? ");
		stat.setInt(1, id);
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			t=new Task();
			t.setSeq(id);
			t.setTitle(rs.getString("TITLE"));
			t.setDescription(rs.getString("DESCRIPTION"));
			t.setDuration(t.getDuration());
			t.setStartDate(rs.getDate("START_DT"));
			t.setEndDate(rs.getDate("END_DT"));
			t.setOwner(rs.getString("OWNER"));
		}

		return (T) t;
	}

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Task t;
		List<Task> list = new ArrayList<Task>();

		stat = con.prepareStatement("SELECT ID,TITLE,DESCRIPTION, DURATION,START_DT,END_DT,OWNER FROM APP.TASK ");
		ResultSet rs = stat.executeQuery();
		while (rs.next()) {
			t = new Task();
			t.setSeq(rs.getInt("ID"));
			t.setTitle(rs.getString("TITLE"));
			t.setDescription(rs.getString("DESCRIPTION"));
			t.setDuration(t.getDuration());
			t.setStartDate(rs.getDate("START_DT"));
			t.setEndDate(rs.getDate("END_DT"));
			t.setOwner(rs.getString("OWNER"));
			list.add(t);
		}
		return (List<T>) list;
	}

}
