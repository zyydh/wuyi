package org.wuyi.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuyi.dao.BaseDao;

@Service  
@Transactional
public abstract class BaseService <E extends Serializable> {

	@Autowired  
	protected BaseDao<E> dao;
	
	public E getEntity(Object key) {
		return dao.getEntity(key);
	}
	
	public List<E> selectAll() {
		return dao.selectAll();
	}
	
	public boolean add(E entity) {
		dao.add(entity);
		return true;
	}
	
	public boolean update(E entity) {
		dao.update(entity);
		return true;
	}
	
	public boolean delete(E entity) {
		dao.delete(entity);
		return true;
	}

}
