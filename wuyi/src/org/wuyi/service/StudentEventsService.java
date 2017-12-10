package org.wuyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuyi.dao.StudentEventsDao;
import org.wuyi.dao.TemplateDao;
import org.wuyi.entity.Student;
import org.wuyi.entity.StudentEvents;
import org.wuyi.entity.User;

@Service
public class StudentEventsService extends BaseService<StudentEvents> {

	@Autowired
	StudentEventsDao studentEventsDao;
	
	public List<StudentEvents> listByUser(User user) {
		return studentEventsDao.listByUser(user);
	}
}
