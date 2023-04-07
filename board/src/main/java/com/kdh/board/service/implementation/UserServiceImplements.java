package com.kdh.board.service.implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdh.board.common.constant.ResponseMessage;
import com.kdh.board.dto.request.board.PostBoardDto;
import com.kdh.board.dto.request.user.PatchProfileDto;
import com.kdh.board.dto.request.user.ValidateEmailDto;
import com.kdh.board.dto.request.user.ValidateNicknameDto;
import com.kdh.board.dto.request.user.ValidateTelNumberDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.board.PostBoardResponseDto;
import com.kdh.board.dto.response.user.GetUserResponseDto;
import com.kdh.board.dto.response.user.PatchProfileResponseDto;
import com.kdh.board.dto.response.user.ValidateEmailResponseDto;
import com.kdh.board.dto.response.user.ValidateNicknameResponseDto;
import com.kdh.board.dto.response.user.ValidateTelNumberResponseDto;
import com.kdh.board.entity.UserEntity;
import com.kdh.board.repository.UserRepository;
import com.kdh.board.service.UserService;

@Service
public class UserServiceImplements implements UserService{
    @Autowired private UserRepository userRepository;

    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, @Valid PatchProfileDto requestBody) {
        return null;
    }

    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto) {
        ValidateEmailResponseDto data = null;

        String email = dto.getEmail();

        try {
            boolean hasEmail = userRepository.existsByEmail(email);
            data = new ValidateEmailResponseDto(!hasEmail);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto requestBody) {
        ValidateNicknameResponseDto data = null;

        String nickname = requestBody.getNickname();

        try {
            boolean hasNickname = userRepository.existsByNickname(nickname);
            data = new ValidateNicknameResponseDto(!hasNickname);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateTelNumberDto dto) {
        ValidateTelNumberResponseDto data = null;

        String telNumber = dto.getTelNumber();

        try {
            boolean hasTelNumber = userRepository.existsByEmail(telNumber);
            data = new ValidateTelNumberResponseDto(!hasTelNumber);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

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
