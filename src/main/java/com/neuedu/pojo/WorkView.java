package com.neuedu.pojo;

import com.neuedu.util.BaseBean;
import com.neuedu.util.ResultData;

import lombok.Data;

@Data
public class WorkView extends BaseBean {
	private Grade grade;
	private ResultData works;
}
