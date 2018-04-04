package com.neuedu.util;

import java.util.List;
import java.util.Map;

public class ResultData {
	private List<?> list;
	private Integer count;
	private Integer pageSize;
	private Integer pageNo;
	private Integer totalPage;
	private Map<String, Object> attr;
	public Map<String, Object> getAttr() {
		return attr;
	}
	public void setAttr(Map<String, Object> attr) {
		this.attr = attr;
	}
	public ResultData(List<?> list, Integer count, Integer pageSize, Integer pageNo) {
		super();
		this.list = list;
		this.count = count;
		this.pageSize = pageSize;
		this.pageNo=pageNo;
		this.totalPage=count%pageSize>0?count/pageSize+1:count/pageSize;
	}
	public List<?> getList() {
		return list;
	}
	public Integer getCount() {
		return count;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	
}
