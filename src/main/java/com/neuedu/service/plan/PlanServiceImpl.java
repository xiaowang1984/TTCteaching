package com.neuedu.service.plan;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.PlanDao;
import com.neuedu.pojo.Plan;

@RestController
@RequestMapping("/plan")
public class PlanServiceImpl implements IplanService {
	@Autowired
	private PlanDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getPlans(Plan plan) {
		// TODO Auto-generated method stub
		plan.setWithPage(0);
		return new ResultData(dao.getPlans(plan),
				dao.getCount(plan), plan.getPageSize(), plan.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Plan plan) {
		// TODO Auto-generated method stub
		return new Message(dao.add(plan));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Plan plan) {
		// TODO Auto-generated method stub
		return new Message(dao.update(plan));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Plan getPlanById(Plan plan) {
		// TODO Auto-generated method stub
		return dao.getPlanById(plan);
	}
	
	
}
