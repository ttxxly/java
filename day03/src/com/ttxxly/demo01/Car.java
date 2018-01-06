package com.ttxxly.demo01;


/**
 * 用类的方式来描述显示生活中的事物： 小汽车
 * 
 * 	小汽车
 * 		属性：颜色、轮胎个数
 * 		功能： 跑 方法
 * 
 * 	属性和方法都属于类的成员
 *		属性：成员变量
 *		方法： 成员方法
 * @author ttxxly
 *
 */
public class Car {

	//定义属性
	String color;
	int count;
	
	//定义功能：跑 方法
	public void run() {
		System.out.println("小汽车在跑!!!,颜色是："+color+"轮胎个数为："+count);
	}

}
