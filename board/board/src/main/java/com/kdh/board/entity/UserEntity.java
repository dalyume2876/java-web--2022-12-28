package com.kdh.board.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.catalina.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = User)
@Table(name = User)
public class UserEntity {
    
}
