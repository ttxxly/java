/*
	测试刚定义的 Phone类
	创建引用类型变量的格式：
		数据类型 变量名 = new 数据类型();
	实现引用类型的步骤：
		1. 导入包，类都是在同一文件夹，不需要导入包
		2. 创建引用类型的变量
		3. 变量.类型中的功能
*/

public class TestPhone{
	public static void main(String[] args) {
		//创建引用类型的变量
		Phone p = new Phone();
		
		//变量.类型中的功能
		p.color = "土豪金";
		p.brand = "华为";
		p.size = 5.0;
		
		//获取属性值
		System.out.println(p.color);
		System.out.println(p.brand);
		System.out.println(p.size);
	}
}