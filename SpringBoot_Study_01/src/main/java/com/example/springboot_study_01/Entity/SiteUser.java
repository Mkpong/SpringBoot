package com.example.springboot_study_01.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="siteuser")
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

}
