package com.example.springboot_study_03.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int size;

    @JsonIgnore //무한루프에 빠지는것 방지
    @OneToMany(mappedBy = "team")
    private List<SiteUser> members = new ArrayList<>();

}
