package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Tests;

public interface TestsDao {
	public List<Tests> getTestss(Tests tests);
	public int add(Tests tests);
	public int update(Tests tests);
	public int del(int id);
	public Tests getTestsById(Tests tests);
	public int getCount(Tests tests);
}