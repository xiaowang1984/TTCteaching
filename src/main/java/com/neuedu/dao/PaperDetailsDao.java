package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.PaperDetails;

public interface PaperDetailsDao {
	public List<PaperDetails> getPaperDetailss(PaperDetails paperDetails);
	public int add(PaperDetails paperDetails);
	public int update(PaperDetails paperDetails);
	public int del(int id);
	public PaperDetails getPaperDetailsById(PaperDetails paperDetails);
	public int getCount(PaperDetails paperDetails);
}