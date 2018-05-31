package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Interview extends BaseBean{
	@ID
	private Integer id;
	private String name;
	@Column("g_id")
	private Integer gId;
	private Date dat;
	private String question;
	@Column("is_del")
	private Integer isDel;
	private List<InterviewDetails> list;
}
