package Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.Entity.BoardEntity;
import dto.DeleteBoardDTO;
import dto.UpdateBoardBTO;
import dto.insertBoardDTO;
import index.DatabaseConnector;

//DAO : Data Access Object
//�����͹��̽��� �����ؼ� ������ �˻� �� ���� ���� �����ͺ��̽� �۾��� ����ϴ� Ŭ����
public class BoardDAO {

	//�����ͺ��̽��� Board ���̺��� �Է¹��� id�� �ش��ϴ� ���ڵ带 ��� �÷��� �����ؼ� ��ȯ�ϴ¸޼���
	// SQL : SELECT * FROM Board WHERE id = ?;
	//���� ��ȯ ��� : 0�� �Ǵ� 1���� ���ڵ�
	public BoardEntity findById(Integer id) {
		
		BoardEntity result = null;
		
		final String SQL = "SELECT * FROM Board WHERE id = ?;";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			String boardTitle = resultSet.getString(2);
			String boardContent = resultSet.getString(3);
			String boardDateTime = resultSet.getString(4);
			Integer boardLike = resultSet.getInt(5);
			Integer boardWriter = resultSet.getInt(6);
			
			result = new BoardEntity
					(id, boardTitle, boardContent, boardDateTime, boardLike, boardWriter);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null && !resultSet.isClosed())
					resultSet.close();
				if (preparedStatement != null && preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (connection != null && connection.isClosed()) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	//�����ͺ��̽��� Board���̺��� ��� �÷��� �����ؼ� ��ȯ�ϴ� �޼���
	//SQL : select * from Board;
	//����Ǵ� ��ȯ ����� 0�� �̻��� ����
	public List<BoardEntity> find() {
		List<BoardEntity> result = new ArrayList<BoardEntity>();
		
		final String SQL = "select * from Board";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null; 
		
		try {
			connection = DatabaseConnector.createConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String boardTitle = resultSet.getString(2);
				String boardContent = resultSet.getString(3);
				String boardDateTime = resultSet.getString(4);
				Integer boardLike = resultSet.getInt(5);
				Integer boardWriter = resultSet.getInt(6);
				
				BoardEntity entity = new BoardEntity(id, boardTitle, boardContent, boardDateTime, boardLike, boardWriter);
				result.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null && !connection.isClosed())
					connection.close();
				if(statement != null && !statement.isClosed())
					statement.close();
				if(resultSet != null && !resultSet.isClosed())
					resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}
	
	//�����ͺ��̽����� Board ���̺� ���ڵ带 ����
	//SQL : INSERT INTO Board(boardTitle, boardContent, boardDateTime, boardWriter) VALUES(?, ?, ?, ?);
	//����Ǵ� ��ȯ�� : 0 or 1
	public int insert(insertBoardDTO dto) {
		int result = 0;
		
		final String SQL = "INSERT INTO Board(boardTitle, boardContent, boardDateTime, boardWriter) VALUES(?, ?, ?, ?);";
		
		Connection connection = null;
		
		//PreparedStatement : �������� SQL���� ���� ������ �� �ֵ��� ��
		PreparedStatement preparedStatement = null;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			connection = DatabaseConnector.createConnection();
			//PreparedStatement ��ü ����
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, dto.getBoardTitle());
			preparedStatement.setString(2, dto.getBoardContent());
			preparedStatement.setString(3, simpleDateFormat.format(new Date()));
			preparedStatement.setInt(4, dto.getBoardWriter());
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null && !preparedStatement.isClosed()) 
					preparedStatement.close();
				if(connection != null && !connection.isClosed())
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// �����ͺ��̽����� board���̺��� ���ڵ� �� �Է¹��� id�� �ش��ϴ� ���ڵ���
	// title�� content�� �Է¹��� ������ ����
	// SQL : UPDATE Board SET boardTitle = ?, boardContent = ? where id = ?;
	// ����Ǵ� ��ȯ �� : 0 or 1
	public int  update(UpdateBoardBTO dto) {
		int result = 0;
		
		final String SQL = "UPDATE Board SET boardTitle = ?, boardContent = ? where id = ?;";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			
			preparedStatement.setString(1, dto.getBoardTitle());
			preparedStatement.setString(2, dto.getBoardContent());
			preparedStatement.setInt(3, dto.getId());
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null && !preparedStatement.isClosed())
					preparedStatement.close();
				if(connection != null && !connection.isClosed())
					connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	//�����ͺ��̽����� Board ���̺� �� �Է¹��� id�� �ش��ϴ� ���ڵ带 ����
	//SQL : DELETE FROM Board WHERE id = ?;
	//���� ��ȯ�� 0 or 1
	
	public int delete(DeleteBoardDTO dto) {
		int result = 0;
		
		final String SQL = "DELETE FROM Board WHERE id = ?;";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		
		try {
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, dto.getId());
			
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if(connection != null && !connection.isClosed())
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}









