package com.koreait.board.Repository;

import org.springframework.stereotype.Repository;

import com.koreait.board.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;   

@Repository
public class EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
    
}
