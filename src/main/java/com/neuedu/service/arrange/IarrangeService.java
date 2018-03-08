package com.neuedu.service.arrange;

import java.util.Date;
import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.util.ResultData;

public interface IarrangeService {
	public ResultData getArranges(Arrange arrange);
	public Message add(Arrange arrange,Date[] dates);
	public Message update(String note,Arrange arrange,ArrangeList arrangeList,Date[] dates);
	public Message del(int id);
	public Arrange getArrangeById(Arrange arrange);
}
