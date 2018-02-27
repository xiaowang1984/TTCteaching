package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.WorkStudentDetail;

public interface WorkStudentDetailDao {
	public List<WorkStudentDetail> getWorkStudentDetails(WorkStudentDetail workStudentDetail);
	public int add(WorkStudentDetail workStudentDetail);
	public int update(WorkStudentDetail workStudentDetail);
	public int del(int id);
	public WorkStudentDetail getWorkStudentDetailById(WorkStudentDetail workStudentDetail);
	public int getCount(WorkStudentDetail workStudentDetail);
}