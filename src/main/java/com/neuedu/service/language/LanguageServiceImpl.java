package com.neuedu.service.language;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.LanguageDao;
import com.neuedu.pojo.Language;

@RestController
@RequestMapping("/language")
public class LanguageServiceImpl implements IlanguageService {
	@Autowired
	private LanguageDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getLanguages(Language language) {
		// TODO Auto-generated method stub
		language.setIsDel(1);
		return new ResultData(dao.getLanguages(language),
				dao.getCount(language), language.getPageSize(), language.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Language language) {
		// TODO Auto-generated method stub
		return new Message(dao.add(language));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Language language) {
		// TODO Auto-generated method stub
		return new Message(dao.update(language));
	}

	@Override
	@RequestMapping("/del")
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Language getLanguageById(Language language) {
		// TODO Auto-generated method stub
		return dao.getLanguageById(language);
	}

	@Override
	@RequestMapping("/getList")
	public List<Language> getList(Language language) {
		// TODO Auto-generated method stub
		language.setIsDel(1);
		language.setWithPage(0);
		return dao.getLanguages(language);
	}

	@Override
	@RequestMapping("/getLanguagesAndModules")
	public List<Language> getLanguagesAndModules() {
		// TODO Auto-generated method stub
		return dao.getLanguagesAndModules();
	}
	
	
}
