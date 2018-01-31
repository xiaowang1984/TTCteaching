package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Cases;

public interface CasesDao {
	public List<Cases> getCasess(Cases cases);
	public int add(Cases cases);
	public int update(Cases cases);
	public int del(int id);
	public Cases getCasesById(Cases cases);
	public int getCount(Cases cases);
}