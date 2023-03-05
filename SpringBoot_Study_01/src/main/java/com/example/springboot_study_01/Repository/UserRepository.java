package com.example.springboot_study_01.Repository;

import com.example.springboot_study_01.Entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Integer> {

    Optional<SiteUser> findByusername(String username);

}
