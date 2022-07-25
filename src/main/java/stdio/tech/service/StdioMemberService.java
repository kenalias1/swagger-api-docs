package stdio.tech.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import stdio.tech.DTO.MemberDTOrequest;
import stdio.tech.DTO.MemberDTOresponse;
import stdio.tech.common.constant.Constant;
import stdio.tech.mapper.MemberDTOrequestMapper;
import stdio.tech.mapper.MemberDTOresponseMapper;
import stdio.tech.model.Project;
import stdio.tech.model.Skill;
import stdio.tech.model.Member;
import stdio.tech.repository.ProjectRepository;
import stdio.tech.repository.SkillRepository;
import stdio.tech.repository.StdioMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StdioMemberService {

    @Autowired
    private StdioMemberRepository stdioMemberRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SkillRepository skillRepository;

    public MemberDTOresponse add(MemberDTOrequest memberDTOrequest) {
        List<Project> projectList = projectRepository.findAllByIdIn(memberDTOrequest.getProjectSet());
        List<Skill> skillList = skillRepository.findAllByIdIn(memberDTOrequest.getSkills());
        return MemberDTOresponseMapper.toDTO(stdioMemberRepository.save(MemberDTOrequestMapper.toEntity(memberDTOrequest,projectList,skillList)));
    }
    public MemberDTOresponse update(Integer id, MemberDTOrequest memberDTOrequest) throws Exception {
        Optional<Member> optionalStdioMember = stdioMemberRepository.findById(id);
        if (optionalStdioMember.isPresent()) {
            Member member = optionalStdioMember.get();
            List<Project> projectList = projectRepository.findAllByIdIn(memberDTOrequest.getProjectSet());
            List<Skill> skillList = skillRepository.findAllByIdIn(memberDTOrequest.getSkills());
            return MemberDTOresponseMapper.toDTO(MemberDTOrequestMapper.updateToEntity(memberDTOrequest,member, projectList,skillList));
        } else throw new Exception(Constant.NOT_FOUND);
    }
    public void delete(int id) {
        Optional<Member> stdioMemberOptional = stdioMemberRepository.findById(id);
        if (stdioMemberOptional.isPresent()) {
            stdioMemberRepository.deleteById(id);
        }
    }
    public List<MemberDTOresponse> readAll() {
        return stdioMemberRepository.findAll().stream().map(s -> MemberDTOresponseMapper.toDTO(s)).collect(Collectors.toList());
    }


}

