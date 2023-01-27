package chapter04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Example05 {

	public static void main(String[] args) {
//		Set<String> set = new HashSet<String>();
//		
//		//set ������ �����͸� �߰�
//		set.add("Apple");
//		set.add("carrot");
//		set.add("apple");
//		set.add("banana");
//		
//		//set�� �������� �ε���x
//		//set[0];
//		//Iterator�� set�� ����
//		Iterator<String> hashIterator = set.iterator();
//		
//		//Iterator�� hasNext �޼���� ��� �ݺ�
//		while(hashIterator.hasNext()) {
//			//Iterator�� hasNext �޼���� ��� ������	
//			System.out.println(hashIterator.hasNext());
//		}
//		
//		System.out.println("=========================================");
//		
//		Set<String> treeSet = new TreeSet<String>();
//		
//		treeSet.add("1");
//		treeSet.add("2");
//		treeSet.add("3");
//		treeSet.add("4");
//		treeSet.add("5");
//		
//		Iterator<String> treeSetIterator = treeSet.iterator();
//		while(treeSetIterator.hasNext()) {
//			System.out.println(treeSetIterator.hasNext());
//		}
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(9);
		numbers.add(-1);
		numbers.add(50);
		
		//Ư�� ��ġ�� Ư�� �����͸� ����.
		numbers.add(2, 100);
		
		//Ư�� ��ġ�� �����͸� ����
		numbers.set(3, 1);
		
		//Ư�� ��ġ�� �����͸� ����
		numbers.remove(0);
		
		for(Integer number : numbers) {
			System.out.println(number);
		}
		
		List<String> arrList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 200000; i++) {
			arrList.add(0, String.valueOf(i));
		}
		
		long end = System.currentTimeMillis();
		System.out.println("ArrayList �۾��ð� : " + (end - start));
		
		start = System.currentTimeMillis();
		
		for(int i = 0; i < 200000; i++) {
			linkedList.add(0, String.valueOf(i));
		}
		
		end = System.currentTimeMillis();
		System.out.println("LinkedList �۾��ð� : " + (end - start));
		
		Map<String, String> hashMap = new HashMap<String, String>();
		
		//hashMap�� ������  �߰��� put
		hashMap.put("key", "value");
		hashMap.put("name", "john");
		hashMap.put("address", "busan somewhere");
		
		System.out.println(hashMap.get("name"));
		
		Set<String> keys = hashMap.keySet();
		Iterator<String> keyIterator = keys.iterator();
		
		while(keyIterator.hasNext()) {
			System.out.println(keyIterator.next());
		}
		
		if(hashMap.containsKey("age")) {
			System.out.println(hashMap.get("age"));
		}
	}
	
}
