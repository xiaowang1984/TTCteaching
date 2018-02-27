package com.neuedu.service.workStudentDetail;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.WorkStudentDetail;
import com.neuedu.util.ResultData;

public interface IworkStudentDetailService {
	public ResultData getWorkStudentDetails(WorkStudentDetail workStudentDetail);
	public Message add(WorkStudentDetail workStudentDetail);
	public Message update(WorkStudentDetail workStudentDetail);
	public Message del(int id);
	public WorkStudentDetail getWorkStudentDetailById(WorkStudentDetail workStudentDetail);
}
