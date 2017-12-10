package org.wuyi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.wuyi.entity.Teacher;
import org.wuyi.entity.Template;
import org.wuyi.entity.WorkFlow;

@Repository
public class TemplateDao extends BaseDao<Template> {

	private static final long serialVersionUID = -5221124273187676467L;

	@PersistenceContext
	private EntityManager em;
	
	public List<Template> listByWf(String wfId) {
		return em.createQuery("from Template where workFlow.id=?").setParameter(1, wfId).getResultList();
	}
	
}
