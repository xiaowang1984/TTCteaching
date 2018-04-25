package com.neuedu.service.questions;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Questions;
import com.neuedu.util.ResultData;

public interface IquestionsService {
	public ResultData getQuestionss(Questions questions);
	public Message add(Questions questions);
	public Message update(Questions questions);
	public Message del(int id);
	public Questions getQuestionsById(Questions questions);
}
