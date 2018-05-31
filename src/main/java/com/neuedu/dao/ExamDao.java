package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.pojo.Exam;

public interface ExamDao {
	public List<Exam> getExams(Exam exam);
	public int add(Exam exam);
	public int update(Exam exam);
	public int del(int id);
	public Exam getExamById(Exam exam);
	public int getCount(Exam exam);
	public Exam getExamByNo(String no);
	public List<Map<String,Object>>  getReport(int id);
}