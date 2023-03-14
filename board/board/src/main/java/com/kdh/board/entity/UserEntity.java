package com.kdh.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kdh.board.dto.request.auth.SignUpDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
    @Id
    private String email;
    private String nickname;
    private String telNumber;
    private String address;
    private String password;

    public UserEntity(SignUpDto dto){
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.telNumber =dto.getTelNumber();
        this.address = dto.getAddress();
        this.password = dto.getPassword();
    }

}
