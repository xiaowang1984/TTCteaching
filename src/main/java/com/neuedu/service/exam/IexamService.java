package com.neuedu.service.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.util.Message;
import com.neuedu.pojo.Exam;
import com.neuedu.pojo.Paper;
import com.neuedu.util.ResultData;
import com.neuedu.util.ResultExam;

public interface IexamService {
	public ResultData getExams(Exam exam);
	public Message add(Exam exam);
	public Message update(Exam exam);
	public Message del(int id);
	public Exam getExamById(Exam exam);
	public List<Paper> getPapers();
	public ResultExam getPaper(int id,String no);
	public String examSubmit(HttpServletRequest request,Integer sId,Integer eId);
}
