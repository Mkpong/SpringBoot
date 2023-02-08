
package com.example.login.repository;

import com.example.login.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , String> {
    //JPARepository<1 , 2> -> 1은 데이터 형식 2는 id값의 자료형
}

