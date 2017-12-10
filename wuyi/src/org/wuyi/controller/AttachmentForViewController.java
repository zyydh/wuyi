package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wuyi.entity.Attachment;
import org.wuyi.entity.WorkFlow;
import org.wuyi.entity.WorkFlowItem;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.AttachmentService;
import org.wuyi.service.WorkFlowItemService;
import org.wuyi.service.WorkFlowService;


/**
 * 模板附件下载
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class AttachmentForViewController {

	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private WorkFlowItemService workFlowItemService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("attachmentForViewList")
	@RequireLogin
	public String list(@RequestParam(value="id", required=true) Integer id,
			@RequestParam(value="back", required=true) String back,
			Model model) {
		
		List<Attachment> attachments = attachmentService.listByItem(id);
		WorkFlowItem item = workFlowItemService.getEntity(id);
		
		model.addAttribute("attachments", attachments);
		model.addAttribute("wf", item.getWorkFlow());
		model.addAttribute("back", back);
		
		return "forms/attachmentForViewList";
	}
	
}
