package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;

@Data
public class Plan extends BaseBean {
	private Integer id;
	private String name;
	@Column("c_id")
	private Integer cId;
	private String url;
	@Column("is_del")
	private Integer isDel;
	private Course course;
}
