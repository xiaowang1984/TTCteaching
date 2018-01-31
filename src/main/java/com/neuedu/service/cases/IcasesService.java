package com.neuedu.service.cases;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.Teacher;
import com.neuedu.util.ResultData;

public interface IcasesService {
	public ResultData getCasess(Cases cases);
	public Message add(Cases cases);
	public Message update(Cases cases);
	public Message del(int id);
	public Cases getCasesById(Cases cases);
	public List<Teacher> getProvider(Teacher teacher);
}
