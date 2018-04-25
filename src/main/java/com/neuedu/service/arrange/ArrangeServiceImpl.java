package com.neuedu.service.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.neuedu.dao.ArrangeDao;
import com.neuedu.dao.ArrangeListDao;
import com.neuedu.dao.GradeDao;
import com.neuedu.dao.TeacherDao;
import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.ArrangeList;
import com.neuedu.pojo.Grade;

@RestController
@RequestMapping("/arrange")
public class ArrangeServiceImpl implements IarrangeService {
	@Autowired
	private ArrangeDao dao;
	@Autowired
	private ArrangeListDao arrangeListDao;
	@Autowired
	private GradeDao gradeDao;
	@Override
	@RequestMapping("/list")
	public ResultData getArranges(Arrange arrange) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getArranges(arrange),
				dao.getCount(arrange), arrange.getPageSize(), arrange.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	@Transactional
	public Message add(Arrange arrange,Date[] dates) {
		// TODO Auto-generated method stub
		Grade gradeQuery=new Grade();
		gradeQuery.setId(arrange.getGId());
		Grade grade=gradeDao.getGrandById(gradeQuery);
		arrange.setTId(grade.getLecturer());
		int result=dao.add(arrange);
		for (Date date : dates) {
			ArrangeList arrangeList=new ArrangeList();
			arrangeList.setAId(arrange.getId());
			arrangeList.setDate(date);
			result+=arrangeListDao.add(arrangeList);
		}
		
		return new Message(result);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(String note, Arrange arrange, ArrangeList arrangeList,Date[] dates) {
		// TODO Auto-generated method stub
		int result=0;
		arrangeList.setWithPage(0);
		arrangeList.setAId(arrange.getId());
		dao.update(arrange);
		List<ArrangeList> arrangeLists = arrangeListDao.getArrangeLists(arrangeList);
		List<Date> old=new ArrayList<>(arrangeLists.size());
		
		for (ArrangeList al : arrangeLists) {
			old.add(al.getDate());
			if(!Arrays.asList(dates).contains(al.getDate())){
				result+=arrangeListDao.del(al.getId());
			}
		}
		for (Date date : dates) {
			if(!old.contains(date)){
				ArrangeList arl=new ArrangeList();
				arl.setAId(arrangeList.getAId());
				arl.setDate(date);
				result+=arrangeListDao.add(arl);
			}
		}
		return new Message(result);
	}

	@Override
	@Transactional
	@RequestMapping("/del")
	public Message del(int id) {
		// TODO Auto-generated method stub
		int i=dao.del(id);
		i+=arrangeListDao.delByAId(id);
		return new Message(i);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Arrange getArrangeById(Arrange arrange) {
		// TODO Auto-generated method stub
		return dao.getArrangeById(arrange);
	}
	
	
}
