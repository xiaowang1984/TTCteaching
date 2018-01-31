package com.neuedu.service.plan;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Plan;
import com.neuedu.util.ResultData;

public interface IplanService {
	public ResultData getPlans(Plan plan);
	public Message add(Plan plan);
	public Message update(Plan plan);
	public Message del(int id);
	public Plan getPlanById(Plan plan);
}
