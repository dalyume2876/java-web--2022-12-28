package chapter05;

import java.util.ArrayList;
import java.util.List;

class MyInfo<JI, TMP>{
	String name;
	String job;
	
	JI jobInfo; //JI파일이 없음
	TMP tmp;
	
	<T, TMP> void getTmpList(List<T> list, T tmp){
		 
	}
}



/*
 * 제너릭
 * 다양한 타입을 다루는 클래스 혹은 메서드에서 타입을 지정해 주는 것
 */
public class Example01 {

	public static void main(String[] args) {
		List strList = new ArrayList<>();
		strList.add("기본 문자역");
		//제너릭을 사용하지 않으면 매 작업마다 형 변환을 시켜야 함.
		//List<E(타입 변수)>
		String str = (String) strList.get(0);
		
		List<String> strList2 = new ArrayList<String>();
		strList2.add("기본 문자열");
		String str2 = strList2.get(0);
		
		MyInfo info1 = new MyInfo();
		//developer 파일이 없음.
		
		/*
		 * 제너릭 클래스의 타입변수는
		 * 다형성이 적용되지 않기 때문에
		 * 선언시 사용한 타입변수와 
		 */
		MyInfo info3 = new MyInfo();
		
		//
//		MyInfo<?, ?> info4 = new MyInfo<Developer, Integer>();
//		info4.getTmpList(new ArrayList<Developer>	
	}
	
}
