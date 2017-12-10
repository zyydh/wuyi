package org.wuyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wuyi.exception.BusinesssException;
import org.wuyi.service.LoginService;

/**
 * 登录
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
 
	@Autowired
	private LoginService loginService;
	
	/**
	 * 加载登录页面
	 * @param afterLoginUrl
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String loginInit(HttpSession session, Model model) {
		return "login";
	}
	
	/**
	 * 执行登录操作
	 */
    @RequestMapping("doLogin")
    public String login(@RequestParam String loginId, 
    		@RequestParam String loginPassword, 
    		Model model,
    		HttpServletRequest request,
    		HttpSession session){

    	try {
    		loginService.login(loginId, loginPassword, session);
    		return "redirect:/index.do";
    	} catch (BusinesssException e) {
    		model.addAttribute("msg", e.getMsg());
    		return "login";
    	}
    }
    
    /**
     * 执行退出操作
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
    	loginService.logout(session);
    	return "login";
    }
    		
}
