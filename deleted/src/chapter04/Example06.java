package chapter04;

// Thread Ŭ������ ��� �޾Ƽ� Thread�� ����� ���
class Thread1 extends Thread{
	//run�� �������̵� �ؼ� �۾� ������ ����.
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.print("*");	
			//Thread.yield()�� �ڽ��� �ð��� ���� ������ Thread�� �纸
			Thread.yield();
			for(int j = 0; j < 100000; j++) {}
		}
		
	}
}

//Runnable �������̽��� �����ؼ� Thread ����� ���
class Thread2 implements Runnable{

	// Runnable �������̽��� �߻� �޼��� run�� ����
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.print("#");			
			for(int j = 0; j < 100000; j++) {}
			
		}
	}
	
}

class countDown extends Thread{

	public void run() {
		/*
		 * Thread.sleep()�� ���� �ð�����
		 * Block���·� ����
		 */
		for(int i = 10; i > 0; i--) {
			System.out.println(i + "��...");
			try {
				//Thread�� 1�ʵ��� Block���·� ����
				//Block : ������������ CPU �����ٿ� ������ ���� ���ϴ� ����
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("��");
	}
}

public class Example06 {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		/*
		 * Runnable �������̽��� ������ Ŭ������ ���
		 * Thread Ŭ������ �������� ���ڷ�  ��Ƽ�
		 * Thread �ν��Ͻ��� ������ �� ���O
		 */
		Thread2 thread2 = new Thread2();
		Thread thread = new Thread(thread2);
		
		// Thread Ŭ������ setPriority �޼���� �켱���� ����
		//�켱������ �������� ������ �⺻ ������ 5
		thread1.setPriority(1);
		thread.setPriority(9);
		
		//��ӹ��� Thread Ŭ������ start() �޼���� �ش� Thread�� ����
		thread1.start();
		
		try {
			thread1.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		thread.start();
		
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
//		for(int i = 0; i < 20; i++) {
//			System.out.print("@");			
//			for(int j = 0; j < 100000; j++) {}
//		}
		
//		countDown countDown = new countDown();
//		countDown.start();
	}
	
}
