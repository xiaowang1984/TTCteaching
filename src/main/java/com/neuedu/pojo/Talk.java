package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Talk extends BaseBean{
	@ID
	private Integer id;
	@Column("g_id")
	private Integer gId;
	@Column("s_id")
	private Integer sId;
	@Column("t_id")
	private Integer tId;
	private Integer assess;
	private String txt;
	@Column("is_del")
	private Integer isDel;
	private String tName;
}
