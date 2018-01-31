package com.neuedu.service.meeting;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Meeting;
import com.neuedu.pojo.MeetingDetail;
import com.neuedu.util.ResultData;

public interface ImeetingService {
	public ResultData getMeetings(Meeting meeting);
	public Message add(Meeting meeting,MeetingDetail detail);
	public Message update(Meeting meeting);
	public Message del(int id);
	public Meeting getMeetingById(Meeting meeting);
}
