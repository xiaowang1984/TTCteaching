package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Questions;

public interface QuestionsDao {
	public List<Questions> getQuestionss(Questions questions);
	public int add(Questions questions);
	public int update(Questions questions);
	public int del(int id);
	public Questions getQuestionsById(Questions questions);
	public int getCount(Questions questions);
}