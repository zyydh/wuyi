package org.wuyi.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wuyi.common.AppConstants;
import org.wuyi.dao.UserDao;
import org.wuyi.entity.User;
import org.wuyi.exception.BusinesssException;

@Service
public class LoginService {

	protected static Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private UserDao userDao;
	/**
	 * Web端 登录
	 */
	@Transactional
	public User login(String loginId, String loginPassword, HttpSession session) throws BusinesssException {
		
		User user = userDao.getEntity(loginId);
		if (user == null) {
			throw new BusinesssException(-1, "用户不存在");
		}
		
		if (!loginPassword.trim().toUpperCase().equals(user.getPassword().toUpperCase())) {
			throw new BusinesssException(-1, "密码不正确");
		}
		
		session.setAttribute(AppConstants.KEY_CUSTOMER_SESSION, user);		
		return user;
	}
	
	/**
	 * Web端 从session取登录用户
	 * @param session
	 * @return
	 */
	public User getLoginedUser(HttpSession session) {
		Object obj = session.getAttribute(AppConstants.KEY_CUSTOMER_SESSION);
		return obj == null ? null : (User) obj;
	}
	
	
	/**
	 * 判断用户是否登录
	 * @param token
	 * @return
	 */
	public boolean checkLogin(HttpSession session) {
		Object obj = session.getAttribute(AppConstants.KEY_CUSTOMER_SESSION);
		return obj == null ? false : true;
	}
	
	/**
	 * Web端 退出
	 * @param session
	 */
	public void logout(HttpSession session) {
		Object obj = session.getAttribute(AppConstants.KEY_CUSTOMER_SESSION);
		if (obj != null) {
			session.removeAttribute(AppConstants.KEY_CUSTOMER_SESSION);
			session.invalidate();
		}
	}
	
}
