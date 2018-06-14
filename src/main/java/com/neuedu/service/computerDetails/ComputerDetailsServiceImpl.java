package com.neuedu.service.computerDetails;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.ComputerDetailsDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.ComputerDetails;
import com.neuedu.pojo.Student;

@RestController
@RequestMapping("/computerDetails")
public class ComputerDetailsServiceImpl implements IcomputerDetailsService {
	@Autowired
	private ComputerDetailsDao dao;
	@Autowired
	private StudentDao studentDao;
	@Override
	@RequestMapping("/list")
	public ResultData getComputerDetailss(ComputerDetails computerDetails) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getComputerDetailss(computerDetails),
				dao.getCount(computerDetails), computerDetails.getPageSize(), computerDetails.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(ComputerDetails computerDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.add(computerDetails));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(ComputerDetails computerDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.update(computerDetails));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ComputerDetails getComputerDetailsById(ComputerDetails computerDetails) {
		// TODO Auto-generated method stub
		return dao.getComputerDetailsById(computerDetails);
	}

	@Override
	@RequestMapping("/getStudents")
	public List<Student> getStudents(int gId) {
		// TODO Auto-generated method stub
		Student studentQuery=new Student();
		studentQuery.setGId(gId);
		studentQuery.setWithPage(0);
		studentQuery.setFields("id,name");
		studentQuery.setStatus(1);
		List<Student> students= studentDao.getStudents(studentQuery);
		return students;
	}
	
	
}
