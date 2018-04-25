package com.neuedu.service.paper;

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
import com.neuedu.dao.PaperDao;
import com.neuedu.dao.PaperDetailsDao;
import com.neuedu.dao.QuestionsDao;
import com.neuedu.dao.TestsDao;
import com.neuedu.pojo.Paper;
import com.neuedu.pojo.PaperDetails;
import com.neuedu.pojo.Questions;
import com.neuedu.pojo.Tests;

@RestController
@RequestMapping("/paper")
public class PaperServiceImpl implements IpaperService {
	@Autowired
	private PaperDao dao;
	@Resource
	private QuestionsDao questionDao;
	@Resource
	private TestsDao testsDao;
	@Resource
	private PaperDetailsDao paperDetailsDao;
	@Override
	@RequestMapping("/list")
	public ResultData getPapers(Paper paper) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getPapers(paper),
				dao.getCount(paper), paper.getPageSize(), paper.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	@Transactional
	public Message add(Paper paper,int[] ids) {
		// TODO Auto-generated method stub
		int result=0;
		result=dao.add(paper);
		for (int i : ids) {
			PaperDetails paperDetails=new PaperDetails();
			paperDetails.setPId(paper.getId());
			paperDetails.setTId(i);
			result=paperDetailsDao.add(paperDetails);
		}
		return new Message(result);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Paper paper) {
		// TODO Auto-generated method stub
		return new Message(dao.update(paper));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Paper getPaperById(Paper paper) {
		// TODO Auto-generated method stub
		return dao.getPaperById(paper);
	}
	
	@RequestMapping("/questions")
	public List<Questions> getQuestions(){
		Questions question=new Questions();
		question.setWithPage(0);
		question.setIsDel(1);
		return questionDao.getQuestionss(question);
	}
	@RequestMapping("/tests")
	public List<Tests> getTests(Tests test){
		test.setWithPage(0);
		return testsDao.getTestss(test);
	}
}
