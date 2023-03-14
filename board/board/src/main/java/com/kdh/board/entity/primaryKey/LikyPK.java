package com.kdh.board.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class LikyPK implements Serializable{
    @Column(name="user_email")
    private String useEmail;
    @Column(name = "board_number")
    private int boardNumber;
}
