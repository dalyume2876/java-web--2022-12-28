package board;

import java.util.ArrayList;
import java.util.List;

/*
 * 회원 등록
 * 회원 정보
 * 회원 정보 수정
 * 회원 삭제
 * 회원 리스트
 */
public class Main {
	private List<User> database = new ArrayList<User>();
	
	//회원 등록
	//id는 0 이상의 수, 나머지는 빈값이 아니면서 null X
	private boolean createUser(int id, String password, String name, String telNumber) {
		//파라미터 정상 검증
		if(id < 0) {
			return false;
		}
		if(password.isEmpty() || name.isEmpty() || telNumber.isEmpty()) {
			return false;
		}
		if(password == null || name == null || telNumber == null) {
			return false;
		}
		
		//중복 아이디 확인
		if(checkOverlap(id)) {
			return false;
		}
		
		//관리객체 생성
		User user = new User(id, password, name, telNumber);
		database.add(user);
		
		database.add(user);
		
		return true;
	}
	
	//정보
	private User readUser(int id) {
		//파라미터가 정상 값인지 확인
		if(id < 0) {
			return null;
		}
		//database에서 id를 검색
		User user = selectUser(id);
		//검색 결과 반환
		return null;	
	}
	
	//정보 수정
	private User updateUser(UpdateUserDto dto) {
		int id = dto.getId();
		//입력된 id 값 검증
		if(id < 0) return null;
		//데이터베이스에서 입력받은 id에 해당하는 user정보를 불러옴
		User user = selectUser(id);
		//입력받은 id에 해당하는 user정보가 있는지 검증
		if(user == null) return null;
		//입력받은 패스워드하고 해당 유저의 패스워드가 같은지 검증
		String password = dto.getPassword();
		if(!password.equals(user.getPassword())) {
			return null;
		}
		
		//유저 정보 변경
		String name = dto.getName();
		String telNumber = dto.getTelNumber();
		user.setName(name);
		user.setTelNumber(telNumber);
		
		return user;
	}
	
	//삭제
	private boolean deleteUser(int id) {
		//입력받은 id값 검증
		if(id < 0) return false;
		//입력받은 id에 해당하는 user의 인덱스를 가져옴
		int index = getUserIndex(id);
		//index가 -1인지 검증
		if(index == -1) return false;
		//database에서 해당 인덱스 요소 제거
		database.remove(index);
		
		return true;
	}
	
	//리스트
	private List<User> getUserList(){
		return database;
	}
	
	//main method
	public static void main(String[] args) {
	}
	
	//회원아이디 중복 확인 메소드
	private boolean checkOverlap(int id) {
		for(User user : database) {
			if(user.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	//특정 회원 아이디를 database에서 검색하는 메소드
	private User selectUser(int id) {
		for(int i = 0; i < database.size(); i++) {
			if(database.get(i).getId() == id) return database.get(i); 
		}
		return null;
	}
	
	//특정 회원 아이디를 database에서 검색하여 해당 인덱스를 반환하는 메서드
	private int getUserIndex(int id) {
		for(int i = 0; i < database.size(); i++) {
			if(database.get(i).getId() == id) return i;
		}
		
		return -1;
	}
}
