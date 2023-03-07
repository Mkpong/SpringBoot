package com.example.springboot_study_02.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="note")

public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;

}
