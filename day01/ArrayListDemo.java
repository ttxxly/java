/*
	ArrayList 集合的使用
	也是引用类型
	
	步骤：
		1. 导入包 java.util 包
		2. 创建引用类型的变量
			数据类型<集合存储的数据类型> 变量名 = new 数据类型 <集合存储的数据类型>();
			集合存储的数据类型：要将数据存储到集合的容器中
			创建集合引用变量的时候，必须要指定好存储的类型是什么。
			
			ArrayList<String> array = new ArrayList<String>();
		3. 变量名.方法
		
		注意：集合存储的数据，8个基本类型对应于8个引用类型
		只存储引用类型不存储基本类型
		
*/
public class ArrayListDemo{
	public static void main(String[] args) {
		//创建集合容器，指定存储的数据类型。
		//存储字符串
		ArrayList<String> array = new ArrayList<String>();
		
		//创建集合容器，存储整数
		ArrayList<Integer> array2 = new ArrayList<Integer>();
	}
		
}