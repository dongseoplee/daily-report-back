package com.bulletinboard.bulletinboard.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO {
    private String email;
    private String password;
    private String username;

    public UserDTO(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
