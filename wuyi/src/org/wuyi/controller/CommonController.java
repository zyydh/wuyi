package org.wuyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公用Controller
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class CommonController {
    
    /**
     * 公共错误页面
     * @return
     */
    @RequestMapping("error404")
    public String error404() {
    	return "error";
    }
}
