package com.neuedu.pojo;

import java.util.Date;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;
import util.Table;
@Data
@Table("arrange_list")
public class ArrangeList extends BaseBean{
	@ID
	private Integer id;
	@Column("a_id")
	private Integer aId;
	private Date date;
	private String morning;
	private String afternoon;
	private String night;
	private Float mtime;
	private Float atime;
	private Float ntime;
	private String work;
	private String remark;

}
