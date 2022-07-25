package stdio.tech.mapper;

import stdio.tech.DTO.MemberDTOresponse;
import stdio.tech.DTO.ProjectDTOreponse;
import stdio.tech.model.Member;
import stdio.tech.model.Project;

import java.util.stream.Collectors;

public class ProjectrDTOresponseMapper {
    public static ProjectDTOreponse toDTO(Project project){
        ProjectDTOreponse projectDTO = new ProjectDTOreponse();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setMemberCount(project.getMemberCount());
        projectDTO.setStatus(project.getStatus());
        projectDTO.setMemberSet(project.getMemberSet().stream().map(MemberDTOrequestMapper::toDTO).collect(Collectors.toList()));
        return projectDTO;
    }


}
