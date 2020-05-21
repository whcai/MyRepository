package com.demo.common;

import com.demo.beans.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : whc
 * @Project: demo
 * @Package com.ssm.common
 * @Description: 通用拦截类，用于拦截所有请求
 * @date Date : 2020年04月15日 8:43
 */
public class CommonInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	// 拦截器，拦截所有请求,处理登录问题
	public boolean preHandle(HttpSession session, HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("开始处理所有请求");
		TUser tUser = (TUser) session.getAttribute("user");
		if (tUser != null) {
			return true;
		} else {
			response.sendRedirect("/admin/login");
			return false;
		}
	}
}
