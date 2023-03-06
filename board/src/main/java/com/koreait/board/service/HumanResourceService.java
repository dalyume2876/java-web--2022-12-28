package com.koreait.board.service;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.Repository.DepartmentRepository;
import com.koreait.board.Repository.EmployeeRepository;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponceDto;

@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponceDto> poseHumanResource(PostHumanResourceRequestDto dto){

        String telNumber = dto.getTelNumber();

        try {
            boolean hasTelNumber = employeeRepository.existByTelNumber(telNumber);
            if(hasTelNumber) return ResponseDto.setFail("Existed Telephone Number");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFail("Database Error");
        }

        PostHumanResourceResponceDto data = new PostHumanResourceResponceDto();
        return ResponseDto.setSuccess("Success", data);
    }

}
