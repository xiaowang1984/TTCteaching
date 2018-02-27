package com.neuedu.service.workStudent;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.WorkStudentDao;
import com.neuedu.pojo.WorkStudent;

@RestController
@RequestMapping("/workStudent")
public class WorkStudentServiceImpl implements IworkStudentService {
	@Autowired
	private WorkStudentDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getWorkStudents(WorkStudent workStudent) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getWorkStudents(workStudent),
				dao.getCount(workStudent), workStudent.getPageSize(), workStudent.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(WorkStudent workStudent) {
		// TODO Auto-generated method stub
		return new Message(dao.add(workStudent));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(WorkStudent workStudent) {
		// TODO Auto-generated method stub
		return new Message(dao.update(workStudent));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public WorkStudent getWorkStudentById(WorkStudent workStudent) {
		// TODO Auto-generated method stub
		return dao.getWorkStudentById(workStudent);
	}
	
	
}
