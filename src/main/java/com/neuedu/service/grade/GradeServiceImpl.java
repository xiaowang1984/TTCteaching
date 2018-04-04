package com.neuedu.service.grade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.dao.GradeDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.dao.TeacherDao;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Teacher;
import com.neuedu.util.Message;
import com.neuedu.util.ResultData;

@RestController
@RequestMapping("/grade")
public class GradeServiceImpl implements IgradeService {
	@Resource
	private GradeDao gradeDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private TeacherDao teacherDao;
	@Override
	@RequestMapping("/list")
	public ResultData getGrades(Grade grade) {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<>();
		StringBuilder strParams=new StringBuilder();
		if(grade.getType()!=null){
			params.put("type", grade.getType());
			strParams.append("&type="+grade.getType());
		}
		if(grade.getLecturer()!=null){
			params.put("lecturer", grade.getLecturer());
			strParams.append("&lecturer="+grade.getLecturer());
		}
		if(grade.getManager()!=null){
			params.put("manager", grade.getManager());
			strParams.append("&manager="+grade.getManager());
		}
		if(grade.getIsDel()!=null){
			params.put("isDel", grade.getIsDel());
			strParams.append("&isDel="+grade.getIsDel());
		}
		if(StringUtils.isBlank(grade.getName())){
			grade.setName(null);
		}else{
			params.put("name", grade.getName());
			strParams.append("&name="+grade.getName());
		}
		grade.setOrderBy("start_date desc");
		Teacher teacherQuery=new Teacher();
		teacherQuery.setFields("id,name");
		teacherQuery.setWithPage(0);
		teacherQuery.setWhere("type=0");
		List<Teacher> managers= teacherDao.getTeachers(teacherQuery);
		teacherQuery.setWhere("type=1");
		List<Teacher> lecturers=teacherDao.getTeachers(teacherQuery);
		List<Grade> grades=gradeDao.getGrades(grade);
		for (Grade grade2 : grades) {
/*			grade2.setLecturerName(gradeDao.getTeacher(grade2.getLecturer()));
			grade2.setManagerName(gradeDao.getTeacher(grade2.getManager()));
*/			grade2.setImg(gradeDao.getImgByGid(grade2.getId()));
			Student studentQuery=new Student();
			studentQuery.setGId(grade2.getId());
			grade2.setStuCount(studentDao.getCount(studentQuery)); 
			studentQuery.setWhere("status=3");
			grade2.setOffer(studentDao.getCount(studentQuery));
		}
		ResultData result= new ResultData(grades,
				gradeDao.getCount(grade), grade.getPageSize(), grade.getPageNo());
		Map<String, Object> map=new HashMap<>();
		map.put("manager", managers);
		map.put("lecturer", lecturers);
		map.put("params", params);
		map.put("paramStr", strParams);
		result.setAttr(map);
		System.out.println(grade);
		return result;
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
