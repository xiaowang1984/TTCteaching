package com.neuedu.service.git;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitServiceImpl {

	
	@RequestMapping("/upload")
	public String gitLoad(@RequestBody Map<String, String> parameterMap) {
		// TODO Auto-generated method stub
		System.out.println("111");
		File file=new File("/abcd.txt");
		 Set<String> keys= parameterMap.keySet();
		 StringBuilder builder=new StringBuilder();
		 for (String key : keys) {
			 
			builder.append(key+"------"+parameterMap.get(key));
		}
		try {
			FileUtils.writeStringToFile(file, builder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return builder.toString();
	}

}
