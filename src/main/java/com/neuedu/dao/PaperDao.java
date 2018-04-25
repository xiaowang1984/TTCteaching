package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Paper;

public interface PaperDao {
	public List<Paper> getPapers(Paper paper);
	public int add(Paper paper);
	public int update(Paper paper);
	public int del(int id);
	public Paper getPaperById(Paper paper);
	public int getCount(Paper paper);
}