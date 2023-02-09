package com.example.login.controller;

import com.example.login.entitiy.Board;
import com.example.login.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    //게시판 작성하는 곳
    public String boardWrite(){
        return "board/boardwrite";
    }

    @PostMapping("/board/writepro")
    //게시판에서 작성한 글을 DB에 전송
    public String boardWritePro(Board board , Model model){
        boardService.write(board);

        model.addAttribute("message" , "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl" , "/board/list");

        return "message";
    }

    @GetMapping("/board/list")
    //게시판에 작성된 글의 목록을 보여줌
    public String boardList(Model model){
        model.addAttribute("list" , boardService.boardList());

        return "board/boardlist";
    }

    @GetMapping("/board/view")
    //특정 게시판의 글의 상세내용을 보여줌
    public String boardView(Model model , Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "board/boardview";
    }

    @GetMapping("/board/delete")
    //게시판의 글을 삭제
    public String boardDelete(Integer id , Model model){
        boardService.boardDelete(id);

        model.addAttribute("message" , "글 삭제가 완료되었습니다.");
        model.addAttribute("searchUrl" , "/board/list");
        return "message";
    }

    //글을 수정하는 메소드 구현
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id , Model model){

        model.addAttribute("board" , boardService.boardView(id));

        return "board/boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(Model model , Board board , @PathVariable("id") Integer id ){

        Board boardTemp = boardService.boardView(id);
        boardTemp.setName(board.getName());
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        model.addAttribute("message" , "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl" ,  "/board/list");

        return "message";
    }




}
