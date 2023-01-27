package chapter03;

public interface iExample01 {
	
	public static final int number = 0;
	
	void hello();
}

interface iExample03{
	public static final String STRING = "string";
}
/*
 * �������̽� ���
 * �������̽� ���� ����� extends Ű���带 ���
 * �������̽��� ���� ��� ����
 */
interface iExample02 extends iExample01, iExample03{
	
	public static final double DECIMAL = 10.5;
	
}

/*
 * �������̽� ����
 * �������̽��� Ŭ������ ������ ���� implements Ű���带 ���
 */
class Example implements iExample02 {

	@Override
	public void hello() {
		System.out.println("hello");
		
	}
	
}

class Example2 implements iExample02 {

	@Override
	public void hello() {
		System.out.println();
		
	}
	
}

class Example3{
	public static void main(String[] args) {
		iExample02 exem1 = new Example();
		iExample02 exem2 = new Example2();
	}
}
