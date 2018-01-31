package com.neuedu.pojo;

import java.util.Date;
import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;

@Data
public class Meeting extends BaseBean {
	private Integer id;
	private String type;
	private Date date;
	@Column("g_id")
	private Integer gId;
	private Integer count;
	private List<MeetingDetail> detail;
}
