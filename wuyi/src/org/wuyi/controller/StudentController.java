package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyi.common.CommonUtil;
import org.wuyi.entity.Classes;
import org.wuyi.entity.Student;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.ClassesService;
import org.wuyi.service.StudentService;


/**
 * 学生管理
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private ClassesService classesService;
	@Autowired
	private StudentService studentService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("studentList")
	@RequireLogin
	public String list() {
		return "system/studentList";
	}
	
	@RequestMapping("studentAdd")
	@RequireLogin
	public String add(Model model) {
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		return "system/studentAdd";
	}
	
	@RequestMapping("studentEdit")
	@RequireLogin
	public String edit(@RequestParam(value="userId", required=true) String userId, Model model) {
		
		Student user = studentService.getEntity(userId);
		model.addAttribute("user", user);
		
		List<Classes> classesList = classesService.selectAll();
		model.addAttribute("classesList", classesList);
		
		return "system/studentEdit";
	}
	
	@RequestMapping("allStudent")
	@RequireLogin
	@ResponseBody
	public List<Student> all(){
		List<Student> studentList = studentService.selectAll();
		return studentList;
	}
	
	@RequestMapping("manageStudent")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="userId", required=false) String userId,
			@RequestParam(value="classesId", required=false) String classesId,
			@RequestParam(value="idcard", required=false) String idcard,
			@RequestParam(value="from", required=false) String from,
			@RequestParam(value="grade", required=false) String grade,
			@RequestParam(value="schoolYear", required=false) String schoolYear,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="sex", required=false) String sex,
			@RequestParam(value="tel", required=false) String tel,
			@RequestParam(value="mail", required=false) String mail,
			@RequestParam(value="birthday", required=false) String birthday,
			@RequestParam(value="oper", required=true) String oper) {
		
		Student user = new Student();
		user.setUserId(userId);
		user.setPassword(password);
		user.setUserType("学生");
		user.setName(name);
		user.setSex(sex);
		user.setTel(tel);
		user.setMail(mail);
		user.setBirthday(CommonUtil.formatDate(birthday));
		user.setIdcard(idcard);
		user.setFrom(from);
		user.setGrade(grade);
		user.setSchoolYear(schoolYear);
		Classes classes = new Classes();
		classes.setId(classesId);
		user.setClasses(classes);
		
		if ("add".equals(oper)) {
			try {
				studentService.add(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				studentService.update(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("del".equals(oper)) {
			try {
				studentService.delete(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
