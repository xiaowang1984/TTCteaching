package com.neuedu.service.exam;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import com.neuedu.util.ResultExam;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.util.Message;
import com.neuedu.dao.ExamDao;
import com.neuedu.dao.ExamDetailsDao;
import com.neuedu.dao.ExamStudentDetailsDao;
import com.neuedu.dao.PaperDao;
import com.neuedu.dao.PaperDetailsDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Exam;
import com.neuedu.pojo.ExamDetails;
import com.neuedu.pojo.ExamStudentDetails;
import com.neuedu.pojo.Options;
import com.neuedu.pojo.Paper;
import com.neuedu.pojo.PaperDetails;
import com.neuedu.pojo.Student;
import com.neuedu.service.paperDetails.IpaperDetailsService;

@RestController
@RequestMapping("/exam")
public class ExamServiceImpl implements IexamService {
	@Autowired
	private ExamDao dao;
	@Resource
	private PaperDao paperDao;
	@Resource
	private StudentDao studentDao;
	public static String STR="3456789ABCDEFGHJKLMNPQRSTUVWXYabcdefghijkmnpqrstuvwxy";
	@Resource
	private IpaperDetailsService paperDetailsService;
	@Resource
	private ExamDetailsDao examDetailsDao;
	@Resource
	private ExamStudentDetailsDao examStudentDetailsDao;
	
	@Override
	@RequestMapping("/list")
	public ResultData getExams(Exam exam) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getExams(exam),
				dao.getCount(exam), exam.getPageSize(), exam.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Exam exam) {
		// TODO Auto-generated method stub
		Random random=new Random();
		char[] c=new char[6];
		for(int i=0;i<c.length;i++){
			c[i]=STR.charAt(random.nextInt(STR.length()-1));
		}
		exam.setNo(new String(c));
		return new Message(dao.add(exam));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Exam exam) {
		// TODO Auto-generated method stub
		return new Message(dao.update(exam));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Exam getExamById(Exam exam) {
		// TODO Auto-generated method stub
		return dao.getExamById(exam);
	}

	@Override
	@RequestMapping("/papers")
	public List<Paper> getPapers() {
		// TODO Auto-generated method stub
		Paper paper=new Paper();
		paper.setWithPage(0);
		paper.setFields("id,name");
		return paperDao.getPapers(paper);
	}

	@Override
	@RequestMapping("/getPaper")
	public ResultExam getPaper(int id, String no) {
		// TODO Auto-generated method stub
		Student studentQuery= new Student();
		studentQuery.setId(id);
		Student student=studentDao.getStudentById(studentQuery);
		if(student==null){
			return new ResultExam(0, "ID号不存在");
		}else{
			Exam exam = dao.getExamByNo(no);
			
			if(exam==null){
				return new ResultExam(0, "考试口令错误");
			}else{
				if(student.getGId().intValue()!=exam.getGId().intValue()){
					return new ResultExam(0, "考试口令错误");
				}else{
					Date now=new Date();
					if(now.getTime()<exam.getStartTime().getTime()){
						return new ResultExam(0, "还未到考试时间");
					}else if(now.getTime()>exam.getEndTime().getTime()){
						return new ResultExam(0, "考试已经结束");
					}else{
						return new ResultExam(1, exam);
					}
				}
			}
		}
	}

	@Override
	@RequestMapping("/examSubmt")
	@Transactional
	public String examSubmit(HttpServletRequest request,Integer sId,Integer eId) {
		// TODO Auto-generated method stub
		int result=0;
		float count=0f;
		float right=0f;
		ExamDetails examDetails=new ExamDetails();
		examDetails.setEId(eId);
		examDetails.setSId(sId);
		result+=examDetailsDao.add(examDetails);
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		Exam examQuery=new Exam();
		examQuery.setId(eId);
		Exam exam= dao.getExamById(examQuery);
		PaperDetails paperDetailsQuery=new PaperDetails();
		paperDetailsQuery.setPId(exam.getPId());
		List<PaperDetails> paperDetailsList = paperDetailsService.getPaperDetailss(paperDetailsQuery);
		for (PaperDetails paperDetails : paperDetailsList) {
			ExamStudentDetails examStudentDetails=new ExamStudentDetails();
			examStudentDetails.setEdId(examDetails.getId());
			examStudentDetails.setTId(paperDetails.getTId());
			if(keySet.contains(String.valueOf(paperDetails.getId())))
				examStudentDetails.setOId(Integer.parseInt(request.getParameter(String.valueOf(paperDetails.getId()))));
			else
				examStudentDetails.setOId(0);
			for (Options options : paperDetails.getOptions()) {
				if(options.getIsRight()==1){
					examStudentDetails.setRId(options.getId());
					break;
				}
			}
			count++;
			if(examStudentDetails.getOId()==examStudentDetails.getRId())
				right++;
			result+=examStudentDetailsDao.add(examStudentDetails);	
		}
		examDetails.setScore(right/count*100);
		result+=examDetailsDao.update(examDetails);
		return String.valueOf(result);
	}
	
	
}
