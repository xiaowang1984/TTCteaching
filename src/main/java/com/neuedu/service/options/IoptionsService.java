package com.neuedu.service.options;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Options;
import com.neuedu.util.ResultData;

public interface IoptionsService {
	public ResultData getOptionss(Options options);
	public Message add(Options options);
	public Message update(Options options);
	public Message del(int id);
	public Options getOptionsById(Options options);
}
