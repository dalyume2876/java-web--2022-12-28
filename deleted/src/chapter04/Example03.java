package chapter04;

import java.util.Random;

public class Example03 {
	public static void main(String[] args) {
		
		Integer integer = 100;
		
		//int number = 100;
		//String numberStr = number;
		
		//Wrapper Class로 작성된 형태는 문자열로 변경 가능
		String numberStr = integer.toString();
		System.out.println(numberStr);
		
		//기본 타입일 경우 null로 초기화가 불가능 하다.
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
