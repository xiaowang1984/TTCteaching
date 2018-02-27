package com.neuedu.service.workGrade;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.WorkGradeDao;
import com.neuedu.pojo.WorkGrade;

@RestController
@RequestMapping("/workGrade")
public class WorkGradeServiceImpl implements IworkGradeService {
	@Autowired
	private WorkGradeDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getWorkGrades(WorkGrade workGrade) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getWorkGrades(workGrade),
				dao.getCount(workGrade), workGrade.getPageSize(), workGrade.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(WorkGrade workGrade) {
		// TODO Auto-generated method stub
		return new Message(dao.add(workGrade));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(WorkGrade workGrade) {
		// TODO Auto-generated method stub
		return new Message(dao.update(workGrade));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public WorkGrade getWorkGradeById(WorkGrade workGrade) {
		// TODO Auto-generated method stub
		return dao.getWorkGradeById(workGrade);
	}
	
	
}
