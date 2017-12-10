package org.wuyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuyi.dao.TemplateDao;
import org.wuyi.entity.Template;

@Service
public class TemplateService extends BaseService<Template> {

	@Autowired
	TemplateDao templateDao;
	
	public List<Template> listByWf(String wfId) {
		return templateDao.listByWf(wfId);
	}
}
