package com.itheima.c_life;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet implements Servlet {

	/**
	 * 初始化方法
	 * 执行者:服务器
	 * 执行次数:一次
	 * 执行时机:默认第一次访问的时候
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("55555555555");
	}

	/**
	 * 服务
	 * 执行者:服务器
	 * 执行次数:请求一次执行一次
	 * 执行时机:请求来的时候
	 */
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("666666666666666");
		
	}
	
	/**
	 * 销毁
	 * 执行者:服务器
	 * 执行次数:只执行一次
	 * 执行时机:当servlet被移除的时候或者服务器正常关闭的时候
	 */
	public void destroy() {
		System.out.println("4444444444444444");
		
	}
	
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
