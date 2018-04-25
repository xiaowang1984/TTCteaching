package com.neuedu.service.examStudentDetails;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.ExamStudentDetails;
import com.neuedu.util.ResultData;

public interface IexamStudentDetailsService {
	public ResultData getExamStudentDetailss(ExamStudentDetails examStudentDetails);
	public Message add(ExamStudentDetails examStudentDetails);
	public Message update(ExamStudentDetails examStudentDetails);
	public Message del(int id);
	public ExamStudentDetails getExamStudentDetailsById(ExamStudentDetails examStudentDetails);
}
