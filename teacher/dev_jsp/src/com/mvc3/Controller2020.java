package com.mvc3;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Controller2020 {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;
	public ModelAndView process(String work,HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	public String process(Map<String, Object> cudMap, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;;
}
