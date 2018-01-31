package com.neuedu.service.grade;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.dao.GradeDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;
import com.neuedu.util.Message;
import com.neuedu.util.ResultData;

@RestController
@RequestMapping("/grade")
public class GradeServiceImpl implements IgradeService {
	@Resource
	private GradeDao gradeDao;
	@Resource
	private StudentDao studentDao;
	@Override
	@RequestMapping("/list")
	public ResultData getGrades(Grade grade) {
		// TODO Auto-generated method stub
		grade.setOrderBy("start_date desc");
		List<Grade> grades=gradeDao.getGrades(grade);
		for (Grade grade2 : grades) {
			grade2.setLecturerName(gradeDao.getTeacher(grade2.getLecturer()));
			grade2.setManagerName(gradeDao.getTeacher(grade2.getManager()));
			grade2.setImg(gradeDao.getImgByGid(grade2.getId()));
			Student studentQuery=new Student();
			studentQuery.setGId(grade2.getId());
			grade2.setStuCount(studentDao.getCount(studentQuery)); 
			studentQuery.setWhere("status=3");
			grade2.setOffer(studentDao.getCount(studentQuery));
		}
		return new ResultData(grades,
				gradeDao.getCount(grade), grade.getPageSize(), grade.getPageNo());
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Grade getGrandById(Grade grade) {
		// TODO Auto-generated method stub
		Grade grade2=gradeDao.getGrandById(grade);
		grade2.setLecturerName(gradeDao.getTeacher(grade2.getLecturer()));
		grade2.setManagerName(gradeDao.getTeacher(grade2.getManager()));
		return grade2;
	}

	@Override
	@RequestMapping("/add")
	public Message add(Grade grade) {
		// TODO Auto-generated method stub
		return new Message(gradeDao.add(grade));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Grade grade) {
		// TODO Auto-generated method stub
		return new Message(gradeDao.update(grade));
	}
}
