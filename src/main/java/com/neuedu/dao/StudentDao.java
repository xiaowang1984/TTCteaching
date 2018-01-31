package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Student;

public interface StudentDao {
	public List<Student> getStudents(Student student);
	public int add(Student student);
	public int update(Student student);
	public int updateByIdCard(Student student);
	public int del(int id);
	public Student getStudentById(Student student);
	public int getCount(Student student);
}