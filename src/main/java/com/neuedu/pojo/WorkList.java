package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.Table;

@Table("work_list")
@Data
public class WorkList extends BaseBean {
	private Integer id;
	@Column("al_id")
	private Integer alId;
	@Column("s_id")
	private Integer sId;
	private Integer count;
	@Column("is_del")
	private Integer isDel;

}
