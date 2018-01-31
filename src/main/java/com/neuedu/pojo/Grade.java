package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Grade extends BaseBean{
	@ID
	private Integer id;
	private String name;
	private Integer type;
	private String place;
	private String room;
	private Integer state;
	@Column("start_date")
	@JSONField(format="yyyy-MM-dd")
	private Date startDate;
	@Column("employment_date")
	private Date employmentDate;
	private Date end;
	private Integer lecturer;
	private Integer manager;
	@Column("is_del")
	private Integer isDel;
	private String lecturerName;
	private String managerName;
	private List<Student> studnets;
	private List<Work> works;
	private String img;
	private Integer stuCount;
	private Integer offer;
}
