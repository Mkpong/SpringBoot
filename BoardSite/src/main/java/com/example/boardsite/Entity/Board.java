package com.example.boardsite.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

}
