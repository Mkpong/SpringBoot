package com.example.springboot_study_03.Service;

import com.example.springboot_study_03.Entity.SiteUser;
import com.example.springboot_study_03.Entity.Team;
import com.example.springboot_study_03.Repository.TeamRepository;
import com.example.springboot_study_03.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamrepository;

    @Autowired
    private UserRepository userrepository;

    public void createTeam(Team team){
        team.setSize(0);
        teamrepository.save(team);
    }

    public List<Team> teamlist(){
        return teamrepository.findAll();
    }

    public void updateTeam(Integer id , String username){
        Team team = teamrepository.findById(id).get();
        SiteUser user = userrepository.findByusername(username).get();
        int size = team.getSize();

        if(user.getTeam() != null) return ; //만약 팀이 있다면 팀추가를 하지 않음.

//        List<SiteUser> member = team.getMembers();
//        member.add(user);
//        team.setMembers(member);

        user.setTeam(team);
        team.setSize(size+1);

        teamrepository.save(team);
        userrepository.save(user);
    }

    public List<SiteUser> teamview(Integer id){
        Team team = teamrepository.findById(id).get();
        return team.getMembers();
    }

    public void teamdelete(Integer id){
        teamrepository.deleteById(id);
    }

    public void memberdelete(Integer team_id , Integer member_id){
        SiteUser user = userrepository.findById(member_id).get();
        Team team = teamrepository.findById(team_id).get();
        int size = team.getSize();
        if(size > 0) team.setSize(size-1);
        user.setTeam(null);
        userrepository.save(user);
        teamrepository.save(team);
    }



}
