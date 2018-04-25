package com.neuedu.service.examDetails;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.ExamDetailsDao;
import com.neuedu.pojo.ExamDetails;

@RestController
@RequestMapping("/examDetails")
public class ExamDetailsServiceImpl implements IexamDetailsService {
	@Autowired
	private ExamDetailsDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getExamDetailss(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getExamDetailss(examDetails),
				dao.getCount(examDetails), examDetails.getPageSize(), examDetails.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.add(examDetails));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.update(examDetails));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ExamDetails getExamDetailsById(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return dao.getExamDetailsById(examDetails);
	}
	
	
}
