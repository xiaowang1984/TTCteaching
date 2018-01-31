package com.neuedu.service.meetingDetail;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import com.neuedu.util.Message;
import com.neuedu.dao.MeetingDetailDao;
import com.neuedu.pojo.MeetingDetail;

@RestController
@RequestMapping("/meetingDetail")
public class MeetingDetailServiceImpl implements ImeetingDetailService {
	@Autowired
	private MeetingDetailDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getMeetingDetails(MeetingDetail meetingDetail) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getMeetingDetails(meetingDetail),
				dao.getCount(meetingDetail), meetingDetail.getPageSize(), meetingDetail.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(MeetingDetail meetingDetail) {
		// TODO Auto-generated method stub
		return new Message(dao.add(meetingDetail));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(MeetingDetail meetingDetail) {
		// TODO Auto-generated method stub
		return new Message(dao.update(meetingDetail));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public MeetingDetail getMeetingDetailById(MeetingDetail meetingDetail) {
		// TODO Auto-generated method stub
		return dao.getMeetingDetailById(meetingDetail);
	}
	
	
}
