package com.itask.service;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itask.dao.DAOFactory;
import com.itask.dao.IBaseDAO;
import com.itask.dom.Task;

@EnableAutoConfiguration // 启用自动配置
@RestController
@RequestMapping("/service/task")
public class TaskController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Task> findAll() {
		IBaseDAO<Task> dao;
		List<Task> list = null;
		try {
			System.out.println("FindAll Start!!!");
			dao = DAOFactory.getITaskDAOInstance();
			list = dao.findAll();
			System.out.println("FindAll Success!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@RequestMapping(
			method = RequestMethod.POST)
	public void add(@RequestBody Task task) {
//		Task task = new Task();
		try {
			System.out.println("Add Start!!!");
			IBaseDAO<Task> dao = DAOFactory.getITaskDAOInstance();
			dao.save(task);
			System.out.println("Add Success!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
