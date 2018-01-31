package com.neuedu.service.teacher;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.util.Message;
import com.neuedu.util.ResultData;
import com.neuedu.dao.TeacherDao;
import com.neuedu.pojo.PageGradeAdd;
import com.neuedu.pojo.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherServiceImpl implements IteacherService {
	@Autowired
	private TeacherDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getTeachers(Teacher teacher) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getTeachers(teacher),
				dao.getCount(teacher), teacher.getPageSize(), teacher.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Teacher teacher) {
		// TODO Auto-generated method stub
		return new Message(dao.add(teacher));
	}

	@Override
	@RequestMapping("/edit")
	public Message update(Teacher teacher) {
		// TODO Auto-generated method stub
		return new Message(dao.update(teacher));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping("/goEdit")
	public Teacher getTeacherById(Teacher teacher) {
		// TODO Auto-generated method stub
		return dao.getTeacherById(teacher);
	}
	
	@Override
	public int getCount(Teacher teacher) {
		// TODO Auto-generated method stub
		return dao.getCount(teacher);
	}
	
	@RequestMapping("/getTeachers")
	public PageGradeAdd getTeachers(){
		PageGradeAdd gradeAdd=new PageGradeAdd();
		Teacher teacher=new Teacher();
		teacher.setFields("id,name");
		teacher.setWhere("type=1");
		teacher.setWithPage(0);
		gradeAdd.setLecturer(dao.getTeachers(teacher));
		teacher.setWhere("type=0");
		gradeAdd.setManager(dao.getTeachers(teacher));
		return gradeAdd;
	}
}
