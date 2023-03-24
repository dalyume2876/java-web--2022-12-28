package com.kdh.board.service;

import java.util.List;

import com.kdh.board.dto.request.board.LikeDto;
import com.kdh.board.dto.request.board.PatchBoardDto;
import com.kdh.board.dto.request.board.PostBoardDto;
import com.kdh.board.dto.request.board.PostCommentDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.board.DeleteBoardResponseDto;
import com.kdh.board.dto.response.board.GetBoardResponseDto;
import com.kdh.board.dto.response.board.GetListResponseDto;
import com.kdh.board.dto.response.board.GetMyListResponseDto;
import com.kdh.board.dto.response.board.GetSearchListResponseDto;
import com.kdh.board.dto.response.board.GetTop15RelatedSearchWordResponseDto;
import com.kdh.board.dto.response.board.GetTop15SearchWordResponseDto;
import com.kdh.board.dto.response.board.GetTop3ListResponseDto;
import com.kdh.board.dto.response.board.LikeResponseDto;
import com.kdh.board.dto.response.board.PatchBoardResponseDto;
import com.kdh.board.dto.response.board.PostBoardResponseDto;
import com.kdh.board.dto.response.board.PostCommentResponseDto;

public interface BoardService {
    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardDto dto);
    public ResponseDto<LikeResponseDto> like(String email, LikeDto dto);
    public ResponseDto<PostCommentResponseDto> postComment(String eamil, PostCommentDto dto);
    public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber);
    public ResponseDto<List<GetListResponseDto>> getList();
    public ResponseDto<List<GetTop3ListResponseDto>> getTop3List();
    public ResponseDto<GetTop15SearchWordResponseDto> getTop15SearchWord();
    public ResponseDto<GetTop15RelatedSearchWordResponseDto> getTop15RelatedSearchWord(String searchWord);
    public ResponseDto<PatchBoardResponseDto> patchBoard(String email, PatchBoardDto dto);
    public ResponseDto<DeleteBoardResponseDto> deleteBoard(String email, int boardNumber);
    public ResponseDto<List<GetMyListResponseDto>> getMyList(String email);
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(String searchWord, String previousSearchWord);
    
}
