package com.neuedu.service.talk;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Talk;
import com.neuedu.util.ResultData;

public interface ItalkService {
	public ResultData getTalks(Talk talk);
	public Message add(Talk talk);
	public Message update(Talk talk);
	public Message del(int id);
	public Talk getTalkById(Talk talk);
}
