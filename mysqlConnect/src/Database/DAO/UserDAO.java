package Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.Entity.UserEntity;
import index.DatabaseConnector;

public class UserDAO {
	
	//�����ͺ��̽����� User ���̺� �� id�� �Է¹��� ���� �ش��ϴ� ���ڵ带 ��� �÷��� ������ ��ȯ
	//SQL : SELECT * FROM User WHERE id = ?;
	//���� ��ȯ �� : 0 �Ǵ� 1���� ���ڵ�
	
	//find ~~ : ����� �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//exists ~~ : ����� ���翩�θ� boolean ���·� ��ȯ�ϴ� �޼���
	public UserEntity findById(Integer id) {
		UserEntity result = null;
		
		final String SQL = "SELECT * FROM User WHERE id = ?;";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				String password = resultSet.getString(2);
				String name = resultSet.getString(3);
				String telNumber = resultSet.getString(4);
				
				result = new UserEntity(id, password, name, telNumber);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if(preparedStatement != null && !preparedStatement.isClosed()) {
					resultSet.close();
				}
				if(connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
