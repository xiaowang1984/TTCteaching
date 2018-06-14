package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Computer extends BaseBean{
	@ID
	private Integer id;
	private String name;
	@Column("g_id")
	private Integer gId;
	@Column("c_id")
	private Integer cId;
	private Date dat;
	private String question;
	@Column("is_del")
	private Integer isDel;
	private String cName;
	private List<ComputerDetails> list;
}
