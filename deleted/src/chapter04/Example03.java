package chapter04;

import java.util.Random;

public class Example03 {
	public static void main(String[] args) {
		
		Integer integer = 100;
		
		//int number = 100;
		//String numberStr = number;
		
		//Wrapper Class�� �ۼ��� ���´� ���ڿ��� ���� ����
		String numberStr = integer.toString();
		System.out.println(numberStr);
		
		//�⺻ Ÿ���� ��� null�� �ʱ�ȭ�� �Ұ��� �ϴ�.
		Integer number = null;
		int i = integer.intValue();
		double d = integer.doubleValue();
		
		Random random = new Random();
		
		int rdInt = random.nextInt();
		System.out.println(rdInt);
		rdInt = random.nextInt(5) + 10;
		System.out.println(rdInt);
	}
}
