package com.neuedu.service.work;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.util.Message;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.dao.CasesDao;
import com.neuedu.dao.GradeDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.dao.WorkDao;
import com.neuedu.dao.WorkGradeDao;
import com.neuedu.dao.WorkStudentDao;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Progress;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Work;
import com.neuedu.pojo.WorkGrade;
import com.neuedu.pojo.WorkStudent;
import com.neuedu.pojo.WorkView;

@RestController
@RequestMapping("/work")
public class WorkServiceImpl implements IworkService {
	@Autowired
	private WorkDao dao;
	@Autowired
	private CasesDao casesDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private GradeDao gradeDao;
	@Autowired
	private WorkGradeDao workGradeDao;
	@Autowired
	private WorkStudentDao workStudentDao;
	@Override
	@RequestMapping("/list")
	public WorkView getWorks(Work work) {
		// TODO Auto-generated method stub
		Student studentQuery=new Student();
		studentQuery.setGId(work.getGId());
		Grade gradeQuery=new Grade();
		gradeQuery.setFields("id,name,type");
		gradeQuery.setId(work.getGId());
		Grade grade= gradeDao.getGrandById(gradeQuery);
		grade.setStuCount(studentDao.getCount(studentQuery));
		WorkView workView=new WorkView();
		workView.setGrade(grade);
		work.setIsDel(1);
		ResultData data= new ResultData(dao.getWorks(work),
				dao.getCount(work), work.getPageSize(), work.getPageNo());
		workView.setWorks(data);
		progress();
		return workView;
	}

	@Override
	@RequestMapping("/add")
	@Transactional
	public Message add(Work work) {
		// TODO Auto-generated method stub
		int result=dao.add(work);
		WorkGrade workGrade=new WorkGrade();
		workGrade.setCount(0);
		workGrade.setWId(work.getId());
		workGrade.setIsDel(1);
		result+=workGradeDao.add(workGrade);
		Student studentQuery=new Student();
		studentQuery.setFields("id");
		studentQuery.setGId(work.getGId());
		studentQuery.setWithPage(0);
		List<Student> students=studentDao.getStudents(studentQuery);
		for (Student student : students) {
			WorkStudent workStudent=new WorkStudent();
			workStudent.setCount(0);
			workStudent.setIsDel(1);
			workStudent.setWgId(work.getId());
			workStudent.setSId(student.getId());
			result+=workStudentDao.add(workStudent);
		}
		return new Message(result);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Work work) {
		// TODO Auto-generated method stub
		return new Message(dao.update(work));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Work getWorkById(Work work) {
		// TODO Auto-generated method stub
		Work result= dao.getWorkById(work);
		return dao.getWorkById(work);
	}

	@Override
	@RequestMapping("/getCases")
	public List<Cases> getCases(Cases cases) {
		// TODO Auto-generated method stub
		cases.setWithPage(0);
		return casesDao.getCasess(cases);
	}

	@Override
	public void progress() {
		// TODO Auto-generated method stub
		Date dat=new Date();
		List<Work> works=dao.getWorksByDat(dat);
		RestTemplate restTemplate=new RestTemplate();
		for (Work work : works) {
			WorkStudent workStudentQuery=new WorkStudent();
			workStudentQuery.setWhere("wg_id="+work.getId());
			List<WorkStudent> workStudents=workStudentDao.getWorkStudents(workStudentQuery);
			for (WorkStudent workStudent : workStudents) {
				Student studentQuery=new Student();
				studentQuery.setId(workStudent.getSId());
				Student student=studentDao.getStudentById(studentQuery);
				if(StringUtils.isNotBlank(student.getGit())){
					String str="";
					int count=0;
					System.out.println("https://api.github.com/repos/"+student.getGit()+"/"+work.getName()+"/stats/contributors");
					while(count<3){
						try{
							str= restTemplate.getForObject("https://api.github.com/repos/"+student.getGit()+"/"+work.getName()+"/stats/contributors",String.class);
							List<Progress> progress= JSONObject.parseArray(str, Progress.class);
							System.out.println("------------------------");
							System.out.println(progress);
							break;
						}catch(Exception ex){
							count++;
						}
					}
				}
			}
		}
		
		
		
		
	}

	
}
