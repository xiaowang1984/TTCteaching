package com.neuedu.service.module;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.ModuleDao;
import com.neuedu.pojo.Module;

@RestController
@RequestMapping("/module")
public class ModuleServiceImpl implements ImoduleService {
	@Autowired
	private ModuleDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getModules(Module module) {
		// TODO Auto-generated method stub
		module.setIsDel(1);
		return new ResultData(dao.getModules(module),
				dao.getCount(module), module.getPageSize(), module.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Module module) {
		// TODO Auto-generated method stub
		return new Message(dao.add(module));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Module module) {
		// TODO Auto-generated method stub
		return new Message(dao.update(module));
	}

	@Override
	@RequestMapping("/del")
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Module getModuleById(Module module) {
		// TODO Auto-generated method stub
		return dao.getModuleById(module);
	}
	
	
}
