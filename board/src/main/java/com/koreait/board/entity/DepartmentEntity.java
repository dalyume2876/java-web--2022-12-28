package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Department")
@Table(name="Department")
public class DepartmentEntity {
    @Id
    //부서코드
    private String departmentCode;
    // 부서명
    private String name;
    // 부서명
    private int cheif;
    // 부서장 사번
    private String telNumber;
    // 부서장 전번 
}
