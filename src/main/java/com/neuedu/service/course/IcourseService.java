package com.neuedu.service.course;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.neuedu.util.Message;
import com.neuedu.pojo.Course;
import com.neuedu.util.ResultData;

public interface IcourseService {
	public ResultData getCourses(Course course);
	public Message add(MultipartFile logo,Course course);
	public Message update(MultipartFile logo,Course course);
	public Message del(int id);
	public Course getCourseById(Course course);
	public List<Course> getAll(Course course);
	public List<Course> getCourseByGid(int gId);
}
