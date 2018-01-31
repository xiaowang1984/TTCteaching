package com.neuedu.util;

public class Message {
	private Integer code;
	private String mess;
	public Message(Integer code){
		this.code=code;
		this.mess=code>0?"操作成功":"操作失败";
	}
	public Integer getCode() {
		return code;
	}
	public String getMess() {
		return mess;
	}
	
}
