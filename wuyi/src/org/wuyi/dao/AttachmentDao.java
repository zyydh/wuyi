package org.wuyi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.wuyi.entity.Attachment;
import org.wuyi.entity.Teacher;
import org.wuyi.entity.Template;
import org.wuyi.entity.WorkFlow;

@Repository
public class AttachmentDao extends BaseDao<Attachment> {

	private static final long serialVersionUID = -5221124273187676467L;

	@PersistenceContext
	private EntityManager em;
	
	public List<Attachment> listByItem(Integer id) {
		return em.createQuery("from Attachment where workFlowItem.id=?").setParameter(1, id).getResultList();
	}
	
}
