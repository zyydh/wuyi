package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.WorkFlowService;


/**
 * 表单管理
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class WorkFlowController {

	@Autowired
	private WorkFlowService workFlowService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("workFlowList")
	@RequireLogin
	public String list() {
		return "system/workFlowList";
	}
	
	@RequestMapping("workFlowAdd")
	@RequireLogin
	public String add(Model model) {
		return "system/workFlowAdd";
	}
	
	@RequestMapping("workFlowEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) String id, Model model) {
		
		WorkFlow wf = workFlowService.getEntity(id);
		
		model.addAttribute("wf", wf);
		return "system/workFlowEdit";
	}
	
	@RequestMapping("allWorkFlow")
	@RequireLogin
	@ResponseBody
	public List<WorkFlow> all(){
		List<WorkFlow> workFlowList = workFlowService.selectAll();
		return workFlowList;
	}
	
	@RequestMapping("manageWorkFlow")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) String id,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="entityName", required=false) String entityName,
			@RequestParam(value="addUrl", required=false) String addUrl,
			@RequestParam(value="updateUrl", required=false) String updateUrl,
			@RequestParam(value="detailUrl", required=false) String detailUrl,
			@RequestParam(value="approver", required=false) String approver,
			@RequestParam(value="reviewer", required=false) String reviewer,
			@RequestParam(value="oper", required=true) String oper) {
		
		WorkFlow wf = new WorkFlow();
		wf.setId(id);
		wf.setName(name);
		wf.setEntityName(entityName);
		wf.setAddUrl(addUrl);
		wf.setUpdateUrl(updateUrl);
		wf.setDetailUrl(detailUrl);
		wf.setApprover(approver);
		wf.setReviewer(reviewer);
		
		if ("add".equals(oper)) {
			try {
				workFlowService.add(wf);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				workFlowService.update(wf);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("del".equals(oper)) {
			try {
				workFlowService.delete(wf);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
