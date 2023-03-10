package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.dto.request.humanResource.PatchHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PatchHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponceDto;
import com.koreait.board.service.HumanResourceService;


@RestController
@RequestMapping("/apis/hr")
public class HumanResourceController {
    
    @Autowired private HumanResourceService humanResourceService;

    private static final String POST_HUMAN_RESOURCE = "/";
    private static final String GET_HUMAN_RESOURCE = "/{employeeNumber}";
    private static final String PATCH_HUMAN_RESOURCE = "/";

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
    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(@AuthenticationPrincipal String sub, @PathVariable("employeeNumber") int employeeNumber){
        ResponseDto<GetHumanResourceResponseDto> response = humanResourceService.getHumanResource(employeeNumber);

        return response;
    }

    @PatchMapping(PATCH_HUMAN_RESOURCE)
    //? PATCH http://localhost:4040/apis/hr/
    // {
    //     "employeeNumber" : 1,
    //     "position" : "사원",
    //     "name" : "dalyume",
    //     "age" : 20,
    //     "gender" : "남",
    //     "academicAbility" : "대졸",
    //     "birth" : "2023-02-02",
    //     "telNumber" : "010-1111-2222",
    //     "address" : "부산광역시 진구",
    //     "addressDetail" : "KoreaIT",
    //     "joinDate" : "2023-03-27",
    //     "resignationdate" : null,
    //     "department" : 1,
    //     "annualIncome" : 3000,
    //     "note" : null
    // }
    public ResponseDto<PatchHumanResourceResponseDto> patchHumanResource(@Valid @RequestBody PatchHumanResourceRequestDto requestBody){
        ResponseDto<PatchHumanResourceResponseDto> response = humanResourceService.patchHumanResource(requestBody);
        return response;
    }

}
