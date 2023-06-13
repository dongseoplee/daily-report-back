package com.bulletinboard.bulletinboard.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "board_data")
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

//    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
//    private List<Comment> commentList = new ArrayList<>();

}
