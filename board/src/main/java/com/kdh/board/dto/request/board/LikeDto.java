package com.kdh.board.dto.request.board;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDto {
    
    @ApiModelProperty(value = "게시물 번호", example = "1", required = true)
    @Min(1)
    private int boardNumber;
    
}
