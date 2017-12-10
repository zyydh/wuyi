package org.wuyi.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.wuyi.exception.AuthorizationException;
import org.wuyi.service.LoginService;


/**
 * 安全校验切面类，校验登录
 * @author lgm-dell
 *
 */
@Aspect 
@Component
public class SecurityValidAspect {

	private static Logger log = LoggerFactory.getLogger(SecurityValidAspect.class);
	
	@Autowired
	LoginService loginService;
	
	/**
	 * 登录验证，如果验证失败，会抛出AuthorizationException异常
	 * @param jp
	 * @param lv
	 * @throws AuthorizationException
	 */
	@Before("@annotation(lv)")
	public void LoginValid(JoinPoint jp, RequireLogin lv) throws AuthorizationException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession(); 
        if (!loginService.checkLogin(session)) {
        	throw new AuthorizationException();
		}
	}
	
}
