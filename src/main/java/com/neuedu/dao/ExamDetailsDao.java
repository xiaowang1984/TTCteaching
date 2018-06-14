package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.ExamDetails;

public interface ExamDetailsDao {
	public List<ExamDetails> getExamDetailss(ExamDetails examDetails);
	public int add(ExamDetails examDetails);
	public int update(ExamDetails examDetails);
	public int del(int id);
	public ExamDetails getExamDetailsById(ExamDetails examDetails);
	public int getCount(ExamDetails examDetails);
	public ExamDetails getExamDetailsBySid(ExamDetails examDetails);
	public int checkReport(ExamDetails examDetails);
	public int createReportDetails(int id);
	
}