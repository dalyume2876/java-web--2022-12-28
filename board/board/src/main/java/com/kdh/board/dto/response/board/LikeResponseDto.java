package com.kdh.board.dto.response.board;

import java.util.List;

import com.kdh.board.entity.BoardEntity;
import com.kdh.board.entity.CommentEntity;
import com.kdh.board.entity.LikyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDto {
    private BoardEntity board;
    private List<CommentEntity> commentList;
    private List<LikyEntity> likeList;
}
