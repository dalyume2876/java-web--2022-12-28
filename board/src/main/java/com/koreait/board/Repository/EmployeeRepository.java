package com.koreait.board.Repository;

import org.springframework.stereotype.Repository;

import com.koreait.board.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;   

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
    public boolean existsByTelNumber(String telNumber);
    public EmployeeEntity findByEmployeeNumber(int employeeNumber);
    
    
}
