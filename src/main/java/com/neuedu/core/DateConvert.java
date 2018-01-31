package com.neuedu.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date>  {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	        try {  
	            return simpleDateFormat.parse(source);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	}

}
