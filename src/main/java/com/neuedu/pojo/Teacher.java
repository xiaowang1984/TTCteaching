package com.neuedu.pojo;

import java.util.Date;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;

@Data
public class Teacher extends BaseBean{
	private Integer id;
	private String no;
	private String name;
	private String password;
	private Integer type;
	private String phone;
	private Integer state;
	@Column("is_del")
	private Integer isDel;

}
