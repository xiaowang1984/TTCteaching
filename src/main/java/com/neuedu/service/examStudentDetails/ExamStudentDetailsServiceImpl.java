package com.neuedu.service.examStudentDetails;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.ExamStudentDetailsDao;
import com.neuedu.pojo.ExamStudentDetails;

@RestController
@RequestMapping("/examStudentDetails")
public class ExamStudentDetailsServiceImpl implements IexamStudentDetailsService {
	@Autowired
	private ExamStudentDetailsDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getExamStudentDetailss(ExamStudentDetails examStudentDetails) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getExamStudentDetailss(examStudentDetails),
				dao.getCount(examStudentDetails), examStudentDetails.getPageSize(), examStudentDetails.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(ExamStudentDetails examStudentDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.add(examStudentDetails));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(ExamStudentDetails examStudentDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.update(examStudentDetails));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ExamStudentDetails getExamStudentDetailsById(ExamStudentDetails examStudentDetails) {
		// TODO Auto-generated method stub
		return dao.getExamStudentDetailsById(examStudentDetails);
	}
	
	
}
