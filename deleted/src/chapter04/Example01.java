package chapter04;

import java.util.Scanner;

/*
 * 예외처리
 * 컴파일이나 메모리 공간 부족등 개발자가 코드상으로 조취를 취할 수 있는 에러가 아니라
 * 예측하고 처리할 수 있는 문제 
 */
public class Example01 {

	static void printArray(int index) throws Exception{
		int[] array = new int[] {1, 2, 3};
		System.out.println(array[index]);

	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//0으로 나누는 상황
		System.out.print("숫자를 입력하세요. : ");
		int a = scanner.nextInt();

		//예외처리 Exception
		try {
			//예외 발생 로직
			int result = 10 / a;
			System.out.println(result);
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다.");
		}
		
		
		//배열 인덱스 조회시 범위를 벗어날 때
		int[] array = new int[3];
//		array[a] = 10; 
		try {
			for(int i = 0; i < array.length; i++) {
				if(array[i] > array[i + 1]) {
					System.out.println("앞의 수가 큽니다.");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("정상종료");
		}
		
		try {
			printArray(a);			
		}catch (Exception e) {
			System.out.println("인덱스 범위 밖입니다.");
		}
	}
}
