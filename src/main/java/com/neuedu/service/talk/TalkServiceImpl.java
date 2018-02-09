package com.neuedu.service.talk;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.StudentDao;
import com.neuedu.dao.TalkDao;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Talk;

@RestController
@RequestMapping("/talk")
public class TalkServiceImpl implements ItalkService {
	@Autowired
	private TalkDao dao;
	@Resource
	private StudentDao studentDao;
	@Override
	@RequestMapping("/list")
	public ResultData getTalks(Talk talk) {
		// TODO Auto-generated method stub
		talk.setWithPage(1);
		Student student=new Student();
		student.setGId(talk.getGId());
		return new ResultData(dao.getTalks(talk),
				studentDao.getCount(student), talk.getPageSize(), talk.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Talk talk) {
		// TODO Auto-generated method stub
		return new Message(dao.add(talk));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Talk talk) {
		// TODO Auto-generated method stub
		return new Message(dao.update(talk));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Talk getTalkById(Talk talk) {
		// TODO Auto-generated method stub
		return dao.getTalkById(talk);
	}
	
	
}
