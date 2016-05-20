package com.mybatis.controller.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.exception.CustomException;

/**
 * 自定义异常处理
 * @author jerry
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		ex.printStackTrace();
		
		String message = null;
		CustomException customException = null;
		
		if(ex instanceof CustomException){
			
			customException = (CustomException) ex;
		}else{
			
			customException = new CustomException("未知错误");
		}
		
		message = customException.getMessage();
		request.setAttribute("errorMessage", message);
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}

}
