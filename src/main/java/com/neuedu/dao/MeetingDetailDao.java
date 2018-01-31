package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.MeetingDetail;

public interface MeetingDetailDao {
	public List<MeetingDetail> getMeetingDetails(MeetingDetail meetingDetail);
	public int add(MeetingDetail meetingDetail);
	public int update(MeetingDetail meetingDetail);
	public int del(int id);
	public MeetingDetail getMeetingDetailById(MeetingDetail meetingDetail);
	public int getCount(MeetingDetail meetingDetail);
}