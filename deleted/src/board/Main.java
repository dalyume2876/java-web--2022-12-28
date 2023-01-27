package board;

import java.util.ArrayList;
import java.util.List;

/*
 * ȸ�� ���
 * ȸ�� ����
 * ȸ�� ���� ����
 * ȸ�� ����
 * ȸ�� ����Ʈ
 */
public class Main {
	private List<User> database = new ArrayList<User>();
	
	//ȸ�� ���
	//id�� 0 �̻��� ��, �������� ���� �ƴϸ鼭 null X
	private boolean createUser(int id, String password, String name, String telNumber) {
		//�Ķ���� ���� ����
		if(id < 0) {
			return false;
		}
		if(password.isEmpty() || name.isEmpty() || telNumber.isEmpty()) {
			return false;
		}
		if(password == null || name == null || telNumber == null) {
			return false;
		}
		
		//�ߺ� ���̵� Ȯ��
		if(checkOverlap(id)) {
			return false;
		}
		
		//������ü ����
		User user = new User(id, password, name, telNumber);
		database.add(user);
		
		database.add(user);
		
		return true;
	}
	
	//����
	private User readUser(int id) {
		//�Ķ���Ͱ� ���� ������ Ȯ��
		if(id < 0) {
			return null;
		}
		//database���� id�� �˻�
		User user = selectUser(id);
		//�˻� ��� ��ȯ
		return null;	
	}
	
	//���� ����
	private User updateUser(UpdateUserDto dto) {
		int id = dto.getId();
		//�Էµ� id �� ����
		if(id < 0) return null;
		//�����ͺ��̽����� �Է¹��� id�� �ش��ϴ� user������ �ҷ���
		User user = selectUser(id);
		//�Է¹��� id�� �ش��ϴ� user������ �ִ��� ����
		if(user == null) return null;
		//�Է¹��� �н������ϰ� �ش� ������ �н����尡 ������ ����
		String password = dto.getPassword();
		if(!password.equals(user.getPassword())) {
			return null;
		}
		
		//���� ���� ����
		String name = dto.getName();
		String telNumber = dto.getTelNumber();
		user.setName(name);
		user.setTelNumber(telNumber);
		
		return user;
	}
	
	//����
	private boolean deleteUser(int id) {
		//�Է¹��� id�� ����
		if(id < 0) return false;
		//�Է¹��� id�� �ش��ϴ� user�� �ε����� ������
		int index = getUserIndex(id);
		//index�� -1���� ����
		if(index == -1) return false;
		//database���� �ش� �ε��� ��� ����
		database.remove(index);
		
		return true;
	}
	
	//����Ʈ
	private List<User> getUserList(){
		return database;
	}
	
	//main method
	public static void main(String[] args) {
	}
	
	//ȸ�����̵� �ߺ� Ȯ�� �޼ҵ�
	private boolean checkOverlap(int id) {
		for(User user : database) {
			if(user.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	//Ư�� ȸ�� ���̵� database���� �˻��ϴ� �޼ҵ�
	private User selectUser(int id) {
		for(int i = 0; i < database.size(); i++) {
			if(database.get(i).getId() == id) return database.get(i); 
		}
		return null;
	}
	
	//Ư�� ȸ�� ���̵� database���� �˻��Ͽ� �ش� �ε����� ��ȯ�ϴ� �޼���
	private int getUserIndex(int id) {
		for(int i = 0; i < database.size(); i++) {
			if(database.get(i).getId() == id) return i;
		}
		
		return -1;
	}
}
