package com.neuedu.pageBean;

import java.util.List;

import com.neuedu.pojo.Arrange;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Plan;

import lombok.Data;

@Data
public class Board {
	private Grade grade;
	private List<Arrange> arranges;
}
