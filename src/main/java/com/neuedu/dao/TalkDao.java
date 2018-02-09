package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Student;
import com.neuedu.pojo.Talk;

public interface TalkDao {
	public List<Student> getTalks(Talk talk);
	public int add(Talk talk);
	public int update(Talk talk);
	public int del(int id);
	public Talk getTalkById(Talk talk);
	public int getCount(Talk talk);
}