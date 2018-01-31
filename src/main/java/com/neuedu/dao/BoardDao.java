package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Arrange;

public interface BoardDao {
	public List<Arrange> getArrangesByGid(Integer gId);
}
