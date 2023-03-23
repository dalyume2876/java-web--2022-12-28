package com.kdh.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdh.board.common.constant.ApiPattern;
import com.kdh.board.dto.request.auth.SignInDto;
import com.kdh.board.dto.request.auth.SignUpDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.auth.SignInResponseDto;
import com.kdh.board.dto.response.auth.SignUpResponseDto;
import com.kdh.board.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(ApiPattern.AUTH)
@Api(description = "인증 모듈")
public class AuthController {
    @Autowired private AuthService authService;

    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "/sign-in";

    @ApiOperation(value="회원가입", notes="이메일, 비밀번호, 닉네임, 전화번호, 주소를 입력하여 회원을 등록하고, 성공 시에는 회원가입 성공 여부에 true가 반환됨")
    @PostMapping(SIGN_UP)
    public ResponseDto<SignUpResponseDto> signUp(@Valid @RequestBody SignUpDto requestBody) {
        ResponseDto<SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @ApiOperation(value = "로그인", notes = "아이디와 비밀번호를 입력하면 일치할 경우, 회원 정보와 토큰 그리고 토큰 만료기간을 반환하고 ")
    @PostMapping(SIGN_IN)
    public ResponseDto<SignInResponseDto> signIn(@Valid @RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }
}
