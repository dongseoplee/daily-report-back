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

//    private String name;
//    private String email;
//    private String message;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public BoardDTO(String name, String email, String message) {
//        this.name = name;
//        this.email = email;
//        this.message = message;
//    }
    private String username;
    private String title;
    private String content;
    private String img_url;

    private Date yyyymmdd;

    public BoardDTO(String username, String title, String content, String img_url, Date yyyymmdd) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.img_url = img_url;
        this.yyyymmdd = yyyymmdd;
    }
}
