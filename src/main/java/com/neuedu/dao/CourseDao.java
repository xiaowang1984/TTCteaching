package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Course;

public interface CourseDao {
	public List<Course> getCourses(Course course);
	public int add(Course course);
	public int update(Course course);
	public int del(int id);
	public Course getCourseById(Course course);
	public int getCount(Course course);
	public List<Course> getComputerCourse(int gId);
}