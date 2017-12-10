package org.wuyi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.wuyi.entity.Attachment;
import org.wuyi.entity.Job;
import org.wuyi.entity.MedicalInsurance;
import org.wuyi.entity.StudentEvents;
import org.wuyi.entity.User;

@Repository
public class StudentEventsDao extends BaseDao<StudentEvents> {

	private static final long serialVersionUID = -5221124273187676467L;

	@PersistenceContext
	private EntityManager em;
	
	public List<StudentEvents> listByUser(User user) {
		String where = " where 1=1 ";
		if ("学生".equals(user.getUserType())) {
			where += " and maker.userId='" + user.getUserId() + "' ";
		}
		return em.createQuery("from StudentEvents " + where + " order by submitTime desc").getResultList();
	}
}
