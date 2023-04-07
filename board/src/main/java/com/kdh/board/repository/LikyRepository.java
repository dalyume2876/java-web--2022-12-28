package com.kdh.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kdh.board.entity.LikyEntity;
import com.kdh.board.entity.primaryKey.LikyPK;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPK> {
    
    public List<LikyEntity> findByBoardNumber(int boardNumber);
    public LikyEntity findByUserEmailAndBoardNumber(String userEmail, int boardNumber);
    
    @Transactional
    public void deleteByBoardNumber(int boardNumber);

}