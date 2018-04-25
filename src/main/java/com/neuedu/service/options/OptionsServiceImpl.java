package com.neuedu.service.options;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.OptionsDao;
import com.neuedu.pojo.Options;

@RestController
@RequestMapping("/options")
public class OptionsServiceImpl implements IoptionsService {
	@Autowired
	private OptionsDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getOptionss(Options options) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getOptionss(options),
				dao.getCount(options), options.getPageSize(), options.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Options options) {
		// TODO Auto-generated method stub
		return new Message(dao.add(options));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Options options) {
		// TODO Auto-generated method stub
		return new Message(dao.update(options));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Options getOptionsById(Options options) {
		// TODO Auto-generated method stub
		return dao.getOptionsById(options);
	}
	
	
}
