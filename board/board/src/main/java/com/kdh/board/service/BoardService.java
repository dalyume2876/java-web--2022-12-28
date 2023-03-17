package com.kdh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdh.board.common.constant.ResponseMessage;
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
import com.kdh.board.dto.response.board.LikeResponseDto;
import com.kdh.board.dto.response.board.PatchBoardResponseDto;
import com.kdh.board.dto.response.board.PostBoardResponseDto;
import com.kdh.board.dto.response.board.PostCommentResponseDto;
import com.kdh.board.entity.BoardEntity;
import com.kdh.board.entity.CommentEntity;
import com.kdh.board.entity.LikyEntity;
import com.kdh.board.entity.RelatedSearchWordEntity;
import com.kdh.board.entity.SearchWordLogEntity;
import com.kdh.board.entity.UserEntity;
import com.kdh.board.repository.BoardRepository;
import com.kdh.board.repository.CommentRepository;
import com.kdh.board.repository.LikyRepository;
import com.kdh.board.repository.RelatedSearchWordRepository;
import com.kdh.board.repository.SearchWordLogRepository;
import com.kdh.board.repository.UserRepository;

@Service
public class BoardService {

    @Autowired private BoardRepository boardRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private LikyRepository likyRepository;
    @Autowired private SearchWordLogRepository searchWordLogRepository;
    @Autowired private RelatedSearchWordRepository relatedSearchWordRepository;

    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardDto dto) {

        PostBoardResponseDto data = null;

        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = new BoardEntity(userEntity, dto);
            boardRepository.save(boardEntity);

            data = new PostBoardResponseDto(boardEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<LikeResponseDto> like(String email, LikeDto dto){

        LikeResponseDto data = null; 

        int boardNumber = dto.getBoardNumber();
        
        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            LikyEntity likyEntity = likyRepository.findByUserEmailAndBoardNumber(email, boardNumber);
            if(likyEntity == null){
                likyEntity = new LikyEntity(userEntity, boardNumber);
                likyRepository.save(likyEntity);
                boardEntity.increaseLikeCount();
            }else{
                likyRepository.delete(likyEntity);
                boardEntity.decreaseLikeCount();
            }

            boardRepository.save(boardEntity);

            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);
            List<LikyEntity> likeList = likyRepository.findByBoardNumber(boardNumber);

            data = new LikeResponseDto(boardEntity, commentList, likeList);
            

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<PostCommentResponseDto> postComment(String eamil, PostCommentDto dto){
        PostCommentResponseDto data = null;

        int boardNumber = dto.getBoardNumber();

        try {

            UserEntity userEntity = userRepository.findByEmail(eamil);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            CommentEntity commentEntity = new CommentEntity(userEntity, dto);
            commentRepository.save(commentEntity);

            boardEntity.increaseCommentCount();
            boardRepository.save(boardEntity);

            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);
            List<LikyEntity> listList = likyRepository.findByBoardNumber(boardNumber);

            data = new PostCommentResponseDto(boardEntity, commentList, listList);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber) {

        GetBoardResponseDto data = null;

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);
            List<LikyEntity> likyList = likyRepository.findByBoardNumber(boardNumber);
            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);
            
            boardEntity.increaseViewCount();
            boardRepository.save(boardEntity);
            
            data = new GetBoardResponseDto(boardEntity, commentList, likyList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<List<GetListResponseDto>> getList() {

        List<GetListResponseDto> data = null;

        try {

            List<BoardEntity> boardEntityList = boardRepository.findByOrderByBoardWriteDatetimeDesc();
            data = GetListResponseDto.copyList(boardEntityList);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
    public ResponseDto<PatchBoardResponseDto> patchBoard(String email, PatchBoardDto dto) {

        PatchBoardResponseDto data = null;

        int boardNumber = dto.getBoardNumber();

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            boolean isEqualWriter = email.equals(boardEntity.getWriterEmail());
            if (!isEqualWriter) return ResponseDto.setFailed(ResponseMessage.NOT_PERMISSION);

            boardEntity.patch(dto);
            boardRepository.save(boardEntity);

            List<LikyEntity> likyList = likyRepository.findByBoardNumber(boardNumber);
            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);

            data = new PatchBoardResponseDto(boardEntity, commentList, likyList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<DeleteBoardResponseDto> deleteBoard(String email, int boardNumber) {

        DeleteBoardResponseDto data = null;

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            boolean isEqualWriter = email.equals(boardEntity.getWriterEmail());
            if (!isEqualWriter) return ResponseDto.setFailed(ResponseMessage.NOT_PERMISSION);

            boardRepository.delete(boardEntity);
            data = new DeleteBoardResponseDto(true);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<List<GetMyListResponseDto>> getMyList(String email) {

        List<GetMyListResponseDto> data = null;

        try {

            List<BoardEntity> boardList = boardRepository.findByWriterEmailOrderByBoardWriteDatetimeDesc(email);
            data = GetMyListResponseDto.copyList(boardList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(String searchWord, String previousSearchWord) {

        List<GetSearchListResponseDto> data = null;

        try {

            SearchWordLogEntity searchWordLogEntity = new SearchWordLogEntity(searchWord);
            searchWordLogRepository.save(searchWordLogEntity);

            if (previousSearchWord != null && !previousSearchWord.isBlank()) {
                RelatedSearchWordEntity relatedSearchWordEntity = new RelatedSearchWordEntity(searchWord, previousSearchWord);
                relatedSearchWordRepository.save(relatedSearchWordEntity);
            }

            List<BoardEntity> boardList = boardRepository.findByBoardTitleContainsOrBoardContentContainsOrderByBoardWriteDatetimeDesc(searchWord, searchWord);
            data = GetSearchListResponseDto.copyList(boardList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
}

