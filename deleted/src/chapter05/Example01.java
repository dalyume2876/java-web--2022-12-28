package chapter05;

import java.util.ArrayList;
import java.util.List;

class MyInfo<JI, TMP>{
	String name;
	String job;
	
	JI jobInfo; //JI������ ����
	TMP tmp;
	
	<T, TMP> void getTmpList(List<T> list, T tmp){
		 
	}
}



/*
 * ���ʸ�
 * �پ��� Ÿ���� �ٷ�� Ŭ���� Ȥ�� �޼��忡�� Ÿ���� ������ �ִ� ��
 */
public class Example01 {

	public static void main(String[] args) {
		List strList = new ArrayList<>();
		strList.add("�⺻ ���ڿ�");
		//���ʸ��� ������� ������ �� �۾����� �� ��ȯ�� ���Ѿ� ��.
		//List<E(Ÿ�� ����)>
		String str = (String) strList.get(0);
		
		List<String> strList2 = new ArrayList<String>();
		strList2.add("�⺻ ���ڿ�");
		String str2 = strList2.get(0);
		
		MyInfo info1 = new MyInfo();
		//developer ������ ����.
		
		/*
		 * ���ʸ� Ŭ������ Ÿ�Ժ�����
		 * �������� ������� �ʱ� ������
		 * ����� ����� Ÿ�Ժ����� 
		 */
		MyInfo info3 = new MyInfo();
		
		//
//		MyInfo<?, ?> info4 = new MyInfo<Developer, Integer>();
//		info4.getTmpList(new ArrayList<Developer>	
	}
	
}
