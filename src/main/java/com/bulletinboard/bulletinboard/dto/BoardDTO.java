package com.bulletinboard.bulletinboard.dto;

import com.bulletinboard.bulletinboard.domain.Board;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
//DTO 생성자 만들어야함
public class BoardDTO {

    private String username;
    private String title;
    private String content;
    private String img_url;
    private Date yyyymmdd;
    private String image;
    private String email;

    public BoardDTO(String username, String title, String content, String img_url, Date yyyymmdd, String image, String email) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.img_url = img_url;
        this.yyyymmdd = yyyymmdd;
        this.image = image;
        this.email = email;
    }
}
