package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.ComputerDetails;

public interface ComputerDetailsDao {
	public List<ComputerDetails> getComputerDetailss(ComputerDetails computerDetails);
	public int add(ComputerDetails computerDetails);
	public int update(ComputerDetails computerDetails);
	public int del(int id);
	public ComputerDetails getComputerDetailsById(ComputerDetails computerDetails);
	public int getCount(ComputerDetails computerDetails);
}