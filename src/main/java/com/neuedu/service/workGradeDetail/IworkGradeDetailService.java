package com.neuedu.service.workGradeDetail;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.WorkGradeDetail;
import com.neuedu.util.ResultData;

public interface IworkGradeDetailService {
	public ResultData getWorkGradeDetails(WorkGradeDetail workGradeDetail);
	public Message add(WorkGradeDetail workGradeDetail);
	public Message update(WorkGradeDetail workGradeDetail);
	public Message del(int id);
	public WorkGradeDetail getWorkGradeDetailById(WorkGradeDetail workGradeDetail);
}
