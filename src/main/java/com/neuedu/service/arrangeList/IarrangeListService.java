package com.neuedu.service.arrangeList;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.util.ResultData;

public interface IarrangeListService {
	public ResultData getArrangeLists(ArrangeList arrangeList);
	public Message add(ArrangeList arrangeList);
	public Message update(ArrangeList arrangeList);
	public Message del(int id);
	public ArrangeList getArrangeListById(ArrangeList arrangeList);
	public ResultData getLogs(Arrange arrange);
}
