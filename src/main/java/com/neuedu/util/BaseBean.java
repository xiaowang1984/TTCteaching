package com.neuedu.util;

import lombok.Data;

@Data
public class BaseBean {
	private Integer pageNo=1;
	private Integer pageSize=9;
	private String fields;
	private String orderBy="id desc";
	private String where;
	private Integer withPage=1;
	public Integer getPageStart(){
		return (pageNo-1)*pageSize;
	}
}
