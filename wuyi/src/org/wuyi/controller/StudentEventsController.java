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
import org.wuyi.entity.StudentEvents;
import org.wuyi.entity.User;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.LoginService;
import org.wuyi.service.StudentEventsService;


/**
 * 学生事件
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class StudentEventsController {

	@Autowired
	private StudentEventsService studentEventsService;
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("studentEventsList")
	@RequireLogin
	public String list() {
		return "student/studentEventsList";
	}
	
	@RequestMapping("studentEventsAdd")
	@RequireLogin
	public String add(Model model, HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		model.addAttribute("user", user);
		
		return "student/studentEventsAdd";
	}
	
	@RequestMapping("studentEventsEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) int id, Model model, HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		model.addAttribute("user", user);
		
		StudentEvents event = studentEventsService.getEntity(id);
		model.addAttribute("event", event);
		
		return "student/studentEventsEdit";
	}
	
	@RequestMapping("studentEventsDetail")
	@RequireLogin
	public String detail(@RequestParam(value="id", required=true) int id, Model model, HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		model.addAttribute("user", user);
		
		StudentEvents event = studentEventsService.getEntity(id);
		model.addAttribute("event", event);
		
		return "student/studentEventsDetail";
	}
	
	@RequestMapping("allStudentEvents")
	@RequireLogin
	@ResponseBody
	public List<StudentEvents> all(HttpSession session){
		User user = loginService.getLoginedUser(session);
		List<StudentEvents> studentEventsList = studentEventsService.listByUser(user);
		return studentEventsList;
	}
	
	@RequestMapping("manageStudentEvents")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) Integer id,
			@RequestParam(value="unitName", required=false) String unitName,
			@RequestParam(value="unitContact", required=false) String unitContact,
			@RequestParam(value="unitTel", required=false) String unitTel,
			@RequestParam(value="studentName", required=false) String studentName,
			@RequestParam(value="studentNative", required=false) String studentNative,
			@RequestParam(value="sex", required=false) String sex,
			@RequestParam(value="birthday", required=false) String birthday,
			@RequestParam(value="tel", required=false) String tel,
			@RequestParam(value="classes", required=false) String classes,
			@RequestParam(value="fatherName", required=false) String fatherName,
			@RequestParam(value="fatherTel", required=false) String fatherTel,
			@RequestParam(value="instructor", required=false) String instructor,
			@RequestParam(value="eventAddr", required=false) String eventAddr,
			@RequestParam(value="eventTime", required=false) String eventTime,
			@RequestParam(value="eventType", required=false) String eventType,
			@RequestParam(value="familyDesc", required=false) String familyDesc,
			@RequestParam(value="schoolDesc", required=false) String schoolDesc,
			@RequestParam(value="mentalStatus", required=false) String mentalStatus,
			@RequestParam(value="hasProtect", required=false) String hasProtect,
			@RequestParam(value="dieCount", required=false) String dieCount,
			@RequestParam(value="hurtCount", required=false) String hurtCount,
			@RequestParam(value="eventDetail", required=false) String eventDetail,
			@RequestParam(value="unitIncharg", required=false) String unitIncharg,
			@RequestParam(value="oper", required=true) String oper, HttpSession session) {
		
		User user = loginService.getLoginedUser(session);
		
		if ("add".equals(oper)) {
			try {
				StudentEvents event = new StudentEvents();
				event.setUnitName(unitName);
				event.setUnitContact(unitContact);
				event.setUnitTel(unitTel);
				event.setStudentName(studentName);
				event.setStudentNative(studentNative);
				event.setSex(sex);
				event.setBirthday(birthday);
				event.setTel(tel);
				event.setClasses(classes);
				event.setFatherName(fatherName);
				event.setFatherTel(fatherTel);
				event.setInstructor(instructor);
				event.setEventAddr(eventAddr);
				event.setEventTime(eventTime);
				event.setEventType(eventType);
				event.setFamilyDesc(familyDesc);
				event.setSchoolDesc(schoolDesc);
				event.setMentalStatus(mentalStatus);
				event.setHasProtect(hasProtect);
				event.setDieCount(dieCount);
				event.setHurtCount(hurtCount);
				event.setEventDetail(eventDetail);
				event.setUnitIncharg(unitIncharg);
				event.setMaker(user);
				event.setSubmitTime(new Date());
				
				studentEventsService.add(event);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				StudentEvents event = studentEventsService.getEntity(id);
				event.setUnitName(unitName);
				event.setUnitContact(unitContact);
				event.setUnitTel(unitTel);
				event.setStudentName(studentName);
				event.setStudentNative(studentNative);
				event.setSex(sex);
				event.setBirthday(birthday);
				event.setTel(tel);
				event.setClasses(classes);
				event.setFatherName(fatherName);
				event.setFatherTel(fatherTel);
				event.setInstructor(instructor);
				event.setEventAddr(eventAddr);
				event.setEventTime(eventTime);
				event.setEventType(eventType);
				event.setFamilyDesc(familyDesc);
				event.setSchoolDesc(schoolDesc);
				event.setMentalStatus(mentalStatus);
				event.setHasProtect(hasProtect);
				event.setDieCount(dieCount);
				event.setHurtCount(hurtCount);
				event.setEventDetail(eventDetail);
				event.setUnitIncharg(unitIncharg);
				
				studentEventsService.update(event);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("del".equals(oper)) {
			try {
				StudentEvents event = studentEventsService.getEntity(id);
				studentEventsService.delete(event);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
