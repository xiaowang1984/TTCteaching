package com.neuedu.service.workGrade;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.WorkGrade;
import com.neuedu.util.ResultData;

public interface IworkGradeService {
	public ResultData getWorkGrades(WorkGrade workGrade);
	public Message add(WorkGrade workGrade);
	public Message update(WorkGrade workGrade);
	public Message del(int id);
	public WorkGrade getWorkGradeById(WorkGrade workGrade);
}
