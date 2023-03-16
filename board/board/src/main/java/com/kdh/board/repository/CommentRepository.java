package com.kdh.board.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdh.board.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    
    public List<CommentEntity> findByBoardNumberOrderByWriteDatetimeDesc(int boardNumber);

}