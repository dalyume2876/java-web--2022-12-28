package chapter03;

/*
 * �߻� Ŭ���� : 
 * Ŭ������ �߻������θ� ǥ���ص� Ŭ����
 * Abstract �����ڸ� ����
 */

abstract class Animal2 {
	String eyes;
	String ears;
	String legs;
	
	/*
	 * �߻� �޼��� :
	 * �ش� �޼��忡 ���ؼ� ���� �ص� �޼���
	 */
	abstract void eat();
}

class Dog extends Animal2{
	String tail;

	@Override
	void eat() {
		System.out.println("���� ��Ḧ �Խ��ϴ�.");
		
	}
	
}

public class Abstract {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.eat();
				
	}
}
