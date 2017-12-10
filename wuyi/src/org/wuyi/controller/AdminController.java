package org.wuyi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wuyi.common.CommonUtil;
import org.wuyi.entity.Admin;

import org.wuyi.security.RequireLogin;
import org.wuyi.service.AdminService;



/**
 * 管理员管理
 * @author lgm-dell
 * 
 */
@Controller
@RequestMapping("/")

public class AdminController {

	@Autowired
	
	private AdminService adminService;
	@RequestMapping("adminList")
    @RequireLogin
	public String list() {
		return "system/adminList";
	}
	@RequestMapping("adminAdd")
	@RequireLogin
	public String add(Model model) {
		return "system/adminAdd";
	}
	
	@RequestMapping("adminEdit")
	@RequireLogin
	public String edit(@RequestParam(value="userId", required=true) String userId, Model model) {
		
		Admin user = adminService.getEntity(userId);
		
		model.addAttribute("user", user);
		return "system/adminEdit";
	}
	
	@RequestMapping("allAdmin")
	@RequireLogin
	@ResponseBody
	public List<Admin> all(){
		List<Admin> adminList = adminService.selectAll();
		return adminList;
	}
	
	@RequestMapping("manageAdmin")
	@RequireLogin
	@ResponseBody
	public boolean manage(@RequestParam(value="userId", required=false) String userId,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="sex", required=false) String sex,
			@RequestParam(value="tel", required=false) String tel,
			@RequestParam(value="mail", required=false) String mail,
			@RequestParam(value="birthday", required=false) String birthday,
			@RequestParam(value="oper", required=true) String oper) {
		
		Admin user = new Admin();
		user.setUserId(userId);
		user.setPassword(password);
		user.setUserType("管理员");
		user.setName(name);
		user.setSex(sex);
		user.setTel(tel);
		user.setBirthday(CommonUtil.formatDate(birthday));
		user.setMail(mail);
		
		if ("add".equals(oper)) {
			try {
				adminService.add(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("edit".equals(oper)) {
			try {
				adminService.update(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else if ("del".equals(oper)) {
			try {
				adminService.delete(user);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}




