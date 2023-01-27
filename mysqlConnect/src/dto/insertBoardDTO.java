package dto;

public class insertBoardDTO {
	
	private String boardTitle;
	private String boardContent;
	private Integer boardDateTime;
	private Integer boardWriter;
	
	

	public insertBoardDTO(String boardTitle, String boardContent, Integer boardDateTime, Integer boardWriter) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDateTime = boardDateTime;
		this.boardWriter = boardWriter;
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




	public Integer getBoardDateTime() {
		return boardDateTime;
	}




	public void setBoardDateTime(Integer boardDateTime) {
		this.boardDateTime = boardDateTime;
	}




	public Integer getBoardWriter() {
		return boardWriter;
	}




	public void setBoardWriter(Integer boardWriter) {
		this.boardWriter = boardWriter;
	}




	@Override
	public String toString() {
		return "insertBoardDTO [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDateTime="
				+ boardDateTime + ", boardWriter=" + boardWriter + "]";
	}
	
	
	
}
