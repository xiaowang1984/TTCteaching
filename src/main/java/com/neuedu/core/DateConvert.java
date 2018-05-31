package com.neuedu.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date>  {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		 
	        try {  
	        	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	            return simpleDateFormat.parse(source);  
	        } catch (ParseException e) {  
	            try {
	            	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
					return simpleDateFormat.parse(source);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
	        }  
	        return null;  
	}

}
