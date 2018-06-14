package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("conputer_details")
public class ComputerDetails extends BaseBean {
	@ID
	private Integer id;
	@Column("i_id")
	private Integer iId;
	@Column("s_id")
	private Integer sId;
	private Integer skill;
	@Column("is_del")
	private Integer isDel;
	private String mark;
	private String sname;

}
