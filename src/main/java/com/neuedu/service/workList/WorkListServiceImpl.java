package com.neuedu.service.workList;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.WorkListDao;
import com.neuedu.pojo.WorkList;

@RestController
@RequestMapping("/workList")
public class WorkListServiceImpl implements IworkListService {
	@Autowired
	private WorkListDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getWorkLists(WorkList workList) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getWorkLists(workList),
				dao.getCount(workList), workList.getPageSize(), workList.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(WorkList workList) {
		// TODO Auto-generated method stub
		return new Message(dao.add(workList));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(WorkList workList) {
		// TODO Auto-generated method stub
		return new Message(dao.update(workList));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public WorkList getWorkListById(WorkList workList) {
		// TODO Auto-generated method stub
		return dao.getWorkListById(workList);
	}
	
	
}
