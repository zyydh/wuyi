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
import org.wuyi.entity.LoanHbl;
import org.wuyi.entity.Student;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.ClassesService;
import org.wuyi.service.LoanHblService;
import org.wuyi.service.LoginService;
import org.wuyi.service.WorkFlowService;


/**
 * 黄炳礼助学金
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class LoanHblController {

	@Autowired
	private LoanHblService loanHblService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("loanHblAdd")
	@RequireLogin
	public String add(@RequestParam(value="wfId", required=false) String wfId, Model model, HttpSession session) {
		User user = loginService.getLoginedUser(session);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", user);
		model.addAttribute("wfId", wfId);
		return "forms/loanHblAdd";
	}
	
	@RequestMapping("loanHblEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) Integer id, Model model) {
		
		LoanHbl item = loanHblService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		return "forms/loanHblEdit";
	}
	
	@RequestMapping("loanHblDetail")
	@RequireLogin
	public String detail(@RequestParam(value="id", required=true) Integer id, @RequestParam(value="back", required=true) String back, Model model) {
		
		LoanHbl item = loanHblService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		model.addAttribute("back", back);
		return "forms/loanHblDetail";
	}
	
	@RequestMapping("manageLoanHbl")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="jxj", required=false) String jxj,
			@RequestParam(value="nativeType", required=false) String nativeType,
			@RequestParam(value="addr", required=false) String addr,
			@RequestParam(value="tel", required=false) String tel,
			@RequestParam(value="totalCount", required=false) String totalCount,
			@RequestParam(value="totalIncome", required=false) String totalIncome,
			@RequestParam(value="peopleIncome", required=false) String peopleIncome,
			@RequestParam(value="incomeFrom", required=false) String incomeFrom,
			@RequestParam(value="familyName1", required=false) String familyName1,
			@RequestParam(value="familyAge1", required=false) String familyAge1,
			@RequestParam(value="familyRelate1", required=false) String familyRelate1,
			@RequestParam(value="familyUnit1", required=false) String familyUnit1,
			@RequestParam(value="familyName2", required=false) String familyName2,
			@RequestParam(value="familyAge2", required=false) String familyAge2,
			@RequestParam(value="familyRelate2", required=false) String familyRelate2,
			@RequestParam(value="familyUnit2", required=false) String familyUnit2,
			@RequestParam(value="familyName3", required=false) String familyName3,
			@RequestParam(value="familyAge3", required=false) String familyAge3,
			@RequestParam(value="familyRelate3", required=false) String familyRelate3,
			@RequestParam(value="familyUnit3", required=false) String familyUnit3,
			@RequestParam(value="familyName4", required=false) String familyName4,
			@RequestParam(value="familyAge4", required=false) String familyAge4,
			@RequestParam(value="familyRelate4", required=false) String familyRelate4,
			@RequestParam(value="familyUnit4", required=false) String familyUnit4,
			@RequestParam(value="reason", required=false) String reason,
			@RequestParam(value="oper", required=true) String oper,
			HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
				
		if ("add".equals(oper)) {
			try {
				Student student = (Student)user;
				WorkFlow wf = workFlowService.getEntity("HBL");
				LoanHbl item = new LoanHbl();
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
				
				item.setJxj(jxj);
				item.setNativeType(nativeType);
				item.setAddr(addr);
				item.setTel(tel);
				item.setTotalCount(totalCount);
				item.setTotalIncome(totalIncome);
				item.setPeopleIncome(peopleIncome);
				item.setIncomeFrom(incomeFrom);
				item.setFamilyName1(familyName1);
				item.setFamilyAge1(familyAge1);
				item.setFamilyRelate1(familyRelate1);
				item.setFamilyUnit1(familyUnit1);
				item.setFamilyName2(familyName2);
				item.setFamilyAge2(familyAge2);
				item.setFamilyRelate2(familyRelate2);
				item.setFamilyUnit2(familyUnit2);
				item.setFamilyName3(familyName3);
				item.setFamilyAge3(familyAge3);
				item.setFamilyRelate3(familyRelate3);
				item.setFamilyUnit3(familyUnit3);
				item.setFamilyName4(familyName4);
				item.setFamilyAge4(familyAge4);
				item.setFamilyRelate4(familyRelate4);
				item.setFamilyUnit4(familyUnit4);
				item.setReason(reason);
				
				loanHblService.add(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				Student student = (Student)user;
				LoanHbl item = loanHblService.getEntity(id);
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
				
				item.setJxj(jxj);
				item.setNativeType(nativeType);
				item.setAddr(addr);
				item.setTel(tel);
				item.setTotalCount(totalCount);
				item.setTotalIncome(totalIncome);
				item.setPeopleIncome(peopleIncome);
				item.setIncomeFrom(incomeFrom);
				item.setFamilyName1(familyName1);
				item.setFamilyAge1(familyAge1);
				item.setFamilyRelate1(familyRelate1);
				item.setFamilyUnit1(familyUnit1);
				item.setFamilyName2(familyName2);
				item.setFamilyAge2(familyAge2);
				item.setFamilyRelate2(familyRelate2);
				item.setFamilyUnit2(familyUnit2);
				item.setFamilyName3(familyName3);
				item.setFamilyAge3(familyAge3);
				item.setFamilyRelate3(familyRelate3);
				item.setFamilyUnit3(familyUnit3);
				item.setFamilyName4(familyName4);
				item.setFamilyAge4(familyAge4);
				item.setFamilyRelate4(familyRelate4);
				item.setFamilyUnit4(familyUnit4);
				item.setReason(reason);
				
				loanHblService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
