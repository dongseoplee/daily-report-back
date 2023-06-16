package com.bulletinboard.bulletinboard.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
//@Builder //Builder 어노테이션으로인해 incompatible types: int cannot be converted to String 에러 발생
public class CommentDTO {

    private Long board_id;
    private String username;

    private String content;

    private Date yyyymmdd;

    public CommentDTO(Long board_id, String username, String content, Date yyyymmdd) {
        this.username = username;
        this.content = content;
        this.yyyymmdd = yyyymmdd;
        this.board_id = board_id;
    }
}
