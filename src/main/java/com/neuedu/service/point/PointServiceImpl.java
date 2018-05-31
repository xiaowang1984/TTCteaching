package com.neuedu.service.point;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.PointDao;
import com.neuedu.pojo.Point;

@RestController
@RequestMapping("/point")
public class PointServiceImpl implements IpointService {
	@Autowired
	private PointDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getPoints(Point point) {
		// TODO Auto-generated method stub
		point.setIsDel(1);
		return new ResultData(dao.getPoints(point),
				dao.getCount(point), point.getPageSize(), point.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Point point) {
		// TODO Auto-generated method stub
		return new Message(dao.add(point));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Point point) {
		// TODO Auto-generated method stub
		return new Message(dao.update(point));
	}

	@Override
	@RequestMapping("/del")
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Point getPointById(Point point) {
		// TODO Auto-generated method stub
		return dao.getPointById(point);
	}
	
	
}
