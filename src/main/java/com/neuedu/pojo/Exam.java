package com.neuedu.pojo;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.annotation.JSONField;
import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

@Data
public class Exam extends BaseBean{
	@ID
	private Integer id;
	private String name;
	@Column("p_id")
	private Integer pId;
	private String no;
	@Column("g_id")
	private Integer gId;
	private Integer status;
	@Column("start_time")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@Column("end_time")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	@Column("is_del")
	private Integer isDel;
	private String pName;
}
