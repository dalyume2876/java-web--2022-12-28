package src;

import java.util.List;

import Database.DAO.BoardDAO;
import Database.Entity.BoardEntity;
import dto.DeleteBoardDTO;
import dto.UpdateBoardBTO;
import dto.insertBoardDTO;

public class BoardService {

	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public int postBoard(insertBoardDTO insertBoardDAO) {
		return boardDAO.insert(insertBoardDAO);
		
	}
	
	public List<BoardEntity> getBoardList() {
		return boardDAO.find();
	}
	
	public int patchBoard(UpdateBoardBTO updateBoardBTO) {
		Integer id = updateBoardBTO.getId();
		//�����ϴ� Board id ���� ����
		BoardEntity boardEntity = boardDAO.findById(id);
		if(boardEntity == null) {
			System.out.println("Does Not Exist Board");
			return 0;
		}
		
		return boardDAO.update(updateBoardBTO);
	}
	
	public int deleteBoard(DeleteBoardDTO deleteBoardDTO) {
		return boardDAO.delete(deleteBoardDTO);
	}
}
