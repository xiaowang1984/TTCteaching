package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Course extends BaseBean {
	@ID
	private Integer id;
	private String name;
	private String img;
	private String description;
	@Column("is_del")
	private Integer isDel;
	private List<Plan> plans;
}
