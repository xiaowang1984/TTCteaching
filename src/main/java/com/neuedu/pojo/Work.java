package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;

@Data
public class Work extends BaseBean{
	private Integer id;
	@Column("al_id")
	private Integer alId;
	@Column("g_id")
	private Integer gId;
	private String name;
	private Integer type;
	private Integer count;
	private String point;
	private String description;
	private String requirement;
	@Column("start_dat")
	private Date startDat;
	@Column("end_dat")
	private Date endDat;
	@Column("is_del")
	private Integer isDel;
	private WorkGrade workGrade;
}
