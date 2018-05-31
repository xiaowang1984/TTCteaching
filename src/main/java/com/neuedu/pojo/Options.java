package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Options extends BaseBean {
	@ID
	private Integer id;
	@Column("t_id")
	private Integer tId;
	private String name;
	@Column("is_right")
	private Integer isRight;
	@Column("is_del")
	private Integer isDel=1;
}
