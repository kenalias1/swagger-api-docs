package stdio.tech.mapper;

import stdio.tech.DTO.ProjectDTOrequest;
import stdio.tech.model.Member;
import stdio.tech.model.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectDTOrequestMapper {
    public static ProjectDTOrequest toDTO(Project project){
        ProjectDTOrequest projectDTOrequest = new ProjectDTOrequest();
        projectDTOrequest.setId(project.getId());
        projectDTOrequest.setName(project.getName());
        projectDTOrequest.setMemberCount(project.getMemberCount());
        projectDTOrequest.setStatus(project.getStatus());
        projectDTOrequest.setMemberSet(project.getMemberSet().stream().map(s->s.getId()).collect(Collectors.toList()));
        return projectDTOrequest;
    }
    public static Project toEntity(ProjectDTOrequest projectDTOrequest, List<Member> memberList){
        Project project = new Project();
        project.setId(projectDTOrequest.getId());
        project.setName(projectDTOrequest.getName());
        project.setMemberCount(projectDTOrequest.getMemberCount());
        project.setStatus(projectDTOrequest.getStatus());
        project.setMemberSet(memberList);
        return project;
    }
    public static  Project updateToEntity(ProjectDTOrequest projectDTOrequest, Project oldProject, List<Member> memberList ){
        oldProject.setName(projectDTOrequest.getName());
        oldProject.setMemberCount(projectDTOrequest.getMemberCount());
        oldProject.setStatus(projectDTOrequest.getStatus());
        oldProject.setMemberSet(memberList);
        return oldProject;

    }
}
