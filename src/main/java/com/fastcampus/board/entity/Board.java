package com.fastcampus.board.entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class Board extends TimeEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long seq; // PK

//    @Column(length = 20, nullable = false)
    private String title;

//    @Column(length = 200, nullable = false)
    private String writer;

//    @Column(length = 2000, nullable = false)
    private String content;

//    @CreatedDate
//    @Column(updatable = false)
    private LocalDateTime reg_date = LocalDateTime.now();



    @Builder
    public Board(String title, String content, String writer, LocalDateTime reg_date) {
   //     this.seq = seq;
        this.title = title;
        this.content = content;
        this.writer = writer;
    //    this.reg_date = reg_date;

    }

    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.reg_date = LocalDateTime.now();
    }
}