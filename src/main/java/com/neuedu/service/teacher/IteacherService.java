package com.neuedu.service.teacher;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Teacher;
import com.neuedu.util.ResultData;

public interface IteacherService {
	public ResultData getTeachers(Teacher teacher);
	public Message add(Teacher teacher);
	public Message update(Teacher teacher);
	public Message del(int id);
	public Teacher getTeacherById(Teacher teacher);
	public int getCount(Teacher teacher);
}
