package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Interview;

public interface InterviewDao {
	public List<Interview> getInterviews(Interview interview);
	public int add(Interview interview);
	public int update(Interview interview);
	public int del(int id);
	public Interview getInterviewById(Interview interview);
	public int getCount(Interview interview);
	public List<Interview> getReport(Interview interview);
}