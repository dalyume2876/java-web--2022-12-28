package chapter04;

class Ticketing{
	int ticketVolum = 1;
	
	//synchronized Ű����� �ش� �޼��带 ���� �޼���� ����
	//�� �����尡 �ش� �޼��带 �۾����� �� ������ ����
	public void ticketing() {
		
		if (ticketVolum > 0) {
			System.out.println(Thread.currentThread().getName() + "- Ƽ����!");
			ticketVolum--;
		}else {
			System.out.println(Thread.currentThread().getName() + "- Ƽ���ý���");	
		}

		System.out.println(Thread.currentThread().getName() + "- Ƽ���� �õ� �� Ƽ�� �� : " + ticketVolum);
	}
	
}

class TicketingThread implements Runnable{
	
	Ticketing ticketing = new Ticketing();
	
	@Override
	public void run() {
		ticketing.ticketing();
		
	}
	
	
}

public class Example07 {

	public static void main(String[] args) {
		
		TicketingThread runnable = new TicketingThread();
		
		Thread thread1 = new Thread(runnable, "A");
		Thread thread2 = new Thread(runnable, "B");
		Thread thread3 = new Thread(runnable, "C");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}
