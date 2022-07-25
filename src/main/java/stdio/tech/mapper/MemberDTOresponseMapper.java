package stdio.tech.mapper;

import stdio.tech.DTO.MemberDTOresponse;
import stdio.tech.model.Member;

import java.util.stream.Collectors;

public class MemberDTOresponseMapper {
    public static MemberDTOresponse toDTO(Member member) {
        MemberDTOresponse stdioMemberDTO = new MemberDTOresponse();
        stdioMemberDTO.setId(member.getId());
        stdioMemberDTO.setName(member.getName());
        stdioMemberDTO.setSurname(member.getSurname());
        stdioMemberDTO.setBirthday(member.getBirthday());
        stdioMemberDTO.setAddress(member.getAddress());
        stdioMemberDTO.setFinishedProjects(member.getFinishedProjects());
        stdioMemberDTO.setUnfinishedProjects(member.getUnfinishedProjects());
        stdioMemberDTO.setSkills(member.getSkills().stream().map(SkillDTOMapper::toDTO).collect(Collectors.toList()));
        stdioMemberDTO.setProjectSet(member.getProjectSet().stream().map(ProjectDTOrequestMapper::toDTO).collect(Collectors.toList()));
        return stdioMemberDTO;
    }


}
