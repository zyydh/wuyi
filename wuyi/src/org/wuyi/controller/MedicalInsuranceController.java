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
import org.wuyi.entity.Classes;
import org.wuyi.entity.MedicalInsurance;
import org.wuyi.entity.Student;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.ClassesService;
import org.wuyi.service.LoginService;
import org.wuyi.service.MedicalInsuranceService;
import org.wuyi.service.WorkFlowService;


/**
 * 参保
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class MedicalInsuranceController {

	@Autowired
	private MedicalInsuranceService medicalInsuranceService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("medicalInsuranceAdd")
	@RequireLogin
	public String add(@RequestParam(value="wfId", required=false) String wfId, Model model, HttpSession session) {
		User user = loginService.getLoginedUser(session);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", user);
		model.addAttribute("wfId", wfId);
		return "forms/medicalInsuranceAdd";
	}
	
	@RequestMapping("medicalInsuranceEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) Integer id, Model model) {
		
		MedicalInsurance item = medicalInsuranceService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		return "forms/medicalInsuranceEdit";
	}
	
	@RequestMapping("medicalInsuranceDetail")
	@RequireLogin
	public String detail(@RequestParam(value="id", required=true) Integer id, @RequestParam(value="back", required=true) String back, Model model) {
		
		MedicalInsurance item = medicalInsuranceService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		model.addAttribute("back", back);
		return "forms/medicalInsuranceDetail";
	}
	
	@RequestMapping("manageMedicalInsurance")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="startDate", required=false) String startDate,
			@RequestParam(value="oper", required=true) String oper,
			HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		
		if ("add".equals(oper)) {
			try {
				Student student = (Student)user;
				WorkFlow wf = workFlowService.getEntity("YBCB");
				MedicalInsurance item = new MedicalInsurance();
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
				medicalInsuranceService.add(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				Student student = (Student)user;
				MedicalInsurance item = medicalInsuranceService.getEntity(id);
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
				medicalInsuranceService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
