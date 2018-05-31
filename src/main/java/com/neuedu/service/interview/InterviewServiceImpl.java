package com.neuedu.service.interview;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.util.Message;
import com.neuedu.dao.InterviewDao;
import com.neuedu.dao.InterviewDetailsDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.Student;

@RestController
@RequestMapping("/interview")
public class InterviewServiceImpl implements IinterviewService {
	@Autowired
	private InterviewDao dao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private InterviewDetailsDao interviewDetailsDao;
	@Override
	@RequestMapping("/list")
	public ResultData getInterviews(Interview interview) {
		// TODO Auto-generated method stub
		interview.setWithPage(0);
		interview.setOrderBy("id asc");
		return new ResultData(dao.getInterviews(interview),
				dao.getCount(interview), interview.getPageSize(), interview.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	@Transactional
	public Message add(Interview interview) {
		// TODO Auto-generated method stub
		int result=0;
		result=dao.add(interview);
		Student studentQuery=new Student();
		studentQuery.setGId(interview.getGId());
		studentQuery.setWithPage(0);
		studentQuery.setFields("id");
		studentQuery.setStatus(1);
		List<Student> students= studentDao.getStudents(studentQuery);
		for (Student student : students) {
			InterviewDetails interviewDetails=new InterviewDetails();
			interviewDetails.setIId(interview.getId());
			interviewDetails.setSId(student.getId());
			interviewDetails.setSkill(-1);
			interviewDetails.setExpress(-1);
			result=interviewDetailsDao.add(interviewDetails);
		}
		return new Message(result);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Interview interview,int iId) {
		// TODO Auto-generated method stub
		interview.setId(iId);
		return new Message(dao.update(interview));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Interview getInterviewById(Interview interview) {
		// TODO Auto-generated method stub
		return dao.getInterviewById(interview);
	}

	@Override
	@RequestMapping("/getReport")
	public List<Interview> getReport(Interview interview) {
		// TODO Auto-generated method stub
		interview.setWithPage(0);
		interview.setOrderBy("id asc");
		return dao.getReport(interview);
	}
	
	
}
