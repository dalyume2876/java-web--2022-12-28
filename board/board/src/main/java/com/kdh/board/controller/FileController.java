package com.kdh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdh.board.common.constant.ApiPattern;
import com.kdh.board.service.FIleService;

@RestController
@RequestMapping(ApiPattern.FILE)
public class FileController {
    
    @Autowired FIleService fIleService;

}
