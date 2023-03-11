package com.example.springboot_study_02.Service;

import com.example.springboot_study_02.Entity.Note;
import com.example.springboot_study_02.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note){
        noteRepository.save(note);
    }

    public List<Note> notelist(){
        return noteRepository.findAll();
    }

    public Note findbyId(Integer id){
        Note note_ = noteRepository.findById(id).get();
        return note_;
    }

    public void noteDelete(Integer id){
        noteRepository.deleteById(id);
    }


}
