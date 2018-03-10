package com.ttxxly.test;

public class Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("我很帅!!!!");
			final StringBuffer sb = new StringBuffer();
			sb.append("hello");
			//System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("结束!!!!");
		}
	}

}
