package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wuyi.entity.Template;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.TemplateService;
import org.wuyi.service.WorkFlowService;


/**
 * 模板附件下载
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class TemplateForInputController {

	@Autowired
	private TemplateService templateService;
	@Autowired
	private WorkFlowService workFlowService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("templateForInputList")
	@RequireLogin
	public String list(@RequestParam(value="id", required=true) String id,
			Model model) {
		
		List<Template> templates = templateService.listByWf(id);
		WorkFlow wf = workFlowService.getEntity(id);
		
		model.addAttribute("templates", templates);
		model.addAttribute("wf", wf);
		
		return "forms/templateForInputList";
	}
	
}
