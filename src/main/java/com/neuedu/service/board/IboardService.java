package com.neuedu.service.board;

import java.util.List;

import com.neuedu.pageBean.Board;
import com.neuedu.pojo.Arrange;

public interface IboardService {
	public Board getArrangesByGid(Integer gId);
}
