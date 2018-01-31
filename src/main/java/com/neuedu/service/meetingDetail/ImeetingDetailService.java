package com.neuedu.service.meetingDetail;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.MeetingDetail;
import com.neuedu.util.ResultData;

public interface ImeetingDetailService {
	public ResultData getMeetingDetails(MeetingDetail meetingDetail);
	public Message add(MeetingDetail meetingDetail);
	public Message update(MeetingDetail meetingDetail);
	public Message del(int id);
	public MeetingDetail getMeetingDetailById(MeetingDetail meetingDetail);
}
