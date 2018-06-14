package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
@Data
public class Tests extends BaseBean{
	@ID
	private Integer id;
	private String name;
	@Column("q_id")
	private Integer qId;
	private String skill;
	private String facility;
	private String analysis;
	@Column("is_del")
	private Integer isDel=1;
	private List<Point> points;
}
