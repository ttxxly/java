package com.itheima.f_path;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pt=PathServlet.class.getClassLoader().getResource("2.txt").getPath();
		System.out.println("pt:"+pt);
		String pt1=PathServlet.class.getClassLoader().getResource("/2.txt").getPath();
		System.out.println("pt1:"+pt1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void main(String[] args) {
		String pt=PathServlet.class.getClassLoader().getResource("2.txt").getPath();
		System.out.println("pt:"+pt);
	}

}
