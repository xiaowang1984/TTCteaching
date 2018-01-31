package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Meeting;

public interface MeetingDao {
	public List<Meeting> getMeetings(Meeting meeting);
	public int add(Meeting meeting);
	public int update(Meeting meeting);
	public int del(int id);
	public Meeting getMeetingById(Meeting meeting);
	public int getCount(Meeting meeting);
}