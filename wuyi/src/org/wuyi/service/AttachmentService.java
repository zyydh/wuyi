package org.wuyi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wuyi.dao.AttachmentDao;
import org.wuyi.dao.TemplateDao;
import org.wuyi.entity.Attachment;
import org.wuyi.entity.Template;

@Service
public class AttachmentService extends BaseService<Attachment> {

	@Autowired
	AttachmentDao attachmentDao;
	
	public List<Attachment> listByItem(Integer id) {
		return attachmentDao.listByItem(id);
	}
}
