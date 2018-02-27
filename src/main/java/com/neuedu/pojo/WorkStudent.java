package com.neuedu.pojo;


import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Data
@Table("work_student")
public class WorkStudent extends BaseBean {
	@ID
	private Integer id;
	@Column("wg_id")
	private Integer wgId;
	@Column("s_id")
	private Integer sId;
	private Integer count;
	@Column("is_del")
	private Integer isDel;

}
