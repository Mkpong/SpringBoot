
package com.example.login.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="userinfo") //테이블 이름 지정
public class User {

    @Id
    private String id;
    String password;
    String name;
    Integer sex; //male = 1 , female=2;
    Integer year,month,day;
    String email;

}

