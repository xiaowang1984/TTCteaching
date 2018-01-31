package com.neuedu.util;

import java.util.List;

public class ResultData {
	private List<?> list;
	private Integer count;
	private Integer pageSize;
	private Integer pageNo;
	private Integer totalPage;
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
