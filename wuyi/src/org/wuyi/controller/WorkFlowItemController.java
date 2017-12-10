package org.wuyi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wuyi.common.CommonUtil;
import org.wuyi.entity.MedicalInsurance;
import org.wuyi.entity.Teacher;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlow;
import org.wuyi.entity.WorkFlowItem;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.LoginService;
import org.wuyi.service.WorkFlowItemService;
import org.wuyi.service.WorkFlowService;


/**
 * 表单流程
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class WorkFlowItemController {

	@Autowired
	private WorkFlowItemService workFlowItemService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("workFlowItemListInput")
	@RequireLogin
	public String listForInput(@RequestParam(value="wfId", required=true) String wfId, Model model) {
		
		WorkFlow wf = workFlowService.getEntity(wfId);
		model.addAttribute("wf", wf);
		return "forms/workFlowItemListInput";
	}
	
	@RequestMapping("workFlowItemListInputData")
	@RequireLogin
	@ResponseBody
	public List<WorkFlowItem> listForInputData(
			@RequestParam(value="wfId", required=true) String wfId,
			@RequestParam(value="status", required=false) String status,
			HttpSession session){
		User user = loginService.getLoginedUser(session);
		WorkFlow wf = workFlowService.getEntity(wfId);
		List<WorkFlowItem> workFlowList = workFlowItemService.listForInput(wf.getEntityName(), user.getUserId(), status);
		return workFlowList;
	}
	
	@RequestMapping("workFlowItemListApprove")
	@RequireLogin
	public String listForApprove(@RequestParam(value="wfId", required=true) String wfId, Model model) {
		
		WorkFlow wf = workFlowService.getEntity(wfId);
		model.addAttribute("wf", wf);
		return "forms/workFlowItemListApprove";
	}
	
	@RequestMapping("workFlowItemListApproveData")
	@RequireLogin
	@ResponseBody
	public List<WorkFlowItem> listForApproveData(
			@RequestParam(value="wfId", required=true) String wfId,
			@RequestParam(value="status", required=false) String status,
			HttpSession session){
		User user = loginService.getLoginedUser(session);
		WorkFlow wf = workFlowService.getEntity(wfId);
		List<WorkFlowItem> workFlowList = workFlowItemService.listForApprove(wf.getEntityName(), user.getUserId(), status);
		return workFlowList;
	}
	
	@RequestMapping("workFlowItemListReview")
	@RequireLogin
	public String listForReview(@RequestParam(value="wfId", required=true) String wfId, Model model) {
		
		WorkFlow wf = workFlowService.getEntity(wfId);
		model.addAttribute("wf", wf);
		return "forms/workFlowItemListReview";
	}
	
	@RequestMapping("workFlowItemListReviewData")
	@RequireLogin
	@ResponseBody
	public List<WorkFlowItem> listForReviewData(
			@RequestParam(value="wfId", required=true) String wfId,
			@RequestParam(value="status", required=false) String status,
			HttpSession session){
		User user = loginService.getLoginedUser(session);
		WorkFlow wf = workFlowService.getEntity(wfId);
		List<WorkFlowItem> workFlowList = workFlowItemService.listForReview(wf.getEntityName(), user.getUserId(), status);
		return workFlowList;
	}
	
	@RequestMapping("workFlowItemAdd")
	@RequireLogin
	public String add(@RequestParam(value="wfId", required=true) String wfId, RedirectAttributes attr) {
		attr.addAttribute("wfId", wfId);
		WorkFlow wf = workFlowService.getEntity(wfId);
		return "redirect:" + wf.getAddUrl();
	}
	
	@RequestMapping("workFlowItemEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) Integer id, RedirectAttributes attr) {
		attr.addAttribute("id", id);
		WorkFlowItem item = workFlowItemService.getEntity(id);
		return "redirect:" + item.getWorkFlow().getUpdateUrl();
	}
	
	@RequestMapping("workFlowItemDetail")
	@RequireLogin
	public String detail(@RequestParam(value="id", required=true) Integer id, @RequestParam(value="back", required=true) String back, RedirectAttributes attr) {
		attr.addAttribute("id", id);
		attr.addAttribute("back", back);
		WorkFlowItem item = workFlowItemService.getEntity(id);
		return "redirect:" + item.getWorkFlow().getDetailUrl();
	}
	
	@RequestMapping("workFlowItemBack")
	@RequireLogin
	public String back(@RequestParam(value="back", required=true) String back, @RequestParam(value="wfId", required=true) String wfId, RedirectAttributes attr) {
		attr.addAttribute("wfId", wfId);
		switch (back) {
			case "input": return "redirect:/workFlowItemListInput";
			case "review": return "redirect:/workFlowItemListReview";
			case "approve": return "redirect:/workFlowItemListApprove";
		}
		return null;
	}
	
	@RequestMapping("manageWorkFlowItem")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="wfId", required=false) String wfId,
			@RequestParam(value="remark", required=false) String remark,
			@RequestParam(value="oper", required=true) String oper,
			HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		WorkFlowItem item = workFlowItemService.getEntity(id);
		
		if ("del".equals(oper)) {
			try {
				if (!"正在编辑".equals(item.getStatus())) {
					return false;
				}
				workFlowItemService.delete(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("submit".equals(oper)) {
			try {
				if (!"正在编辑".equals(item.getStatus())) {
					return false;
				}
				item.setStatus("等待检查");
				item.setApproveDate(null);
				item.setApproveRemark(null);
				item.setRejecter(null);
				item.setRejectDate(null);
				item.setRejectRemark(null);
				item.setReviewDate(null);
				item.setReviewRemark(null);
				workFlowItemService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("review".equals(oper)) {
			try {
				if (!"等待检查".equals(item.getStatus())) {
					return false;
				}
				if ("无".equals(item.getWorkFlow().getApprover())) {
					item.setStatus("审批通过");
				} else {
					item.setStatus("等待审批");
				}
				item.setReviewDate(new Date());
				item.setReviewRemark(remark);
				workFlowItemService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("approve".equals(oper)) {
			try {
				if (!"等待审批".equals(item.getStatus())) {
					return false;
				}
				item.setStatus("审批通过");
				item.setApproveDate(new Date());
				item.setApproveRemark(remark);
				workFlowItemService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("reject".equals(oper)) {
			try {
				if (!"等待检查".equals(item.getStatus()) && !"等待审批".equals(item.getStatus())) {
					return false;
				}
				item.setStatus("已经拒绝");
				item.setRejecter((Teacher) user);
				item.setRejectDate(new Date());
				item.setRejectRemark(remark);
				workFlowItemService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@RequestMapping("myForm")
	@RequireLogin
	@ResponseBody
	public List<HashMap<String, Object>> listOfMine(
			HttpSession session){
		User user = loginService.getLoginedUser(session);
		List<HashMap<String, Object>> workFlowList = workFlowItemService.listOfMine(user);
		return workFlowList;
	}
}
