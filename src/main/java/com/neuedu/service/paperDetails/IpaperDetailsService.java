package com.neuedu.service.paperDetails;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.PaperDetails;
import com.neuedu.util.ResultData;

public interface IpaperDetailsService {
	public List<PaperDetails> getPaperDetailss(PaperDetails paperDetails);
	public Message add(PaperDetails paperDetails);
	public Message update(PaperDetails paperDetails);
	public Message del(int id);
	public PaperDetails getPaperDetailsById(PaperDetails paperDetails);
}
