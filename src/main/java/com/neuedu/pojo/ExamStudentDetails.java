package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("exam_student_details")
public class ExamStudentDetails extends BaseBean {
	@ID
	private Integer id;
	@Column("ed_id")
	private Integer edId;
	@Column("t_id")
	private Integer tId;
	@Column("o_id")
	private Integer oId;
	@Column("r_id")
	private Integer rId;
	private String tName;
	private String analysis;
	private List<Options> options;
}
