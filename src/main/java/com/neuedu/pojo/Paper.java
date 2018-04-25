package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Paper extends BaseBean {
	@ID
	private Integer id;
	private String name;
	@Column("is_del")
	private Integer isDel;
}
