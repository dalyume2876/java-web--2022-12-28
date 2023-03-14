package com.kdh.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdh.board.entity.LikyEntity;
import com.kdh.board.entity.primaryKey.LikyPK;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPK>{
    
}
