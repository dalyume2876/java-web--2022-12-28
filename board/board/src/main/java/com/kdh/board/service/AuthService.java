package com.kdh.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kdh.board.dto.request.auth.SignInDto;
import com.kdh.board.dto.request.auth.SignUpDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.auth.SignInResponseDto;
import com.kdh.board.dto.response.auth.SignUpResponseDto;
import com.kdh.board.provider.TokenProvider;
import com.kdh.board.repository.UserRepository;

public interface AuthService {

    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto);
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);
}
