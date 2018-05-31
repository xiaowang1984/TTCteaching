package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Module extends BaseBean {
	@ID
	private Integer id;
	private String name;
	@Column("l_id")
	private Integer lId;
	private Integer sort;
	@Column("is_del")
	private Integer isDel;
	private String lname;
	private List<Point> points;
}
