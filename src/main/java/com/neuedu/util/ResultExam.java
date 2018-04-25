package com.neuedu.util;

public class ResultExam {
	
	public ResultExam(Integer code, Object mess) {
		super();
		this.code = code;
		this.mess = mess;
	}
	private Integer code;
	private Object mess;
	public Integer getCode() {
		return code;
	}
	public Object getMess() {
		return mess;
	}
}
