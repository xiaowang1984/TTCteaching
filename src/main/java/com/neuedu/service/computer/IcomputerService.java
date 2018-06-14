package com.neuedu.service.computer;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Computer;
import com.neuedu.pojo.Interview;
import com.neuedu.util.ResultData;

public interface IcomputerService {
	public ResultData getComputers(Computer computer);
	public Message add(Computer computer);
	public Message update(Computer computer);
	public Message del(int id);
	public Computer getComputerById(Computer computer);
	public List<Computer> getReport(Computer computer);
}
