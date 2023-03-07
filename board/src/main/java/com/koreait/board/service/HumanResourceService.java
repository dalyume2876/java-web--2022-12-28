package com.koreait.board.service;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.Repository.DepartmentRepository;
import com.koreait.board.Repository.EmployeeRepository;
import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponceDto;
import com.koreait.board.entity.EmployeeEntity;

// import static com.koreait.board.common.constant.ResponseMessage.EXIST_PHONE_NUMBER;
@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponceDto> poseHumanResource(PostHumanResourceRequestDto dto){

        PostHumanResourceResponceDto data = null;

        String telNumber = dto.getTelNumber();
        String departmentCode = dto.getDepartment();

        try {
            boolean hasTelNumber = employeeRepository.existsByTelNumber(telNumber);
            if(hasTelNumber) return ResponseDto.setFail(ResponseMessage.EXIST_PHONE_NUMBER);

            if(departmentCode != null){
                boolean hasDepartment = departmentRepository.existsById(departmentCode);
                if(!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);
            }

            EmployeeEntity employeeEntity = new EmployeeEntity(dto);
            employeeRepository.save(employeeEntity);

            
        data = new PostHumanResourceResponceDto(employeeEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(int employeeNumber){

        GetHumanResourceResponseDto data = null;

        try {
            // boolean hasEmployee = employeeRepository.existsById(employeeNumber);
            // if(!hasEmployee) return ResponseDto.setFail("존재 X")
            // EmployeeEntity employeeEntity = employeeRepository.findById(employeeNumber).get();

            EmployeeEntity employeeEntity = employeeRepository.findByEmployeeNumber(employeeNumber);
            if(employeeEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            data = new GetHumanResourceResponseDto(employeeEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}
