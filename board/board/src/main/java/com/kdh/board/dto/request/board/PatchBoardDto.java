package com.kdh.board.dto.request.board;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardDto {
    
    @ApiModelProperty(value = "게시물 번호", example = "1", required = true)
    @Min(1)
    private int boardNumber;
    
    @ApiModelProperty(value = "게시물 제목", example = "modified title", required = true)
    @NotBlank
    private String boardTitle;
    
    @ApiModelProperty(value = "게시물 내용", example = "modified content", required = true)
    @NotBlank
    private String boardContent;
    
    @ApiModelProperty(value = "게시물 IMAGE URL", example = "http://~", required = false)
    private String boardImgUrl;
}