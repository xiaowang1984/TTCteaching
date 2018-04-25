package com.neuedu.service.paper;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Paper;
import com.neuedu.util.ResultData;

public interface IpaperService {
	public ResultData getPapers(Paper paper);
	public Message add(Paper paper,int[] ids);
	public Message update(Paper paper);
	public Message del(int id);
	public Paper getPaperById(Paper paper);
}
