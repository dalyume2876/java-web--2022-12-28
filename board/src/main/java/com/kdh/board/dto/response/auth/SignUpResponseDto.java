package com.kdh.board.dto.response.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@ApiModel(value="회원가입 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponseDto {
    @ApiModelProperty(value = "회원가입 결과", example = "true", required = true)
    private boolean status;
}
