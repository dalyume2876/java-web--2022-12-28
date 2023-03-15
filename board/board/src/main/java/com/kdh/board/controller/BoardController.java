package com.kdh.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kdh.board.dto.request.board.PostBoardDto;
import com.kdh.board.dto.response.ResponseDto;
import com.kdh.board.dto.response.board.PostBoardResponseDto;
import com.kdh.board.service.BoardService;

public class BoardController {
    @Autowired private BoardService boardService;

    private final String POST_BOARD = "";

    @PostMapping(POST_BOARD)
    public ResponseDto<PostBoardResponseDto> postBoard(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PostBoardDto requestBody
    ) {
        ResponseDto<PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
        return response;
    }
}
