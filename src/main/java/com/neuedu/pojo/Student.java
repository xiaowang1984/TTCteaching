package com.neuedu.pojo;


import com.neuedu.util.BaseBean;

import lombok.Data;
import util.Column;
import util.ID;

import com.neuedu.core.CN;
@Data
public class Student extends BaseBean{
	@ID
    private Integer id;
	@CN("姓名")
    private String name;
	@CN("性别")
    private Integer gender;
	@CN("民族")
    private String nation;
	@CN("对应销售")
    private String sale;
	@CN("毕业院校")
    private String school;
	@CN("专业")
    private String specialty;
	@CN("学历")
    private String education;
	@CN("QQ")
    private String qq;
	@CN("地址")
    private String address;
	@CN("邮箱")
    private String email;
	@CN("房间号")
	@Column("room_no")
    private String roomNo;
	@CN("周期")
    private String cycle;
	@CN("是否退费")
    private Integer refund;
	@CN("电话号码")
    private String phone;
	@CN("身份证号")
	@Column("id_card")
    private String idCard;
	@CN("家长电话")
	@Column("we_char")
    private String weChar;
	private Integer status;
	@CN("班级")
	@Column("g_id")
    private Integer gId;
	@CN("是否删除")
	@Column("is_del")
    private Integer isDel;

}
