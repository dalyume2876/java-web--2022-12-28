package com.kdh.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdh.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String> {
    
}
