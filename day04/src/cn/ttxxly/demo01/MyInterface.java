package cn.ttxxly.demo01;

/*
 * 定义接口  关键字 Interface 接口的名字
 * 接口定义：
 * 		成员方法，全抽象
 * 		不能定义带有方法体的方法
 * 
 * 定义抽象方法：固定格式
 * 	
 * 		public abstract 返回值类型 方法名字(参数列表);
 * 		修饰符 public 写或不写都是public 权限
 * 接口中成员变量的定义
 * 		要求：必须为常量
 * 		格式：public static final 数据类型 = 值
 */
public interface MyInterface {
	//在接口中定义抽象方法
	void function();
}
