package com.neuedu.pojo;

import java.util.List;

import lombok.Data;

@Data
public class PageGradeAdd {
	private List<Teacher> lecturer;
	private List<Teacher> manager;
}
