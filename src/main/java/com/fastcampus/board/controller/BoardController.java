package com.fastcampus.board.controller;

import com.fastcampus.board.dto.BoardDto;
import com.fastcampus.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    // TODO BoardController는 JSP를 이용한 화면 로직과 연결되어 있습니다.
    //  다른 부분은 바꾸지 말고 TODO 부분만 작성해주시기를 권장합니다 :)
    // TODO please write code on only TODO part in BoardController

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String createPost(@ModelAttribute("command") BoardDto postDto){
        boardService.savePost(postDto);
        return "redirect:/"; // 추가 후 홈 화면으로
    }

    @RequestMapping("/")
    public String ReadAllPost(Model model){
        // List<PostDto> postList = /* TODO 게시물 전체를 받아오는 로직 */

        /* 게시글 목록 */

        List<BoardDto> boardList = boardService.getBoardlist();

        // *****************************************

        model.addAttribute("boardList", boardList);
        return "index";
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("command") BoardDto postDto){
        boardService.update(postDto);
        return "redirect:/"; // 추가 후 홈 화면으로

    }

    @RequestMapping(value="/delete/{seq}", method = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
    public String deletePost(@PathVariable("seq") long seq){
        boardService.deletePost(seq);
        return "redirect:/";
    }

    @RequestMapping(value="/detailView/{seq}" , method = RequestMethod.GET)
    public String Detail(@PathVariable("seq") long seq, Model model){
        BoardDto boardDto = boardService.getPost(seq);
        boardService.updateCnt(boardDto);
        model.addAttribute("command", boardDto);
        return "detail";
    }

    // ***************************************************************************************************
    // ******************************************* Do not edit *******************************************
    // 아래 부분은 수정 안하셔도 됩니다. (글 생성, 글 업데이트 창으로 연결하는 부분)

    @RequestMapping(value="/createView")
    public String ViewCreate(Model model){
        model.addAttribute("command", new BoardDto());
        return "create";
    }

    @RequestMapping(value="/updateView/{seq}" , method = RequestMethod.GET)
    public String ViewUpdate(@PathVariable("seq") long seq, Model model){
        BoardDto boardDto = boardService.getPost(seq);
        model.addAttribute("command", boardDto);
        return "update";
    }

//    @GetMapping("/hello")
//    public String hello()   {
//        return "hello";
//    }

//    @RequestMapping(value="/hello", method = RequestMethod.GET)
//    public String hello()   {
//        return "hello";
//    }
}

