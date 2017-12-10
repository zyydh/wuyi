package org.wuyi.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单消息类，用于返回JSON格式的操作响应
 * @author lgm-dell
 *
 */
public class SimpleMessage implements Serializable {

	private static final long serialVersionUID = -7321833383244633205L;
	private int code = -1;
	private String msg;
	
	public SimpleMessage() {
		
	}
	
	public SimpleMessage(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public SimpleMessage(String msg) {
		this.msg = msg;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
