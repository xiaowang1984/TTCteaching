package com.neuedu.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.dao.ArrangeDao;
import com.neuedu.dao.BoardDao;
import com.neuedu.dao.GradeDao;
import com.neuedu.dao.PlanDao;
import com.neuedu.dao.TeacherDao;
import com.neuedu.pageBean.Board;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Teacher;

@RestController
@RequestMapping("/board")
public class BoardServiceImpl implements IboardService {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private GradeDao gradeDao;
	@Autowired
	private TeacherDao teacherDao;
	@Override
	@RequestMapping("/list")
	public Board getArrangesByGid(Integer gId) {
		// TODO Auto-generated method stub
		List<Arrange> arranges=boardDao.getArrangesByGid(gId);
		Grade gradeQuery=new Grade();
		gradeQuery.setId(gId);
		Grade grade=gradeDao.getGrandById(gradeQuery);
		Board board=new Board();
		board.setArranges(arranges);
		board.setGrade(grade);
		Teacher teacherQuery=new Teacher();
		teacherQuery.setFields("name");
		teacherQuery.setId(grade.getLecturer());
		grade.setLecturerName(teacherDao.getTeacherById(teacherQuery).getName());
		teacherQuery.setId(grade.getManager());
		grade.setManagerName(teacherDao.getTeacherById(teacherQuery).getName());
		return board;
	}

}
