package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;

public interface ArrangeListDao {
	public List<ArrangeList> getArrangeLists(ArrangeList arrangeList);
	public int add(ArrangeList arrangeList);
	public int update(ArrangeList arrangeList);
	public int del(int id);
	public ArrangeList getArrangeListById(ArrangeList arrangeList);
	public int getCount(ArrangeList arrangeList);
	public List<ArrangeList> getLogs(Arrange arrange);
	public int getLogCount(Arrange arrage);
}