package com.fastcampus.board.service;

import com.fastcampus.board.dto.BoardDto;
import com.fastcampus.board.entity.Board;
import com.fastcampus.board.entity.BoardRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public List<BoardDto> getBoardlist() {
        List<Board> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( Board boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .seq(boardEntity.getSeq())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .cnt(boardEntity.getCnt())
                    .reg_date(boardEntity.getReg_date())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long seq) {
        Optional<Board> boardEntityWrapper = boardRepository.findById(seq);
        Board boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .seq(boardEntity.getSeq())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .cnt(boardEntity.getCnt())
                .reg_date(boardEntity.getReg_date())
                .build();

        return boardDTO;
    }


    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getSeq();
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public Long update(final BoardDto params) {

        Board entity = boardRepository.findById(params.getSeq()).orElse(null);
//
//        if (entity == null) {
//            throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
//        }

        entity.update(params.getTitle(), params.getContent(), params.getWriter(), params.getCnt());
        return params.getSeq();
    }


    @Transactional
    public void updateCnt(final BoardDto params) {

        Board entity = boardRepository.findById(params.getSeq()).orElse(null);
//
//        if (entity == null) {
//            throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
//        }

        entity.updateCnt(params.getCnt());
    }

    @Transactional
    public void deletePost(Long seq) {
        boardRepository.deleteById(seq);
    }
}