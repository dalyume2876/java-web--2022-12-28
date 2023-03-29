package com.kdh.board.service.implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdh.board.common.constant.ResponseMessage;
import com.kdh.board.dto.request.board.PostBoardDto;
import com.kdh.board.dto.request.user.PatchProfileDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.board.PostBoardResponseDto;
import com.kdh.board.dto.response.user.GetUserResponseDto;
import com.kdh.board.dto.response.user.PatchProfileResponseDto;
import com.kdh.board.entity.UserEntity;
import com.kdh.board.repository.UserRepository;
import com.kdh.board.service.UserService;

@Service
public class UserServiceImplements implements UserService{
    @Autowired private UserRepository userRepository;

    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardDto dto) {

        PostBoardResponseDto data = null;

        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);



        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, @Valid PatchProfileDto requestBody) {
        return null;
    }

    public ResponseDto<GetUserResponseDto> getUser(String email) {
        
        GetUserResponseDto data = null;

        try {
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_BOARD);

            data = new GetUserResponseDto(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
}
