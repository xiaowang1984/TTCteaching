package com.neuedu.service.interviewDetails;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.Student;
import com.neuedu.util.ResultData;

public interface IinterviewDetailsService {
	public ResultData getInterviewDetailss(InterviewDetails interviewDetails);
	public Message add(InterviewDetails interviewDetails);
	public Message update(InterviewDetails interviewDetails);
	public Message del(int id);
	public InterviewDetails getInterviewDetailsById(InterviewDetails interviewDetails);
	public List<Student> getStudents(int gId);
}
