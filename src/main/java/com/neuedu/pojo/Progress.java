package com.neuedu.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Progress {
	private Integer total;
	private List<Week> weeks;
	private String author;
}
@Data
class Week{
	private Integer w;
	private Integer a;
	private Integer d;
	private Integer c;
}
@Data
class Author{
	
}
