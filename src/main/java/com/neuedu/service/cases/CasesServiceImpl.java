package com.neuedu.service.cases;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.CasesDao;
import com.neuedu.dao.TeacherDao;
import com.neuedu.dao.WorkDao;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.Teacher;
import com.neuedu.pojo.Work;

@RestController
@RequestMapping("/cases")
public class CasesServiceImpl implements IcasesService {
	@Autowired
	private CasesDao dao;
	@Autowired
	private TeacherDao teacherDao;
	@Override
	@RequestMapping("/list")
	public ResultData getCasess(Cases cases) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getCasess(cases),
				dao.getCount(cases), cases.getPageSize(), cases.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Cases cases) {
		// TODO Auto-generated method stub
		return new Message(dao.add(cases));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Cases cases) {
		// TODO Auto-generated method stub
		return new Message(dao.update(cases));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Cases getCasesById(Cases cases) {
		// TODO Auto-generated method stub
		return dao.getCasesById(cases);
	}

	@Override
	@RequestMapping("/provider")
	public List<Teacher> getProvider(Teacher teacher) {
		// TODO Auto-generated method stub
		teacher.setWithPage(0);
		teacher.setFields("id,name");
		teacher.setWhere("is_del=1 and type=1");
		return teacherDao.getTeachers(teacher);
	}
	
	

	
	
}
