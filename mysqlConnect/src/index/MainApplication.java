package index;

import java.util.List;
import java.util.Scanner;

import Database.DAO.BoardDAO;
import Database.Entity.BoardEntity;
import dto.DeleteBoardDTO;
import dto.UpdateBoardBTO;
import dto.insertBoardDTO;
import src.BoardService;

public class MainApplication {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		BoardService boardService = new BoardService();
		
		if(path.equals("POST /board")) {
			/////////////////////////////////////////////////////////////
			//����ڷκ��� �Է��� ����.
			System.out.print("boardTitle : ");
			String boardTitle = scanner.nextLine();
			System.out.print("boardContent : ");
			String boardContent = scanner.nextLine();
			System.out.print("boardWriter : ");
			Integer boardWriter = scanner.nextInt();
			/////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////
			//�Է� ����
			if(boardTitle.isBlank() || boardContent.isBlank() || boardWriter < 0) {
				System.out.println("Insert Success");
			}
			/////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////
			//Service Layer ������ DTO ����
			insertBoardDTO insertBoardDTO = new insertBoardDTO(boardTitle, boardContent, boardWriter, boardWriter);
			/////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////
			//���� ����Ͻ� ������ �����ϱ� ���� Service�� �޼��带 ȣ��
			int result = boardService.postBoard(insertBoardDTO);
			/////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////
			//����Ͻ� ���� ����� ���� ������
			if(result == 1) System.out.println("Insert Success");
			else System.out.println("Insert failed");
			/////////////////////////////////////////////////////////////
			
		}else if(path.equals("GET /boardList")) {
			
			/////////////////////////////////////////////////////////////
			//���� ����Ͻ� ������ �����ϱ� ���� Service�� �޼��� ȣ��
			List<BoardEntity> boardList = boardService.getBoardList();
			/////////////////////////////////////////////////////////////
			
			/////////////////////////////////////////////////////////////
			//����Ͻ� ���� ����� �����.
			for(BoardEntity board : boardList)
				System.out.println(board.toString());
			
		}else if(path.equals("PATCH /board")) {
			/////////////////////////////////////////////////////////////
			//����ڷκ��� �Է��� ����.
			System.out.print("boardtitle: ");
			String boardTitle = scanner.nextLine();
			System.out.print("boardContent : ");
			String boardContent = scanner.nextLine();
			System.out.print("id : ");
			Integer id = scanner.nextInt();
			
			if(boardTitle.isBlank() || boardContent.isBlank() || id < 0) {
				System.out.println("Insert Success");
			}
			
			UpdateBoardBTO updateBoardBTO = new UpdateBoardBTO(id, boardTitle, boardContent);
			
			int result = boardService.patchBoard(updateBoardBTO);
			
			if(result == 1) System.out.println("update Success");
			else System.out.println("update failed");
			
		}else if(path.equals("DELETE /board")) {
			
			System.out.println("id : ");
			Integer id = scanner.nextInt();
			
			if(id < 0) System.out.println("Invalid Input");
			
			DeleteBoardDTO deleteBoardDTO = new DeleteBoardDTO(id);
			
			int result = boardService.deleteBoard(deleteBoardDTO);
			if(result == 1) System.out.println("Delete Success");
			else System.out.println("Delete Failed");
		}else {
			System.out.println("404 not found");
		}
	}
}









