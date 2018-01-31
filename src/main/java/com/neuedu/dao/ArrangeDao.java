package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Arrange;

public interface ArrangeDao {
	public List<Arrange> getArranges(Arrange arrange);
	public int add(Arrange arrange);
	public int update(Arrange arrange);
	public int del(int id);
	public Arrange getArrangeById(Arrange arrange);
	public int getCount(Arrange arrange);
}