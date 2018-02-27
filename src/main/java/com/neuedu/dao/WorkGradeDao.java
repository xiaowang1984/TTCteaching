package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.WorkGrade;

public interface WorkGradeDao {
	public List<WorkGrade> getWorkGrades(WorkGrade workGrade);
	public int add(WorkGrade workGrade);
	public int update(WorkGrade workGrade);
	public int del(int id);
	public WorkGrade getWorkGradeById(WorkGrade workGrade);
	public int getCount(WorkGrade workGrade);
}