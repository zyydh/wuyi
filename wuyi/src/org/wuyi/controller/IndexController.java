package org.wuyi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wuyi.security.RequireLogin;

/**
 * 主界面
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * 加载主界面
	 * @param afterLoginUrl
	 * @param session
	 * @param model
	 * @return
	 */
	
	@RequestMapping("index")
	@RequireLogin
	public String index(HttpSession session,Model model) {
		
		return "index";
	}
		
}
