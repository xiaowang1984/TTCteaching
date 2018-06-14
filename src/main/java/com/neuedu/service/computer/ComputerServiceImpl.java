package com.neuedu.service.computer;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.util.Message;
import com.neuedu.dao.ComputerDao;
import com.neuedu.dao.ComputerDetailsDao;
import com.neuedu.dao.InterviewDetailsDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Computer;
import com.neuedu.pojo.ComputerDetails;
import com.neuedu.pojo.Interview;
import com.neuedu.pojo.InterviewDetails;
import com.neuedu.pojo.Student;

@RestController
@RequestMapping("/computer")
public class ComputerServiceImpl implements IcomputerService {
	@Autowired
	private ComputerDao dao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ComputerDetailsDao computerDetailsDao;
	@Override
	@RequestMapping("/list")
	public ResultData getComputers(Computer computer) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getComputers(computer),
				dao.getCount(computer), computer.getPageSize(), computer.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	@Transactional
	public Message add(Computer computer) {
		// TODO Auto-generated method stub
		int result=0;
		result=dao.add(computer);
		Student studentQuery=new Student();
		studentQuery.setGId(computer.getGId());
		studentQuery.setWithPage(0);
		studentQuery.setFields("id");
		studentQuery.setStatus(1);
		List<Student> students= studentDao.getStudents(studentQuery);
		for (Student student : students) {
			ComputerDetails computerDetails=new ComputerDetails();
			computerDetails.setIId(computer.getId());
			computerDetails.setSId(student.getId());
			computerDetails.setSkill(-1);
			result=computerDetailsDao.add(computerDetails);
		}
		return new Message(result);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Computer computer) {
		// TODO Auto-generated method stub
		return new Message(dao.update(computer));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Computer getComputerById(Computer computer) {
		// TODO Auto-generated method stub
		return dao.getComputerById(computer);
	}

	@Override
	@RequestMapping("/getReport")
	public List<Computer> getReport(Computer computer) {
		// TODO Auto-generated method stub
		computer.setWithPage(0);
		computer.setOrderBy("id asc");
		return dao.getReport(computer);
	}
	
	
}
