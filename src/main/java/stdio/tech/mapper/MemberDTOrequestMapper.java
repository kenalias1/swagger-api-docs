package stdio.tech.mapper;

import stdio.tech.DTO.MemberDTOrequest;
import stdio.tech.model.Member;
import stdio.tech.model.Project;
import stdio.tech.model.Skill;

import java.util.List;
import java.util.stream.Collectors;

public class MemberDTOrequestMapper {
    public static Member toEntity(MemberDTOrequest memberDTOrequest, List<Project> projectList, List<Skill> skillList) {

        Member member = new Member();
        member.setName(memberDTOrequest.getName());
        member.setSurname(memberDTOrequest.getSurname());
        member.setBirthday(memberDTOrequest.getBirthday());
        member.setAddress(memberDTOrequest.getAddress());
        member.setFinishedProjects(memberDTOrequest.getFinishedProjects());
        member.setFinishedProjects(memberDTOrequest.getUnfinishedProjects());
        member.setSkills(skillList);
        member.setProjectSet(projectList);
        return member;
    }
    public static MemberDTOrequest toDTO(Member member) {
        MemberDTOrequest memberDTOrequest = new MemberDTOrequest();
        memberDTOrequest.setName(member.getName());
        memberDTOrequest.setSurname(member.getSurname());
        memberDTOrequest.setBirthday(member.getBirthday());
        memberDTOrequest.setAddress(member.getAddress());
        memberDTOrequest.setSkills(member.getSkills().stream().map(Skill::getId).collect(Collectors.toList()));
        memberDTOrequest.setProjectSet(member.getProjectSet().stream().map(Project::getId).collect(Collectors.toList()));
        return memberDTOrequest;
    }

    public static Member updateToEntity(MemberDTOrequest memberDTOrequest, Member oldMember, List<Project> projectList, List<Skill> skillList ){
        oldMember.setName(memberDTOrequest.getName());
        oldMember.setSurname(memberDTOrequest.getSurname());
        oldMember.setBirthday(memberDTOrequest.getBirthday());
        oldMember.setAddress(memberDTOrequest.getAddress());
        oldMember.setSkills(skillList);
        oldMember.setProjectSet(projectList);
        oldMember.setSkills(skillList);
        oldMember.setFinishedProjects(memberDTOrequest.getFinishedProjects());
        oldMember.setUnfinishedProjects(memberDTOrequest.getUnfinishedProjects());
        return oldMember;
    }



}
