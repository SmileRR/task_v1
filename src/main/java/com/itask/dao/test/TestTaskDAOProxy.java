package com.itask.dao.test;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.itask.dao.DAOFactory;
import com.itask.dao.IBaseDAO;
import com.itask.dao.TaskDAOProxy;
import com.itask.dom.Task;

public class TestTaskDAOProxy {

	@Test
	public void testTaskDAOProxy() throws Exception {
		TaskDAOProxy<Task> tdao = new TaskDAOProxy<Task>();
//		fail("Not yet implemented");
	}

	@Test
	public void testSave() throws Exception {
		IBaseDAO<Task> tdao = DAOFactory.getITaskDAOInstance();
		Task t = new Task();
		t.setSeq(1);
		t.setTitle("task1");
		t.setDescription("起床");
		t.setDuration(10);
		t.setStartDate(Calendar.getInstance().getTime());
		t.setEndDate(Calendar.getInstance().getTime());
		t.setOwner("Radon");
		tdao.save(t);
//		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() throws Exception {
		testSave();
		IBaseDAO<Task> tdao = DAOFactory.getITaskDAOInstance();
		List<Task> l = tdao.findAll();
		System.out.println("testFindAll");
		for(Task t : l){
			System.out.println(t.getSeq()+":"+t.getDescription());
		}
	}

	@Test
	public void testUpdate() throws Exception {
		IBaseDAO<Task> tdao = DAOFactory.getITaskDAOInstance();
		Task t = new Task();
		t.setSeq(1);
		t.setTitle("task2");
		t.setDescription("吃饭2");
		t.setDuration(10);
		t.setStartDate(Calendar.getInstance().getTime());
		t.setEndDate(Calendar.getInstance().getTime());
		t.setOwner("Radon");
		tdao.update(t);
	}

	@Test
	public void testMerge() {
	}

	@Test
	public void testDelete() throws Exception {
		testSave();
		IBaseDAO<Task> tdao = DAOFactory.getITaskDAOInstance();
		tdao.delete(1);
	}

	@Test
	public void testFindById() throws Exception {
		testSave();		
		IBaseDAO<Task> tdao = DAOFactory.getITaskDAOInstance();
		Task  t = tdao.findById(1);
		System.out.println("testFindById");
		System.out.println(t.getSeq()+":"+t.getDescription()+":"+t.getStartDate());
	}

}
