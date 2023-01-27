package chapter03;

public interface iExample01 {
	
	public static final int number = 0;
	
	void hello();
}

interface iExample03{
	public static final String STRING = "string";
}
/*
 * 인터페이스 상속
 * 인터페이스 간의 상속은 extends 키워드를 사용
 * 인터페이스는 다중 상속 가능
 */
interface iExample02 extends iExample01, iExample03{
	
	public static final double DECIMAL = 10.5;
	
}

/*
 * 인터페이스 구현
 * 인터페이스를 클래스에 구현할 때는 implements 키워드를 사용
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
