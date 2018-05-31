package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("interview_details")
public class InterviewDetails extends BaseBean {
	@ID
	private Integer id;
	@Column("i_id")
	private Integer iId;
	@Column("s_id")
	private Integer sId;
	private Integer skill;
	private Integer express;
	@Column("is_del")
	private Integer isDel;
	private String mark;
	private String sname;

}
