package com.neuedu.service.git;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public interface IgitService {
	public String gitLoad(HttpServletRequest request,HttpServletResponse response);
}
