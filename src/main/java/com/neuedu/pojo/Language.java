package com.neuedu.pojo;

import java.util.List;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;

@Data
public class Language extends BaseBean {
	private Integer id;
	private String name;
	@Column("git_url")
	private String gitUrl;
	@Column("img_url")
	private String imgUrl;
	@Column("is_del")
	private Integer isDel;
	private List<Module> modules;
}
