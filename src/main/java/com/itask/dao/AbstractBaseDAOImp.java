package com.itask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public abstract class AbstractBaseDAOImp<T> implements IBaseDAO<T> {
//	private Class<T> clazz;
//	
//	@SuppressWarnings("unchecked")
//	public AbstractBaseDAOImp(){
//		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
//		this.clazz = (Class<T>)type.getActualTypeArguments()[0];
//	}
	
	private Connection con;  
    private PreparedStatement stat = null;  
    public  AbstractBaseDAOImp(Connection con){  
        this.con = con;  
    }  
    
    public List<T> findAll(){
		return null;
    	
    }
}
