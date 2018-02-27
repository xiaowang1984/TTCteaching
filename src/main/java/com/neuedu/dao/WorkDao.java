package com.neuedu.dao;

import java.util.Date;
import java.util.List;

import com.neuedu.pojo.Work;

public interface WorkDao {
	public List<Work> getWorks(Work work);
	public int add(Work work);
	public int update(Work work);
	public int del(int id);
	public Work getWorkById(Work work);
	public int getCount(Work work);
	public List<Work> getWorksByDat(Date dat);
}