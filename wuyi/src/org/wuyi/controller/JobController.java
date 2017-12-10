package org.wuyi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyi.common.CommonUtil;
import org.wuyi.entity.Classes;
import org.wuyi.entity.Job;
import org.wuyi.entity.Student;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.ClassesService;
import org.wuyi.service.JobService;
import org.wuyi.service.LoginService;
import org.wuyi.service.WorkFlowService;


/**
 * 就业情况登记
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class JobController {

	@Autowired
	private JobService jobService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("jobAdd")
	@RequireLogin
	public String add(@RequestParam(value="wfId", required=false) String wfId, Model model, HttpSession session) {
		User user = loginService.getLoginedUser(session);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", user);
		model.addAttribute("wfId", wfId);
		return "forms/jobAdd";
	}
	
	@RequestMapping("jobEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) Integer id, Model model) {
		
		Job item = jobService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		return "forms/jobEdit";
	}
	
	@RequestMapping("jobDetail")
	@RequireLogin
	public String detail(@RequestParam(value="id", required=true) Integer id, @RequestParam(value="back", required=true) String back, Model model) {
		
		Job item = jobService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		model.addAttribute("back", back);
		return "forms/jobDetail";
	}
	
	@RequestMapping("manageJob")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="go", required=false) String go,
			@RequestParam(value="unitCode", required=false) String unitCode,
			@RequestParam(value="unitName", required=false) String unitName,
			@RequestParam(value="unitType", required=false) String unitType,
			@RequestParam(value="unitIndustry", required=false) String unitIndustry,
			@RequestParam(value="unitArea", required=false) String unitArea,
			@RequestParam(value="unitContacts", required=false) String unitContacts,
			@RequestParam(value="unitTel", required=false) String unitTel,
			@RequestParam(value="type", required=false) String type,
			@RequestParam(value="payment", required=false) Integer payment,
			@RequestParam(value="date", required=false) String date,
			@RequestParam(value="reason", required=false) String reason,
			@RequestParam(value="match", required=false) String match,
			@RequestParam(value="hard", required=false) String hard,
			@RequestParam(value="oper", required=true) String oper,
			HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		
		if (payment == null) {
			payment = 0;
		}
		
		if ("add".equals(oper)) {
			try {
				Student student = (Student)user;
				WorkFlow wf = workFlowService.getEntity("XSJY");
				Job item = new Job();
				item.setWorkFlow(wf);
				item.setMaker(student);
				item.setMakeDate(new Date());
				if ("班导师".equals(wf.getReviewer())) {
					item.setReviewer(student.getClasses().getClassMentor());
				} else if ("辅导员".equals(wf.getReviewer())) {
					item.setReviewer(student.getClasses().getInstructor());
				}
				if ("班导师".equals(wf.getApprover())) {
					item.setApprover(student.getClasses().getClassMentor());
				} else if ("辅导员".equals(wf.getApprover())) {
					item.setApprover(student.getClasses().getInstructor());
				}
				item.setStatus("正在编辑");
				
				item.setGo(go);
				item.setUnitCode(unitCode);
				item.setUnitName(unitName);
				item.setUnitType(unitType);
				item.setUnitIndustry(unitIndustry);
				item.setUnitArea(unitArea);
				item.setUnitContacts(unitContacts);
				item.setUnitTel(unitTel);
				item.setType(type);
				item.setPayment(payment);
				if (!CommonUtil.isEmpty(date)) {
					item.setDate(CommonUtil.formatDate(date));
				} else {
					item.setDate(null);
				}
				item.setReason(reason);
				item.setMatch(match);
				item.setHard(hard);
				
				jobService.add(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				Student student = (Student)user;
				Job item = jobService.getEntity(id);
				WorkFlow wf = item.getWorkFlow();
				item.setMaker(student);
				item.setMakeDate(new Date());
				if ("班导师".equals(wf.getReviewer())) {
					item.setReviewer(student.getClasses().getClassMentor());
				} else if ("辅导员".equals(wf.getReviewer())) {
					item.setReviewer(student.getClasses().getInstructor());
				}
				if ("班导师".equals(wf.getApprover())) {
					item.setApprover(student.getClasses().getClassMentor());
				} else if ("辅导员".equals(wf.getApprover())) {
					item.setApprover(student.getClasses().getInstructor());
				}
				item.setStatus("正在编辑");
				
				item.setGo(go);
				item.setUnitCode(unitCode);
				item.setUnitName(unitName);
				item.setUnitType(unitType);
				item.setUnitIndustry(unitIndustry);
				item.setUnitArea(unitArea);
				item.setUnitContacts(unitContacts);
				item.setUnitTel(unitTel);
				item.setType(type);
				item.setPayment(payment);
				if (!CommonUtil.isEmpty(date)) {
					item.setDate(CommonUtil.formatDate(date));
				} else {
					item.setDate(null);
				}
				item.setReason(reason);
				item.setMatch(match);
				item.setHard(hard);
				
				jobService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
