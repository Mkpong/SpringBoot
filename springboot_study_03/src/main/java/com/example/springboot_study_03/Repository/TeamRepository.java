package com.example.springboot_study_03.Repository;

import com.example.springboot_study_03.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
