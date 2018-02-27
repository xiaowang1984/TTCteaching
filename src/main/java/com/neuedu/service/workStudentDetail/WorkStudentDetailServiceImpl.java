package com.neuedu.service.workStudentDetail;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.WorkStudentDetailDao;
import com.neuedu.pojo.WorkStudentDetail;

@RestController
@RequestMapping("/workStudentDetail")
public class WorkStudentDetailServiceImpl implements IworkStudentDetailService {
	@Autowired
	private WorkStudentDetailDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getWorkStudentDetails(WorkStudentDetail workStudentDetail) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getWorkStudentDetails(workStudentDetail),
				dao.getCount(workStudentDetail), workStudentDetail.getPageSize(), workStudentDetail.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(WorkStudentDetail workStudentDetail) {
		// TODO Auto-generated method stub
		return new Message(dao.add(workStudentDetail));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(WorkStudentDetail workStudentDetail) {
		// TODO Auto-generated method stub
		return new Message(dao.update(workStudentDetail));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public WorkStudentDetail getWorkStudentDetailById(WorkStudentDetail workStudentDetail) {
		// TODO Auto-generated method stub
		return dao.getWorkStudentDetailById(workStudentDetail);
	}
	
	
}
