/*
	���Ըն���� Phone��
	�����������ͱ����ĸ�ʽ��
		�������� ������ = new ��������();
	ʵ���������͵Ĳ��裺
		1. ��������඼����ͬһ�ļ��У�����Ҫ�����
		2. �����������͵ı���
		3. ����.�����еĹ���
*/

public class TestPhone{
	public static void main(String[] args) {
		//�����������͵ı���
		Phone p = new Phone();
		
		//����.�����еĹ���
		p.color = "������";
		p.brand = "��Ϊ";
		p.size = 5.0;
		
		//��ȡ����ֵ
		System.out.println(p.color);
		System.out.println(p.brand);
		System.out.println(p.size);
	}
}