package com.bulletinboard.bulletinboard.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="board_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String name;
//    private String email;
//    private String message;
    private String username;
    private String title;
    private String content;
    private String img_url;

    @Temporal(TemporalType.DATE)
    private Date yyyymmdd;


}
