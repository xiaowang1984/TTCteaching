package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.ExamStudentDetails;

public interface ExamStudentDetailsDao {
	public List<ExamStudentDetails> getExamStudentDetailss(ExamStudentDetails examStudentDetails);
	public int add(ExamStudentDetails examStudentDetails);
	public int update(ExamStudentDetails examStudentDetails);
	public int del(int id);
	public ExamStudentDetails getExamStudentDetailsById(ExamStudentDetails examStudentDetails);
	public int getCount(ExamStudentDetails examStudentDetails);
}