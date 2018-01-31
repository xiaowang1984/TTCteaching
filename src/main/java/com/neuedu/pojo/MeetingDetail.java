package com.neuedu.pojo;

import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.Table;

@Table("meeting_detail")
@Data
public class MeetingDetail extends BaseBean{
	private Integer id;
	@Column("m_id")
	private Integer mId;
	private String problem;
	private String solve;

}
