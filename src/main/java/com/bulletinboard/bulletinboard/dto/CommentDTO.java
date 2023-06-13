package com.bulletinboard.bulletinboard.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
public class CommentDTO {

//    private Long board_id;
    private String username;

    private String content;

    private Date yyyymmdd;

    public CommentDTO(String username, String content, Date yyyymmdd) {
        this.username = username;
        this.content = content;
        this.yyyymmdd = yyyymmdd;
    }
}
