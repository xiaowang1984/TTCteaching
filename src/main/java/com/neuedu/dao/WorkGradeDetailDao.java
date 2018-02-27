package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.WorkGradeDetail;

public interface WorkGradeDetailDao {
	public List<WorkGradeDetail> getWorkGradeDetails(WorkGradeDetail workGradeDetail);
	public int add(WorkGradeDetail workGradeDetail);
	public int update(WorkGradeDetail workGradeDetail);
	public int del(int id);
	public WorkGradeDetail getWorkGradeDetailById(WorkGradeDetail workGradeDetail);
	public int getCount(WorkGradeDetail workGradeDetail);
}