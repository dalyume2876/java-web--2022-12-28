package chapter04;

public class Example02 {
	
	public static void main(String[] args) {
		String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		
		System.out.println(comment);
		
		//���ڿ��� �����ϴ� String API method
		comment = comment.concat(comment);
		System.out.println(comment);
		
		//���ڿ��� �߶󳻴� String API method
		String substr = comment.substring(6, 11);
		System.out.println(substr);
		
		//�ֹε�Ϲ�ȣ���� ���� - ���� - ���� - ���� 
		String identityNumber = "123456-7891011";
		String year = identityNumber.substring(0, 2);
		String month = identityNumber.substring(2, 4);
		String day = identityNumber.substring(4, 6);
		String gender = identityNumber.substring(7, 8);
		
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("day : " + day);
		System.out.println("gender : " + gender);
		
		//���ڿ��� ���̸� �������� String API method
		int strLength = comment.length();
		System.out.println("steLength : " + strLength);
		
		//���ڿ��� ��� �� �Ǵ� �ҹ��ڷ�
		comment = comment.toUpperCase();
		System.out.println(comment);
		
		comment = comment.toLowerCase();
		System.out.println(comment);
		
		//�Է� �޴� ���� ���ڿ��� �������� ��
		//Category : Top, Bottom -> Top
		
		//�ش��ϴ� �ε����ڸ��� ��ġ�� ���ڸ� ���ϴ� String API method
		char character = comment.charAt(2);
		System.out.println(character);
		
		//�ش��ϴ� ���ڿ��� ���° �ε����� �����ϴ��� ���ϴ� String API method
		int StringIndex = comment.indexOf("dolor");
		System.out.println(StringIndex);
		
		//�ش��ϴ� ���ڿ��� ���� ����� ���ϴ� String API method
		boolean flag = comment.equals("dolor");
		System.out.println(flag);
		
		//���ڿ��� �յ� ������ �����ϴ� String API method
		String BlankStr = " blank blank ";
		System.out.println(BlankStr);
		BlankStr = BlankStr.trim();
		System.out.println(BlankStr);
		
		//Ư���� ���ڸ� �ٸ� ���ڷ� �ٲٴ� String API method
		comment = comment.replaceAll("lorem", "merol");
		System.out.println(comment);
	}
	
}
