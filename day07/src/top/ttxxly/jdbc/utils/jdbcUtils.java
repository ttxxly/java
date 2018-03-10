package top.ttxxly.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbcUtils {

	//获取连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//注册驱动 Ctrl + Shift + F 格式化代码
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取连接 ctrl + shift + o 导包
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07", "root", "123456");
		
		return null;
	}
		
	//释放资源
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);
	}
	
	/**
	 * 释放 Conn 连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		conn = null;//为空 垃圾回收机制会快速的回收走
	}
	
	/**
	 * 释放 语句执行者 
	 * @param st 语句执行者 
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		st = null;//为空 垃圾回收机制会快速的回收走
	}
	
	/**
	 * 释放 结果集
	 * @param rs 结果集
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = null;//为空 垃圾回收机制会快速的回收走
	}
	
}
