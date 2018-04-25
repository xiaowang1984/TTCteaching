package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("exam_details")
public class ExamDetails extends BaseBean {
	@ID
	private Integer id;
	@Column("s_id")
	private Integer sId;
	@Column("e_id")
	private Integer eId;
	private Float score;
}
