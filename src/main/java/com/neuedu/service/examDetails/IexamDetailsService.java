package com.neuedu.service.examDetails;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.ExamDetails;
import com.neuedu.util.ResultData;

public interface IexamDetailsService {
	public ResultData getExamDetailss(ExamDetails examDetails);
	public Message add(ExamDetails examDetails);
	public Message update(ExamDetails examDetails);
	public Message del(int id);
	public ExamDetails getExamDetailsById(ExamDetails examDetails);
}
