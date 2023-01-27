package chapter05;

abstract class SuperClass{
	abstract void superMethod();
}

class subClass extends SuperClass{

	@Override
	void superMethod() {
		
		
	}
	
	
}

public class Example02 {
	
	enum EXAMPLE_ENUM{
		FIRST(1), SECOND(2), THIRD(3);
		
		private EXAMPLE_ENUM(int i) {
			
		}
	};
	
	static final int FIRST = 0;
	static final int SECOND = 1;
	static final int THRID = 2;

	public static void main(String[] args) {
		System.out.println(EXAMPLE_ENUM.SECOND.ordinal());
	}
}
