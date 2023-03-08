package com.example.springboot_study_02.Controller;

import com.example.springboot_study_02.Entity.Note;
import com.example.springboot_study_02.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class noteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/api/note/add")
    public void addNote(@RequestBody Note note){
        System.out.println(note.getTitle());
        noteService.addNote(note);
    }

    @GetMapping("/api/note/list")
    public List<Note> notelist(Model model){
        List<Note> notelist;
        notelist = noteService.notelist();
        return notelist;
    }

    @GetMapping("/api/note/view/{id}")
    public Note noteView(@PathVariable("id") Integer id){
        return noteService.findbyId(id);
    }

}
