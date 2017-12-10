package org.wuyi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuyi.dao.WorkFlowItemDao;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlowItem;

@Service
public class WorkFlowItemService extends BaseService<WorkFlowItem> {

	@Autowired
	WorkFlowItemDao workFlowItemDao;
	
	public List<WorkFlowItem> listForInput(String entityName, String maker, String status) {
		return workFlowItemDao.listForInput(entityName, maker, status);
	}
	
	public List<WorkFlowItem> listForApprove(String entityName, String approver, String status) {
		return workFlowItemDao.listForApprove(entityName, approver, status);
	}
	
	public List<WorkFlowItem> listForReview(String entityName, String reviewer, String status) {
		return workFlowItemDao.listForReview(entityName, reviewer, status);
	}
	
	public List<HashMap<String, Object>> listOfMine(User user) {
		return workFlowItemDao.listOfMine(user);
	}
}
