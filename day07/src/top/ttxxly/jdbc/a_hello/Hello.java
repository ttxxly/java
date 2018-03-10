package top.ttxxly.jdbc.a_hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import top.ttxxly.jdbc.utils.jdbcUtils;

public class Hello {

	@Test
	public void f1() {
		System.out.println("Hello");
	}
	
	@Test
	public void f2() throws Exception {
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取连接 ctrl + shift + o 导包
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day07", "root", "123456");
		
		//编写sql
		String sql = "select * from category;";
		
		//创建语句执行者
		PreparedStatement st =  conn.prepareStatement(sql);
		
		//设置参数
		
		//执行sql
		ResultSet rs = st.executeQuery(); 
		//处理结果
		while(rs.next()) {
			System.out.println(rs.getString("cid")+"::"+rs.getString("cname"));
		}
		
		//释放资源
		rs.close();
		st.close();
		conn.close();
	}
	
	//插入一条数据
	@Test
	public void f3() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				//获取连接
				conn = jdbcUtils.getConnection();
				//编写sql
				String sql = "insert into category values(?,?);";
				//获取语句执行者
				st = conn.prepareStatement(sql);
				//设置参数
				st.setString(1, "c005");
				st.setString(2, "户外");
				//执行sql
				int i = st.executeUpdate();
				//处理结果
				if (i == 1) {
					System.out.println("执行成功！！");
				}else {
					System.out.println("执行失败！！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//关闭连接
				jdbcUtils.closeResource(conn, st, rs);		
			}
			
		
		
	}
}
