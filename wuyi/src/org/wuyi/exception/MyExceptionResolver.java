package org.wuyi.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义统一异常处理类
 * @author lgm-dell
 *
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

	private static Logger log = LoggerFactory.getLogger(MyExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

		ModelAndView mav = null;
		
		if (e instanceof AuthorizationException) {
			//登录异常处理
			mav = new ModelAndView("login");
		} else {
			//其它异常，记录到日志
			log.error("未知异常", e);
			mav = new ModelAndView("redirect:/error404");
		}
		
		return mav;
	}
	
}
