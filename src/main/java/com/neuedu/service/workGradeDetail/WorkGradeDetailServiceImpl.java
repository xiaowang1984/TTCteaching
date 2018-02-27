package com.neuedu.service.workGradeDetail;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.WorkGradeDetailDao;
import com.neuedu.pojo.WorkGradeDetail;

@RestController
@RequestMapping("/workGradeDetail")
public class WorkGradeDetailServiceImpl implements IworkGradeDetailService {
	@Autowired
	private WorkGradeDetailDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getWorkGradeDetails(WorkGradeDetail workGradeDetail) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getWorkGradeDetails(workGradeDetail),
				dao.getCount(workGradeDetail), workGradeDetail.getPageSize(), workGradeDetail.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(WorkGradeDetail workGradeDetail) {
		// TODO Auto-generated method stub
		return new Message(dao.add(workGradeDetail));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(WorkGradeDetail workGradeDetail) {
		// TODO Auto-generated method stub
		return new Message(dao.update(workGradeDetail));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public WorkGradeDetail getWorkGradeDetailById(WorkGradeDetail workGradeDetail) {
		// TODO Auto-generated method stub
		return dao.getWorkGradeDetailById(workGradeDetail);
	}
	
	
}
