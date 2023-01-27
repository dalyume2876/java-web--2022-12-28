package dto;

public class UpdateBoardBTO {

	private Integer id;
	private String boardTitle;
	private String boardContent;
	
	
	
	public UpdateBoardBTO(Integer id, String boardTitle, String boardContent) {
		super();
		this.id = id;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	


	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getBoardTitle() {
		return boardTitle;
	}




	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}




	public String getBoardContent() {
		return boardContent;
	}




	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}




	@Override
	public String toString() {
		return "UpdateBoardBTO [id=" + id + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + "]";
	}
	
	
	
	
}
