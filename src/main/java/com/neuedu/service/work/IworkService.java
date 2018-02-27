package com.neuedu.service.work;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Work;
import com.neuedu.pojo.WorkView;
import com.neuedu.util.ResultData;

public interface IworkService {
	public WorkView getWorks(Work work);
	public Message add(Work work);
	public Message update(Work work);
	public Message del(int id);
	public Work getWorkById(Work work);
	public List<Cases> getCases(Cases cases);
	public void progress();
}
