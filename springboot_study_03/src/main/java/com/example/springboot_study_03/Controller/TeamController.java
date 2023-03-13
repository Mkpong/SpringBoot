package com.example.springboot_study_03.Controller;

import com.example.springboot_study_03.Entity.SiteUser;
import com.example.springboot_study_03.Entity.Team;
import com.example.springboot_study_03.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamservice;

    @PostMapping("/api/team/create")
    public String createTeam(@RequestBody Team team){
        teamservice.createTeam(team);
        return "Create Success";
    }

    @GetMapping("/api/team/list")
    public List<Team> teamlist(){
        return teamservice.teamlist();
    }

    @PostMapping("/api/team/register/{id}")
    public void teamregister(@PathVariable("id") Integer id , Principal principal){
        if(principal != null){
            teamservice.updateTeam(id , principal.getName());
        }
    }

    @GetMapping("/api/team/view/{id}")
    public List<SiteUser> teamview(@PathVariable("id") Integer id){
        return teamservice.teamview(id);
    }

    @PostMapping("/api/team/delete/{id}")
    public void teamdelete(@PathVariable("id") Integer id){
        teamservice.teamdelete(id);
    }

    @PostMapping("/api/member/delete/{member_id}/{team_id}")
    public void memberdelete(@PathVariable("member_id") Integer member_id , @PathVariable("team_id") Integer team_id){
        teamservice.memberdelete(team_id , member_id);
    }

}
