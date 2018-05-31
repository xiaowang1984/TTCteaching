package com.neuedu.service.interview;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Interview;
import com.neuedu.util.ResultData;

public interface IinterviewService {
	public ResultData getInterviews(Interview interview);
	public Message add(Interview interview);
	public Message update(Interview interview,int iId);
	public Message del(int id);
	public Interview getInterviewById(Interview interview);
	public List<Interview> getReport(Interview interview);
}
