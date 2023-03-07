package com.example.springboot_study_02.Controller;

import com.example.springboot_study_02.Entity.Note;
import com.example.springboot_study_02.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class noteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/api/note/add")
    public void addNote(@RequestBody Note note){
        System.out.println(note.getTitle());
        noteService.addNote(note);

    }


}
