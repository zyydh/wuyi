package org.wuyi.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wuyi.common.Pagination;

@Repository
@Transactional
public abstract class BaseDao <E extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	protected EntityManager em;
	
	Class<E> entityClass;
	
	protected Logger logger = Logger.getLogger(BaseDao.class);
	
	public BaseDao() {  
		Type genType = getClass().getGenericSuperclass();  
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
		entityClass = (Class) params[0];  
	}  

	public E getEntity(Object key) {
		try
		{
			return em.find(entityClass, key);
		}
		catch(EntityExistsException e)
		{
			logger.error(e.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> selectAll() {
		try
		{
			return em.createQuery("from " + entityClass.getName()).getResultList();
		}
		catch(EntityExistsException e)
		{
			logger.error(e.getMessage());
			return null;
		}
		
	}
	
	public void add(E entity) {
		try
		{
			em.persist(entity);
		}
		catch(EntityExistsException e)
		{
			logger.error(e.getMessage());
		}
	}
	
	public void update(E entity) {
		try
		{
			em.merge(entity);
		}
		catch(EntityExistsException e)
		{
			logger.error(e.getMessage());
		}
	}
	
	public void delete(E entity) {
		try
		{
			em.remove(em.merge(entity));
		}
		catch(EntityExistsException e)
		{
			logger.error(e.getMessage());
		}
	}
	
	public List<E> search(HashMap<String, String> params, Pagination pagination) {
		return null;
	}
}
