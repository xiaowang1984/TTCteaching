package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.WorkStudent;

public interface WorkStudentDao {
	public List<WorkStudent> getWorkStudents(WorkStudent workStudent);
	public int add(WorkStudent workStudent);
	public int update(WorkStudent workStudent);
	public int del(int id);
	public WorkStudent getWorkStudentById(WorkStudent workStudent);
	public int getCount(WorkStudent workStudent);
}