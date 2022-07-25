package stdio.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stdio.tech.DTO.ProjectDTOrequest;
import stdio.tech.DTO.ProjectDTOreponse;
import stdio.tech.mapper.ProjectDTOrequestMapper;
import stdio.tech.mapper.ProjectrDTOresponseMapper;
import stdio.tech.model.Project;
import stdio.tech.model.Member;
import stdio.tech.repository.ProjectRepository;
import stdio.tech.repository.StdioMemberRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private StdioMemberRepository memberRepository;
    public ProjectDTOreponse add(ProjectDTOrequest projectDTOrequest) {
        List<Member> memberList = memberRepository.findAllByIdIn(projectDTOrequest.getMemberSet());
        Project project = ProjectDTOrequestMapper.toEntity(projectDTOrequest, memberList);
        return ProjectrDTOresponseMapper.toDTO(projectRepository.save(project));
    }
    public List<ProjectDTOreponse> readAll() {
        return projectRepository.findAll().stream().map(s-> ProjectrDTOresponseMapper.toDTO(s)).collect(Collectors.toList());
    }

}

