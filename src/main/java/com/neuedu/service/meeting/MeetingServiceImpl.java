package com.neuedu.service.meeting;

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
import com.neuedu.dao.MeetingDao;
import com.neuedu.dao.MeetingDetailDao;
import com.neuedu.pojo.Meeting;
import com.neuedu.pojo.MeetingDetail;

@RestController
@RequestMapping("/meeting")
public class MeetingServiceImpl implements ImeetingService {
	@Autowired
	private MeetingDao dao;
	@Autowired
	private MeetingDetailDao detailDao;
	@Override
	@RequestMapping("/list")
	public ResultData getMeetings(Meeting meeting) {
		// TODO Auto-generated method stub
		meeting.setPageSize(5);
		meeting.setOrderBy("date desc");
		return new ResultData(dao.getMeetings(meeting),
				dao.getCount(meeting), meeting.getPageSize(), meeting.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	@Transactional
	public Message add(Meeting meeting,MeetingDetail detail) {
		// TODO Auto-generated method stub
		int result=0;
		result+=dao.add(meeting);
		String[] split = detail.getProblem().split("\n");
		for (String string : split) {
			MeetingDetail meetingDetail=new MeetingDetail();
			meetingDetail.setMId(meeting.getId());
			meetingDetail.setProblem(string);
			result+=detailDao.add(meetingDetail);
		}
		return new Message(result);
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Meeting meeting) {
		// TODO Auto-generated method stub
		return new Message(dao.update(meeting));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Meeting getMeetingById(Meeting meeting) {
		// TODO Auto-generated method stub
		return dao.getMeetingById(meeting);
	}
	
	
}
