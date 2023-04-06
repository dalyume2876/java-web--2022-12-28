package com.kdh.board.service;

import javax.validation.Valid;

import com.kdh.board.dto.request.user.PatchProfileDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.user.GetUserResponseDto;
import com.kdh.board.dto.response.user.PatchProfileResponseDto;

public interface UserService {
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, @Valid PatchProfileDto requestBody);
    public ResponseDto<GetUserResponseDto> getUser(String email);

    public ResponseDto<?> validateEmail(ValidateEmailDto dto);
    public ResponseDto<?> validateNickname(ValidateNicknameDto dto);
    public ResponseDto<?> validateTelNumber(ValidateTelNumber dto);
    
}
