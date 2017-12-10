package org.wuyi.common;


public class AppConstants {
	
	public static final int Return_Code_Success = 0;
	public static final int Return_Code_Failed = 50;
	public static final int Return_Code_AuthorizationFailed = 99;
	public static final int Return_Code_SignFailed = 98;
	public static final int Return_Code_SystemError = 97;
	//返回简单消息，正常
	public static final SimpleMessage SM_SUCCESS = new SimpleMessage(Return_Code_Success, "");
	//返回简单消息，失败
	public static final SimpleMessage SM_FAILED = new SimpleMessage(Return_Code_Failed, "");
	//返回简单消息，登录异常
	public static final SimpleMessage SM_AuthorizationFailed = new SimpleMessage(Return_Code_AuthorizationFailed, "登录异常，请重新登录！");
	//返回简单消息，系统错误
	public static final SimpleMessage SM_SystemError = new SimpleMessage(Return_Code_SystemError, "系统错误");
	
	//登录用户的session key
	public static final String KEY_CUSTOMER_SESSION = "LoginedCustomer";
	

}
