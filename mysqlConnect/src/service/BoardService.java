package service;

import Database.DAO.BoardDAO;
import Database.DAO.UserDAO;
import Database.Entity.UserEntity;
import dto.insertBoardDTO;

public class BoardService {

	private BoardDAO boardDAO;
	private UserDAO userDAO;
	
	public BoardService() {
		this.boardDAO = new BoardDAO();
		this.userDAO = new UserDAO();
	}
	
	public int postBoard(insertBoardDTO insertBoardDTO) {
		
		UserEntity userEntity = userDAO.findById(insertBoardDTO.getBoardWriter());
		if(userEntity == null) return 0;
		
		return boardDAO.insert(insertBoardDTO);
	}
	
	
}
