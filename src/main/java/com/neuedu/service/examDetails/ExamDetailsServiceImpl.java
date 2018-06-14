package com.neuedu.service.examDetails;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.ExamDetailsDao;
import com.neuedu.dao.PointDao;
import com.neuedu.pojo.ExamDetails;
import com.neuedu.pojo.ExamStudentDetails;
import com.neuedu.pojo.Options;
import com.neuedu.pojo.Point;

@RestController
@RequestMapping("/examDetails")
public class ExamDetailsServiceImpl implements IexamDetailsService {
	@Autowired
	private ExamDetailsDao dao;
	@Resource
	private PointDao pointDao;
	@Override
	@RequestMapping("/list")
	public ResultData getExamDetailss(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getExamDetailss(examDetails),
				dao.getCount(examDetails), examDetails.getPageSize(), examDetails.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.add(examDetails));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		return new Message(dao.update(examDetails));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ExamDetails getExamDetailsById(ExamDetails examDetails) {
		// TODO Auto-generated method stub
		ExamDetails result=dao.getExamDetailsById(examDetails);
		for(ExamStudentDetails details:result.getExamStudentDetails() ){
			Options option=new Options();
			List<Point> points=new ArrayList<>();
			if(StringUtils.isNotBlank(details.getSkill()) ){
				String[] split = details.getSkill().split("\\,");
				for (String str : split) {
					Point pointQuery=new Point();
					pointQuery.setId(Integer.parseInt(str));
					pointQuery.setFields("id,name");
					Point point= pointDao.getPointById(pointQuery);
					points.add(point);
				}
			}
			details.setPoint(points);
		}
		return result;
	}
	
	
}
