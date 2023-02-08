package com.example.login.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="board")
public class Board {

    @Id
    private String id;
    private String name;
    private String title;
    private String text;

}
