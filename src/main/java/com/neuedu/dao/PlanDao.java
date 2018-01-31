package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Plan;

public interface PlanDao {
	public List<Plan> getPlans(Plan plan);
	public int add(Plan plan);
	public int update(Plan plan);
	public int del(int id);
	public Plan getPlanById(Plan plan);
	public int getCount(Plan plan);
}