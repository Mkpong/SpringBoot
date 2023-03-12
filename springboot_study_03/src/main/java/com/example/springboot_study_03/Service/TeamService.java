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
        teamrepository.save(team);
    }

    public List<Team> teamlist(){
        return teamrepository.findAll();
    }

    public void updateTeam(Integer id , String username){
        //만약 username인 siteuser가 이미 팀이 있다면 등록을 거절해야 한다. - 추가내용
        Team team = teamrepository.findById(id).get();
        SiteUser user = userrepository.findByusername(username).get();

//        List<SiteUser> member = team.getMembers();
//        member.add(user);
//        team.setMembers(member);

        user.setTeam(team);

        teamrepository.save(team);
        userrepository.save(user);
    }

    public List<SiteUser> teamview(Integer id){
        return teamrepository.findById(id).get().getMembers();
    }

    public void teamdelete(Integer id){
        // 팀 삭제
    }



}
