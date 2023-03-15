package com.kdh.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kdh.board.dto.request.user.PatchProfileDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.user.PatchProfileResponseDto;
import com.kdh.board.service.UserService;

public class UserController {
    @Autowired private UserService userService;

    private final String PATCH_PROFILE = "/profile";

    @PatchMapping(PATCH_PROFILE)
    public ResponseDto<PatchProfileResponseDto> patchProfile(
        @AuthenticationPrincipal String email, 
        @Valid @RequestBody PatchProfileDto requestBody
    ) {
        ResponseDto<PatchProfileResponseDto> response = userService.patchProfile(email, requestBody);
        return response;
    }
}
