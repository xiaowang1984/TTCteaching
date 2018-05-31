package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.InterviewDetails;

public interface InterviewDetailsDao {
	public List<InterviewDetails> getInterviewDetailss(InterviewDetails interviewDetails);
	public int add(InterviewDetails interviewDetails);
	public int update(InterviewDetails interviewDetails);
	public int del(int id);
	public InterviewDetails getInterviewDetailsById(InterviewDetails interviewDetails);
	public int getCount(InterviewDetails interviewDetails);
}