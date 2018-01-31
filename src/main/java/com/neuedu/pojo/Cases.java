package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;

@Table("cases")
@Data
public class Cases extends BaseBean {
	@ID
	private Integer id;
	private String name;
	private String extend;
	private Integer type;
	private Integer count;
	private String point;
	private String description;
	private String requirement;
	private String url;
	private Integer provider;
	@Column("is_del")
	private Integer isDel;

}
