package com.neuedu.service.workList;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.WorkList;
import com.neuedu.util.ResultData;

public interface IworkListService {
	public ResultData getWorkLists(WorkList workList);
	public Message add(WorkList workList);
	public Message update(WorkList workList);
	public Message del(int id);
	public WorkList getWorkListById(WorkList workList);
}
