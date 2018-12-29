package com.dto;

public enum ResultEnum {
	UKNOW_ERROR(-1,"发生未知错误"),
	USERINFO_ERROR(1,"用户名密码错误，请重新输入"),
	INFO_DOUBLE(2,"已存在！请重新输入");
	
	int code;
	String msg;
	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
}
