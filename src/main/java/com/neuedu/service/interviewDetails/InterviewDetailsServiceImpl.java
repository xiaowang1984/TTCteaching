package com.neuedu.service.interviewDetails;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.InterviewDetailsDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.Student;

@RestController
@RequestMapping("/interviewDetails")
public class InterviewDetailsServiceImpl implements IinterviewDetailsService {
	@Autowired
	private InterviewDetailsDao dao;
	@Autowired
	private StudentDao studentDao;
	@Override
	@RequestMapping("/list")
	public ResultData getInterviewDetailss(InterviewDetails interviewDetails) {
		// TODO Auto-generated method stub
		interviewDetails.setWithPage(0);
		interviewDetails.setOrderBy("id asc");
		return new ResultData(dao.getInterviewDetailss(interviewDetails),
				dao.getCount(interviewDetails), interviewDetails.getPageSize(), interviewDetails.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(InterviewDetails interviewDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.add(interviewDetails));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(InterviewDetails interviewDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.update(interviewDetails));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public InterviewDetails getInterviewDetailsById(InterviewDetails interviewDetails) {
		// TODO Auto-generated method stub
		return dao.getInterviewDetailsById(interviewDetails);
	}
	
	@RequestMapping("/getStudents")
	public List<Student> getStudents(int gId){
		Student studentQuery=new Student();
		studentQuery.setGId(gId);
		studentQuery.setWithPage(0);
		studentQuery.setFields("id,name");
		studentQuery.setStatus(1);
		List<Student> students= studentDao.getStudents(studentQuery);
		return students;
	}
	
}
