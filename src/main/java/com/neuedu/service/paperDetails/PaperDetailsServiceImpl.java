package com.neuedu.service.paperDetails;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.PaperDetailsDao;
import com.neuedu.dao.QuestionsDao;
import com.neuedu.pojo.PaperDetails;
import com.neuedu.pojo.Questions;

@RestController
@RequestMapping("/paperDetails")
public class PaperDetailsServiceImpl implements IpaperDetailsService {
	@Autowired
	private PaperDetailsDao dao;
	
	@Override
	@RequestMapping("/list")
	public List<PaperDetails> getPaperDetailss(PaperDetails paperDetails) {
		// TODO Auto-generated method stub
		paperDetails.setWithPage(0);
		 return dao.getPaperDetailss(paperDetails);
				
	}

	@Override
	@RequestMapping("/add")
	public Message add(PaperDetails paperDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.add(paperDetails));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(PaperDetails paperDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.update(paperDetails));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public PaperDetails getPaperDetailsById(PaperDetails paperDetails) {
		// TODO Auto-generated method stub
		return dao.getPaperDetailsById(paperDetails);
	}
	
	
	
}
