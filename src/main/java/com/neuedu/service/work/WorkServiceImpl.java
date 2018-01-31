package com.neuedu.service.work;

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
import com.neuedu.dao.CasesDao;
import com.neuedu.dao.GradeDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.dao.WorkDao;
import com.neuedu.dao.WorkListDao;
import com.neuedu.pojo.Cases;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Work;
import com.neuedu.pojo.WorkList;
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
	private WorkListDao workListDao;
	@Autowired
	private GradeDao gradeDao;
	@Override
	@RequestMapping("/list")
	public WorkView getWorks(Work work) {
		// TODO Auto-generated method stub
		Grade gradeQuery=new Grade();
		gradeQuery.setFields("id,name");
		gradeQuery.setId(work.getGId());
		Grade grade= gradeDao.getGrandById(gradeQuery);
		WorkView workView=new WorkView();
		workView.setGrade(grade);
		work.setIsDel(1);
		ResultData data= new ResultData(dao.getWorks(work),
				dao.getCount(work), work.getPageSize(), work.getPageNo());
		workView.setWorks(data);
		System.out.println(workView.getWorks().getList());
		return workView;
	}

	@Override
	@RequestMapping("/add")
	public Message add(Work work) {
		// TODO Auto-generated method stub
		return new Message(dao.add(work));
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
	
	@Transactional
	@RequestMapping("/save")
	public Message save(Work work,Student student) {
		// TODO Auto-generated method stub
		Integer alId=work.getAlId();
		Work work2=dao.getWorkById(work);
		int result=0;
		if(work2==null){
			student.setWithPage(0);
			List<Student> students=studentDao.getStudents(student);
			for (Student student2 : students) {
				WorkList workList=new WorkList();
				workList.setAlId(work.getAlId());
				workList.setSId(student2.getId());
				workList.setCount(0);
				workList.setIsDel(1);
				result+=workListDao.add(workList);
			}
			result+=dao.add(work);
			return new Message(result);
		}else{
			return new Message(dao.update(work));
		}
		
	}
	
}
