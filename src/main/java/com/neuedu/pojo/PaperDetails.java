package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("paper_details")
public class PaperDetails extends BaseBean{
	@ID
	private Integer id;
	@Column("p_id")
	private Integer pId;
	@Column("t_id")
	private Integer tId;
	@Column("is_del")
	private Integer isDel;
	private String tName;
	private Integer selected=0;
	private List<Options> options;
}
