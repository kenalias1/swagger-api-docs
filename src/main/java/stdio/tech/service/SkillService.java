package stdio.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stdio.tech.DTO.MemberDTOrequest;
import stdio.tech.DTO.SkillDTO;
import stdio.tech.common.constant.Constant;
import stdio.tech.mapper.MemberDTOrequestMapper;
import stdio.tech.mapper.SkillDTOMapper;
import stdio.tech.model.Member;
import stdio.tech.model.Skill;
import stdio.tech.repository.StdioMemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {
    @Autowired
    private StdioMemberRepository stdioMemberRepository;

    public MemberDTOrequest addSkills(Integer memberId, List<SkillDTO> skillList) throws Exception {
        MemberDTOrequest dto = new MemberDTOrequest();
        Optional<Member> optionalStdioMember = stdioMemberRepository.findById(memberId);
        if (optionalStdioMember.isPresent()) {
            Member currentMember = optionalStdioMember.get();
            List<Skill> skill = skillList.stream().map(SkillDTOMapper::toEntity).collect(Collectors.toList());
            currentMember.setSkills(skill);
            return MemberDTOrequestMapper.toDTO(stdioMemberRepository.save(currentMember));
        } else throw new Exception(Constant.NOT_FOUND);
    }

    public List<SkillDTO> readMemberSkills(Integer memberId) throws Exception {
        Optional<Member> member = stdioMemberRepository.findById(memberId);
        if (member.isPresent()) {
            Member currentMember = member.get();
            List<Skill> skills = currentMember.getSkills();
            return skills.stream().map(SkillDTOMapper::toDTO).collect(Collectors.toList());
        } else throw new Exception(Constant.NOT_FOUND);
    }

}

