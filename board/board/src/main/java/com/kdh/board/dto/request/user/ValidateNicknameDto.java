package com.kdh.board.dto.request.user;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "유저 닉네임 중복체크 Request Body")
@Data
@NoArgsConstructor
public class ValidateNicknameDto {
    @ApiModelProperty(value = "유저 닉네임", example = "나는 바보다.", required = true)
    @Max(15)
    @NotBlank
    private String nickname;
}
