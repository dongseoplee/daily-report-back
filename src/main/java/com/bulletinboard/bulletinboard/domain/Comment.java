package com.bulletinboard.bulletinboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //JPA 에서 외래키 연결
//    @ManyToOne
//    @JoinColumn(name = "board_id", referencedColumnName = "id")
//    private Board board;
    private Long board_id;

    private String username;
    private String content;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date yyyymmdd;


}
