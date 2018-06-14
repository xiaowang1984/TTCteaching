package com.neuedu.service.arrangeList;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.ArrangeListDao;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;

@RestController
@RequestMapping("/arrangeList")
public class ArrangeListServiceImpl implements IarrangeListService {
	@Autowired
	private ArrangeListDao dao;
	@Override
	@RequestMapping("/list")
	public ResultData getArrangeLists(ArrangeList arrangeList) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getArrangeLists(arrangeList),
				dao.getCount(arrangeList), arrangeList.getPageSize(), arrangeList.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(ArrangeList arrangeList) {
		// TODO Auto-generated method stub
		return new Message(dao.add(arrangeList));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(ArrangeList arrangeList) {
		// TODO Auto-generated method stub
		return new Message(dao.update(arrangeList));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ArrangeList getArrangeListById(ArrangeList arrangeList) {
		// TODO Auto-generated method stub
		return dao.getArrangeListById(arrangeList);
	}

	@Override
	@RequestMapping("/logs")
	public ResultData getLogs(Arrange arrange) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getLogs(arrange),
				dao.getLogCount(arrange), arrange.getPageSize(), arrange.getPageNo());
	}
}
