package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("work_grade")
public class WorkGrade extends BaseBean {
	@ID
	private Integer id;
	@Column("w_id")
	private Integer wId;
	private Integer count;
	@Column("is_del")
	private Integer isDel;
	private List<WorkGradeDetail> workGradeDetails;
}
