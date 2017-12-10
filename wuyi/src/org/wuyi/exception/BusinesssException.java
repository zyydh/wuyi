package org.wuyi.exception;



/**
 * 自定义的业务异常
 * 此类异常应在Controller层进行处理
 * @author lgm-dell
 *
 */
public class BusinesssException extends RuntimeException {

	private static final long serialVersionUID = -1363546584967181334L;

	protected int returnCode = -1;
	protected String msg;
	
	public BusinesssException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BusinesssException(int returnCode, String msg) {
		super(msg);
		this.returnCode = returnCode;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	public int getReturnCode() {
		return returnCode;
	}
}
