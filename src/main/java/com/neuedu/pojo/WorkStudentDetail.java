package com.neuedu.pojo;

import java.util.Date;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("work_student_detail")
public class WorkStudentDetail extends BaseBean{
	@ID
	private Integer id;
	@Column("ws_id")
	private Integer wsId;
	private Date dat;
	private Integer count;
	@Column("is_del")
	private Integer isDel;

}
