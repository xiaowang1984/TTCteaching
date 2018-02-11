package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Arrange extends BaseBean{
	@ID
	private Integer id;
	@Column("g_id")
	private Integer gId;
	@Column("p_id")
	private Integer pId;
	private Integer type;
	private String note;
	@Column("is_del")
	private Integer isDel;
	@Column("t_id")
	private Integer tId;
	private List<ArrangeList> arrangeLists;
	private Plan plan;
	private String project;
	private String git;
}