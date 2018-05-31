package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Options;

public interface OptionsDao {
	public List<Options> getOptionss(Options options);
	public int add(Options options);
	public int update(Options options);
	public int del(int id);
	public int delByTid(int id);
	public Options getOptionsById(Options options);
	public int getCount(Options options);
}