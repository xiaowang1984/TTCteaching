package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Computer;
import com.neuedu.pojo.Interview;

public interface ComputerDao {
	public List<Computer> getComputers(Computer computer);
	public int add(Computer computer);
	public int update(Computer computer);
	public int del(int id);
	public Computer getComputerById(Computer computer);
	public int getCount(Computer computer);
	public List<Computer> getReport(Computer computer);
}