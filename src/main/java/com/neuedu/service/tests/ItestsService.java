package com.neuedu.service.tests;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Tests;
import com.neuedu.util.ResultData;

public interface ItestsService {
	public ResultData getTestss(Tests tests);
	public Message add(Tests tests,String a,String b,String c,String d,String e,String right);
	public Message update(Tests tests);
	public Message del(int id);
	public Tests getTestsById(Tests tests);
}
