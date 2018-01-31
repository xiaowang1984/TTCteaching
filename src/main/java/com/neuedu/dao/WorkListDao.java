package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.WorkList;

public interface WorkListDao {
	public List<WorkList> getWorkLists(WorkList workList);
	public int add(WorkList workList);
	public int update(WorkList workList);
	public int del(int id);
	public WorkList getWorkListById(WorkList workList);
	public int getCount(WorkList workList);
}