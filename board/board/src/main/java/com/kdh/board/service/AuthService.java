package com.kdh.board.service;

import com.kdh.board.dto.request.auth.SignInDto;
import com.kdh.board.dto.request.auth.SignUpDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.auth.SignInResponseDto;
import com.kdh.board.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto);
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);
}
