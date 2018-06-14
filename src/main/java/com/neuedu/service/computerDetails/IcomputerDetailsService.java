package com.neuedu.service.computerDetails;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.ComputerDetails;
import com.neuedu.pojo.Student;
import com.neuedu.util.ResultData;

public interface IcomputerDetailsService {
	public ResultData getComputerDetailss(ComputerDetails computerDetails);
	public Message add(ComputerDetails computerDetails);
	public Message update(ComputerDetails computerDetails);
	public Message del(int id);
	public ComputerDetails getComputerDetailsById(ComputerDetails computerDetails);
	public List<Student> getStudents(int gId);
}
