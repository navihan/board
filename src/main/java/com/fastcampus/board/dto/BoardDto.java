package com.fastcampus.board.dto;
import com.fastcampus.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    // PostDto는 JSP 화면과 Spring 서버가 주고받는 객체입니다.
    // PostDto를 수정하시기보다는 Post 클래스를 만들어 사용하기를 권장합니다.
    private long seq;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime reg_date;

    public Board toEntity(){
        Board boardEntity = Board.builder()
        //        .seq(seq)
                .writer(writer)
                .title(title)
                .content(content)
                .reg_date(reg_date)
                .build();
        return boardEntity;
    }

    @Builder
    public BoardDto(Long seq, String title, String content, String writer, LocalDateTime reg_date) {
        this.seq = seq;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
    }
}
