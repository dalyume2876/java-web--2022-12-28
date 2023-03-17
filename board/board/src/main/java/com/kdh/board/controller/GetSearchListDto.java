package com.kdh.board.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetSearchListDto {
    private String searchWord;
    private String previousSearchWord;
}