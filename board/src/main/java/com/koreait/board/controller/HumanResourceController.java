package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponceDto;
import com.koreait.board.service.HumanResourceService;

@RestController
@RequestMapping("/apis/hr")
public class HumanResourceController {
    
    @Autowired private HumanResourceService humanResourceService;

    private static final String POST_HUMAN_RESOURCE = "/";
    private static final String GET_HUMAN_RESOURCE = "/{employeeNumber}";

    @PostMapping(POST_HUMAN_RESOURCE)
    //? http://localhost:4040/apis/hr/
    //? POST 설정 body 누르고 raw 그리고 JSON 
    // {
    //     "position" : "사원",
    //     "name" : "dalyume",
    //     "age" : 20,
    //     "gender" : "남",
    //     "academicAbility" : "대졸",
    //     "birth" : "040629",
    //     "telNumber" : "010-2222-2222",
    //     "address" : "부산광역시 진구",
    //     "addressDetail" : "코리아아이티",
    //     "joinDate" : "2023-03-07",
    //     "annualIncome" : 3000
    // }
    public ResponseDto<PostHumanResourceResponceDto> postHumanResource(@Valid @RequestBody PostHumanResourceRequestDto requestBody) {
        ResponseDto<PostHumanResourceResponceDto> response = humanResourceService.poseHumanResource(requestBody);

        return response;
    }

    @GetMapping(GET_HUMAN_RESOURCE)
    //? http://localhost:4040/apis/hr/사번
    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(@PathVariable("employeeNumber") int employeeNumber){
        ResponseDto<GetHumanResourceResponseDto> response = humanResourceService.getHumanResource(employeeNumber);

        return response;
    }

}
