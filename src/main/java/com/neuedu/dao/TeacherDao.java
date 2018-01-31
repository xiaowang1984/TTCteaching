package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Teacher;

public interface TeacherDao {
	public List<Teacher> getTeachers(Teacher teacher);
	public int add(Teacher teacher);
	public int update(Teacher teacher);
	public int del(int id);
	public Teacher getTeacherById(Teacher teacher);
	public int getCount(Teacher teacher);
}