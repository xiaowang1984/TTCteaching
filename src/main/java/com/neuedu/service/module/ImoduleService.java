package com.neuedu.service.module;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Module;
import com.neuedu.util.ResultData;

public interface ImoduleService {
	public ResultData getModules(Module module);
	public Message add(Module module);
	public Message update(Module module);
	public Message del(int id);
	public Module getModuleById(Module module);
}
