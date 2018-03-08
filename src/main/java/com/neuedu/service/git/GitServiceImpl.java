package com.neuedu.service.git;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitServiceImpl implements IgitService{

	@Override
	@RequestMapping("/upload")
	public String gitLoad(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("111");
		File file=new File("/abcd.txt");
		 Map<String, String[]> parameterMap = request.getParameterMap();
		 Set<String> keys= parameterMap.keySet();
		 for (String key : keys) {
			 StringBuilder builder=new StringBuilder();
			for(String val : parameterMap.get(key)){
				builder.append(val+",");
			}
			try {
				FileUtils.writeStringToFile(file, key+"----"+builder.toString(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return "fdfdsafdsa";
	}

}