package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyi.common.CommonUtil;
import org.wuyi.common.JqGridData;
import org.wuyi.entity.Teacher;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.TeacherService;


/**
 * 教师管理
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 进入用户列表界面
	 */
	@RequestMapping("teacherList")
	@RequireLogin
	public String list() {
		return "system/teacherList";
	}
	
	@RequestMapping("teacherAdd")
	@RequireLogin
	public String add(Model model) {
		return "system/teacherAdd";
	}
	
	@RequestMapping("teacherEdit")
	@RequireLogin
	public String edit(@RequestParam(value="userId", required=true) String userId, Model model) {
		
		Teacher user = teacherService.getEntity(userId);
		
		model.addAttribute("user", user);
		return "system/teacherEdit";
	}
	
	@RequestMapping("allTeacher")
	@RequireLogin
	@ResponseBody
	public List<Teacher> all(){
		List<Teacher> teacherList = teacherService.selectAll();
		return teacherList;
	}
	
	@RequestMapping("manageTeacher")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="userId", required=false) String userId,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="sex", required=false) String sex,
			@RequestParam(value="tel", required=false) String tel,
			@RequestParam(value="mail", required=false) String mail,
			@RequestParam(value="birthday", required=false) String birthday,
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="oper", required=true) String oper) {
		
		Teacher user = new Teacher();
		user.setUserId(userId);
		user.setPassword(password);
		user.setUserType("教师");
		user.setName(name);
		user.setSex(sex);
		user.setTel(tel);
		user.setMail(mail);
		user.setBirthday(CommonUtil.formatDate(birthday));
		user.setTitle(title);
		
		if ("add".equals(oper)) {
			try {
				teacherService.add(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				teacherService.update(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("del".equals(oper)) {
			try {
				teacherService.delete(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
