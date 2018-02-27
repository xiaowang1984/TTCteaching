package com.neuedu.service.workStudent;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.WorkStudent;
import com.neuedu.util.ResultData;

public interface IworkStudentService {
	public ResultData getWorkStudents(WorkStudent workStudent);
	public Message add(WorkStudent workStudent);
	public Message update(WorkStudent workStudent);
	public Message del(int id);
	public WorkStudent getWorkStudentById(WorkStudent workStudent);
}
