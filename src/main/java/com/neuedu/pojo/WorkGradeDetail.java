package com.neuedu.pojo;

import java.util.Date;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("work_grade_detail")
public class WorkGradeDetail extends BaseBean {
	@ID
	private Integer id;
	@Column("wg_id")
	private Integer wgId;
	private Date dat;
	private Integer count;
	@Column("is_del")
	private Integer isDel;

}
