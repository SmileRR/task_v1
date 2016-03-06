package com.itask.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Qingran
 *
 * @param <T>
 */
public interface IBaseDAO<T> {
	
	/**
	 * @param entity
	 */
	public boolean saveAll(List<T> list) throws Exception;
	
	/**
	 * @param entity
	 */
	public boolean save(T entity) throws Exception;
	/**
	 * @param entity
	 */
	public boolean update(T entity) throws Exception;
	/**
	 * @param entity
	 */
	public boolean merge(T entity) throws Exception;
	/**
	 * @param id
	 */
	public boolean delete(Integer id) throws Exception;
	
	/**
	 * @param id
	 * @return
	 */
	public T findById(Integer id) throws Exception;
	
	/**
	 * @return
	 */
	public List<T> findAll() throws Exception;
	
}
