package com.itask.dao;

import java.util.List;

import com.itask.dom.Task;

public class TaskDAOProxy<T> implements IBaseDAO<T> {

	private DatabaseConnection dbc;
	private IBaseDAO dao = null;

	public TaskDAOProxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new TaskDAOImp(dbc.getConnection());
	}

	@Override
	public boolean save(T entity) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Task t = (Task)entity;
		if (dao.findById(t.getSeq()) == null) {
			flag = dao.save(t);
		}
		dbc.close();
		return flag;
	}

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public boolean merge(T entity) throws Exception{
		// TODO Auto-generated method stub
		return dao.merge(entity);
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public T findById(Integer id) throws Exception{
		// TODO Auto-generated method stub
		return (T) dao.findById(id);
	}

	@Override
	public boolean saveAll(List<T> list) throws Exception {
		// TODO Auto-generated method stub
		return dao.saveAll(list);
	}

}
