package org.wuyi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.wuyi.common.CommonUtil;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlowItem;

@Repository
public class WorkFlowItemDao extends BaseDao<WorkFlowItem> {

	private static final long serialVersionUID = -5221124273187676467L;

	@PersistenceContext
	private EntityManager em;
	
	public List<WorkFlowItem> listForInput(String entityName, String maker, String status) {
		
		String hql = "from "+entityName+" where maker.userId=? ";
		if (!CommonUtil.isEmpty(status)) {
			hql += " and status=? ";
		}
		
		Query query = em.createQuery(hql).setParameter(1, maker);
		
		if (!CommonUtil.isEmpty(status)) {
			query.setParameter(2, status);
		}
		
		return query.getResultList();
	}
	
	public List<WorkFlowItem> listForApprove(String entityName, String approver, String status) {
		
		String hql = "from "+entityName+" where status in ('等待审批','已经拒绝', '审批通过') and approver.userId=? ";
		if (!CommonUtil.isEmpty(status)) {
			hql += " and status=? ";
		}
		
		Query query = em.createQuery(hql).setParameter(1, approver);
		
		if (!CommonUtil.isEmpty(status)) {
			query.setParameter(2, status);
		}
		
		return query.getResultList();
	}
	
	public List<WorkFlowItem> listForReview(String entityName, String reviewer, String status) {
		
		String hql = "from "+entityName+" where status in ('等待检查','等待审批','已经拒绝', '审批通过') and reviewer.userId=? ";
		if (!CommonUtil.isEmpty(status)) {
			hql += " and status=? ";
		}
		
		Query query = em.createQuery(hql).setParameter(1, reviewer);
		
		if (!CommonUtil.isEmpty(status)) {
			query.setParameter(2, status);
		}
		
		return query.getResultList();
	}
	
	public List<HashMap<String, Object>> listOfMine(User user) {
		
		String hql = "select status as label,count(*) as data, case when status='正在编辑' then '#68BC31' when status='已经拒绝' then '#2091CF' when status='等待检查' then '#AF4E96' when status='等待审批' then '#DA5430' when status='审批通过' then '#FEE074' end as color from WorkFlowItem where maker.userId=:userId or reviewer.userId=:userId or approver.userId=:userId group by status";
		
		Query query = em.createQuery(hql).setParameter("userId", user.getUserId());
		
		List rows = query.getResultList();
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Object row : rows) {  
	        Object[] cells = (Object[]) row;
	        HashMap<String, Object> tmp = new HashMap<String, Object>();
	        tmp.put("label", cells[0]);
	        tmp.put("data", cells[1]);
	        tmp.put("color", cells[2]);
	        result.add(tmp);
		}
		return result;
	}
}
