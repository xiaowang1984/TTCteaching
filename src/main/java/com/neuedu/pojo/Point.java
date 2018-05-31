package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;

@Data
public class Point extends BaseBean {
	private Integer id;
	private String name;
	private String description;
	@Column("m_id")
	private Integer mId;
	@Column("is_del")
	private Integer level;
	private Integer sort;
	private Integer isDel;
	private String mName;
	private Integer lId;
	private String lName;

}
