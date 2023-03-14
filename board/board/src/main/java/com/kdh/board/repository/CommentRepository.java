package com.kdh.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdh.board.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,String>{
    
}
