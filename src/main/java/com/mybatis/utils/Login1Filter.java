package com.mybatis.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Login1Filter extends HttpServlet implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		String username = (String) servletRequest.getSession().getAttribute("username");
		String url = servletRequest.getRequestURI().toString();
		
		if(username!=null || url.endsWith("doLogin.htm")){
			
			chain.doFilter(request, response);
		}else{
			servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.jsp");
		}
	}

}
