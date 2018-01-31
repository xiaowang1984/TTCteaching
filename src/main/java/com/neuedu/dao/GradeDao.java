package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Grade;

public interface GradeDao {
	public List<Grade> getGrades(Grade grade);
	public Grade getGrandById(Grade grade);
	public int add(Grade grade);
	public int update(Grade grade);
	public int del(Integer id);
	public int getCount(Grade grade);
	public String getTeacher(Integer tid);
	public String getImgByGid(Integer gid);
}
