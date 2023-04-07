package com.kdh.board.service;

import javax.validation.Valid;

import com.kdh.board.dto.request.user.PatchProfileDto;
import com.kdh.board.dto.request.user.ValidateEmailDto;
import com.kdh.board.dto.request.user.ValidateNicknameDto;
import com.kdh.board.dto.request.user.ValidateTelNumberDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.user.GetUserResponseDto;
import com.kdh.board.dto.response.user.PatchProfileResponseDto;
import com.kdh.board.dto.response.user.ValidateEmailResponseDto;
import com.kdh.board.dto.response.user.ValidateNicknameResponseDto;
import com.kdh.board.dto.response.user.ValidateTelNumberResponseDto;

public interface UserService {
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, @Valid PatchProfileDto requestBody);
    public ResponseDto<GetUserResponseDto> getUser(String email);
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto);
    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto);
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateTelNumberDto dto);

}
