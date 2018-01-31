package com.neuedu.service.student;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Student;
import com.neuedu.util.ResultData;

public interface IstudentService {
	public ResultData getStudents(Student student);
	public Message add(Student student);
	public Message update(Student student);
	public Message del(int id);
	public Student getStudentById(Student student);
}
