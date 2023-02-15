package com.example.boardsite.Controller;


import com.example.boardsite.Entity.Board;
import com.example.boardsite.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    //게시판에 작성된 글의 목록을 보여줌
    public String boardList(Model model){
        List<Board> boardlist = boardService.boardList();
        model.addAttribute("board" , boardlist);
        return "Board/list";
    }

    @GetMapping("/board/write")
    //게시판 작성하는 곳
    public String boardWrite(){
        return "board/write";
    }


    @PostMapping("/board/write")
    //게시판에서 작성한 글을 DB에 전송
    public String boardWrite(Board board , Model model){
        boardService.write(board);

        model.addAttribute("message" , "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl" , "/board/list");

        return "message";
    }



    @GetMapping("/board/view")
    //특정 게시판의 글의 상세내용을 보여줌
    public String boardView(Model model , Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "board/view";
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
        return "Board/modify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(Model model , Board board , @PathVariable("id") Integer id ){

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        model.addAttribute("message" , "글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl" ,  "/board/list");

        return "message";
    }




}