package com.itask.dao;

import com.itask.dom.Task;

public class DAOFactory {
	public static IBaseDAO<Task> getITaskDAOInstance() throws Exception {
		return new TaskDAOProxy<Task>();
	}
}
