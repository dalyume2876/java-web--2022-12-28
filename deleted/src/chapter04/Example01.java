package chapter04;

import java.util.Scanner;

/*
 * ����ó��
 * �������̳� �޸� ���� ������ �����ڰ� �ڵ������ ���븦 ���� �� �ִ� ������ �ƴ϶�
 * �����ϰ� ó���� �� �ִ� ���� 
 */
public class Example01 {

	static void printArray(int index) throws Exception{
		int[] array = new int[] {1, 2, 3};
		System.out.println(array[index]);

	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//0���� ������ ��Ȳ
		System.out.print("���ڸ� �Է��ϼ���. : ");
		int a = scanner.nextInt();

		//����ó�� Exception
		try {
			//���� �߻� ����
			int result = 10 / a;
			System.out.println(result);
		}catch (ArithmeticException e) {
			System.out.println("0���� ���� �� ����.");
		}
		
		
		//�迭 �ε��� ��ȸ�� ������ ��� ��
		int[] array = new int[3];
//		array[a] = 10; 
		try {
			for(int i = 0; i < array.length; i++) {
				if(array[i] > array[i + 1]) {
					System.out.println("���� ���� Ů�ϴ�.");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("��������");
		}
		
		try {
			printArray(a);			
		}catch (Exception e) {
			System.out.println("�ε��� ���� ���Դϴ�.");
		}
	}
}
