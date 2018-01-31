package com.neuedu.service.grade;

import java.util.List;

import com.neuedu.pojo.Grade;
import com.neuedu.util.Message;
import com.neuedu.util.ResultData;

public interface IgradeService {
	public ResultData getGrades(Grade grade);
	public Grade getGrandById(Grade grade);
	public Message add(Grade grade);
	public Message update(Grade grade);
}
