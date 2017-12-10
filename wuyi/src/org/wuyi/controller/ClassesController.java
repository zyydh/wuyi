package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyi.entity.Classes;
import org.wuyi.entity.Teacher;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.ClassesService;
import org.wuyi.service.TeacherService;


/**
 * 班级管理
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class ClassesController {

	@Autowired
	private ClassesService classesService;
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("classesList")
	@RequireLogin
	public String list() {
		return "system/classesList";
	}
	
	@RequestMapping("classesAdd")
	@RequireLogin
	public String add(Model model) {
		List<Teacher> teacherList = teacherService.selectAll();
		model.addAttribute("teacherList", teacherList);
		return "system/classesAdd";
	}
	
	@RequestMapping("classesEdit")
	@RequireLogin
	public String edit(@RequestParam(value="id", required=true) String id, Model model) {
		
		Classes classes = classesService.getEntity(id);
		model.addAttribute("classes", classes);
		
		List<Teacher> teacherList = teacherService.selectAll();
		model.addAttribute("teacherList", teacherList);
		
		return "system/classesEdit";
	}
	
	@RequestMapping("allClasses")
	@RequireLogin
	@ResponseBody
	public List<Classes> all(){
		List<Classes> classesList = classesService.selectAll();
		return classesList;
	}
	
	@RequestMapping("manageClasses")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="id", required=false) String id,
			@RequestParam(value="major", required=false) String major,
			@RequestParam(value="count", required=false) Integer count,
			@RequestParam(value="instructorId", required=false) String instructorId,
			@RequestParam(value="classMentorId", required=false) String classMentorId,
			@RequestParam(value="oper", required=true) String oper) {
		
		Classes classes = new Classes();
		classes.setId(id);
		classes.setMajor(major);
		if (count == null) {
			count = 0;
		}
		classes.setCount(count);
		Teacher instructor = new Teacher();
		instructor.setUserId(instructorId);
		classes.setInstructor(instructor);
		Teacher classMentor = new Teacher();
		classMentor.setUserId(classMentorId);
		classes.setClassMentor(classMentor);
		
		if ("add".equals(oper)) {
			try {
				classesService.add(classes);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				classesService.update(classes);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("del".equals(oper)) {
			try {
				classesService.delete(classes);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
