package com.example.boardsite.Controller;

import com.example.boardsite.Entity.Board;
import com.example.boardsite.Entity.Comment;
import com.example.boardsite.Service.BoardService;
import com.example.boardsite.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardService boardService;

    @PostMapping("/comment/write/{id}")
    public String boardComment(Model model , @PathVariable("id") Integer id, @RequestParam String comment){
        Board board = this.boardService.boardView(id);
        Comment ncomment = new Comment();
        ncomment.setComment(comment);
        ncomment.setBoard(board);
        this.commentService.write(ncomment);
        return String.format("redirect:/board/view/%s" , board.getId());
    }

    @GetMapping("/comment/delete")
    public String commentDelete(Integer id){
        Comment comment = commentService.commentView(id);
        int board_id = comment.getBoard().getId();
        commentService.commentDelete(id);
        return String.format("redirect:/board/view/%s" , board_id);
    }
}
