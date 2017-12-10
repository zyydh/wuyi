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
import org.wuyi.entity.LoanStudent;
import org.wuyi.entity.Student;
import org.wuyi.entity.User;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.ClassesService;
import org.wuyi.service.LoanStudentService;
import org.wuyi.service.LoginService;
import org.wuyi.service.WorkFlowService;


/**
 * 助学贷款
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class LoanStudentController {

	@Autowired
	private LoanStudentService loanStudentService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ClassesService classesService;
	
	@RequestMapping("loanStudentAdd")
	@RequireLogin
	public String add(@RequestParam(value="wfId", required=false) String wfId, Model model, HttpSession session) {
		User user = loginService.getLoginedUser(session);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", user);
		model.addAttribute("wfId", wfId);
		return "forms/loanStudentAdd";
	}
	
	@RequestMapping("loanStudentEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) Integer id, Model model) {
		
		LoanStudent item = loanStudentService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		return "forms/loanStudentEdit";
	}
	
	@RequestMapping("loanStudentDetail")
	@RequireLogin
	public String detail(@RequestParam(value="id", required=true) Integer id, @RequestParam(value="back", required=true) String back, Model model) {
		
		LoanStudent item = loanStudentService.getEntity(id);
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		model.addAttribute("user", item.getMaker());
		model.addAttribute("item", item);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		model.addAttribute("back", back);
		return "forms/loanStudentDetail";
	}
	
	@RequestMapping("manageLoanStudent")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="nativeAddr", required=false) String nativeAddr,
			@RequestParam(value="zipCode", required=false) String zipCode,
			@RequestParam(value="addr", required=false) String addr,
			@RequestParam(value="marry", required=false) String marry,
			@RequestParam(value="tel", required=false) String tel,
			@RequestParam(value="mobile", required=false) String mobile,
			@RequestParam(value="qq", required=false) String qq,
			@RequestParam(value="totalCount", required=false) String totalCount,
			@RequestParam(value="totalIncome", required=false) String totalIncome,
			@RequestParam(value="peopleIncome", required=false) String peopleIncome,
			@RequestParam(value="fatherName", required=false) String fatherName,
			@RequestParam(value="fatherTel", required=false) String fatherTel,
			@RequestParam(value="fatherIdcard", required=false) String fatherIdcard,
			@RequestParam(value="fatherWork", required=false) String fatherWork,
			@RequestParam(value="fatherMobile", required=false) String fatherMobile,
			@RequestParam(value="motherName", required=false) String motherName,
			@RequestParam(value="motherTel", required=false) String motherTel,
			@RequestParam(value="motherIdcard", required=false) String motherIdcard,
			@RequestParam(value="motherWork", required=false) String motherWork,
			@RequestParam(value="motherMobile", required=false) String motherMobile,
			@RequestParam(value="otherName", required=false) String otherName,
			@RequestParam(value="otherTel", required=false) String otherTel,
			@RequestParam(value="otherIdcard", required=false) String otherIdcard,
			@RequestParam(value="otherWork", required=false) String otherWork,
			@RequestParam(value="otherMobile", required=false) String otherMobile,
			@RequestParam(value="reason", required=false) String reason,
			@RequestParam(value="type", required=false) String type,
			@RequestParam(value="amount", required=false) Integer amount,
			@RequestParam(value="oper", required=true) String oper,
			HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		
		if (amount == null) {
			amount = 0;
		}
		
		if ("add".equals(oper)) {
			try {
				Student student = (Student)user;
				WorkFlow wf = workFlowService.getEntity("ZXDK");
				LoanStudent item = new LoanStudent();
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
				
				item.setNativeAddr(nativeAddr);
				item.setZipCode(zipCode);
				item.setAddr(addr);
				item.setMarry(marry);
				item.setTel(tel);
				item.setMobile(mobile);
				item.setQq(qq);
				item.setTotalCount(totalCount);
				item.setTotalIncome(totalIncome);
				item.setPeopleIncome(peopleIncome);
				item.setFatherName(fatherName);
				item.setFatherTel(fatherTel);
				item.setFatherIdcard(fatherIdcard);
				item.setFatherWork(fatherWork);
				item.setFatherMobile(fatherMobile);
				item.setMotherName(motherName);
				item.setMotherTel(motherTel);
				item.setMotherIdcard(motherIdcard);
				item.setMotherWork(motherWork);
				item.setMotherMobile(motherMobile);
				item.setOtherName(otherName);
				item.setOtherTel(otherTel);
				item.setOtherIdcard(otherIdcard);
				item.setOtherWork(otherWork);
				item.setOtherMobile(otherMobile);
				item.setReason(reason);
				item.setType(type);
				item.setAmount(amount);
				
				loanStudentService.add(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				Student student = (Student)user;
				LoanStudent item = loanStudentService.getEntity(id);
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
				
				item.setNativeAddr(nativeAddr);
				item.setZipCode(zipCode);
				item.setAddr(addr);
				item.setMarry(marry);
				item.setTel(tel);
				item.setMobile(mobile);
				item.setQq(qq);
				item.setTotalCount(totalCount);
				item.setTotalIncome(totalIncome);
				item.setPeopleIncome(peopleIncome);
				item.setFatherName(fatherName);
				item.setFatherTel(fatherTel);
				item.setFatherIdcard(fatherIdcard);
				item.setFatherWork(fatherWork);
				item.setFatherMobile(fatherMobile);
				item.setMotherName(motherName);
				item.setMotherTel(motherTel);
				item.setMotherIdcard(motherIdcard);
				item.setMotherWork(motherWork);
				item.setMotherMobile(motherMobile);
				item.setOtherName(otherName);
				item.setOtherTel(otherTel);
				item.setOtherIdcard(otherIdcard);
				item.setOtherWork(otherWork);
				item.setOtherMobile(otherMobile);
				item.setReason(reason);
				item.setType(type);
				item.setAmount(amount);
				
				loanStudentService.update(item);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
