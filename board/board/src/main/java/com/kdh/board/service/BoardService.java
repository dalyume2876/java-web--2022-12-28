package com.kdh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdh.board.common.constant.ResponseMessage;
import com.kdh.board.dto.request.board.PatchBoardDto;
import com.kdh.board.dto.request.board.PostBoardDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.board.DeleteBoardResponseDto;
import com.kdh.board.dto.response.board.GetBoardResponseDto;
import com.kdh.board.dto.response.board.GetListResponseDto;
import com.kdh.board.dto.response.board.GetMyListResponseDto;
import com.kdh.board.dto.response.board.PatchBoardResponseDto;
import com.kdh.board.dto.response.board.PostBoardResponseDto;
import com.kdh.board.entity.BoardEntity;
import com.kdh.board.entity.CommentEntity;
import com.kdh.board.entity.LikyEntity;
import com.kdh.board.entity.UserEntity;
import com.kdh.board.repository.BoardRepository;
import com.kdh.board.repository.CommentRepository;
import com.kdh.board.repository.LikyRepository;
import com.kdh.board.repository.UserRepository;

@Service
public class BoardService {

    @Autowired private BoardRepository boardRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private LikyRepository likyRepository;

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

    public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber) {

        GetBoardResponseDto data = null;

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);
            List<LikyEntity> likyList = likyRepository.findByBoardNumber(boardNumber);
            List<CommentEntity> commentList = commentRepository.findByBoardNumberOrderByWriteDatetimeDesc(boardNumber);
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
}
