package com.neuedu.service.questions;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.QuestionsDao;
import com.neuedu.pojo.Questions;

@RestController
@RequestMapping("/questions")
public class QuestionsServiceImpl implements IquestionsService {
	@Autowired
	private QuestionsDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getQuestionss(Questions questions) {
		// TODO Auto-generated method stub
		questions.setOrderBy("a.name");
		return new ResultData(dao.getQuestionss(questions),
				dao.getCount(questions), questions.getPageSize(), questions.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Questions questions) {
		// TODO Auto-generated method stub
		return new Message(dao.add(questions));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Questions questions) {
		// TODO Auto-generated method stub
		return new Message(dao.update(questions));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Questions getQuestionsById(Questions questions) {
		// TODO Auto-generated method stub
		return dao.getQuestionsById(questions);
	}
	
	
}
