package com.kdh.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.kdh.board.entity.primaryKey.LikyPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Liky")
@Table(name="Liky")
@IdClass(LikyPK.class)
public class LikyEntity {
    
    @Id
    private String userEmail;
    @Id
    private int boardNumber;
    
    private String userProfileUrl;
    private String userNickname;

    public LikyEntity(UserEntity userEntity, int boardNumber){
        this.userEmail = userEntity.getEmail();
        this.boardNumber = boardNumber;
        this.userProfileUrl = userEntity.getProfile();
        this.userNickname = userEntity.getNickname();
    }
}
