package stdio.tech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import stdio.tech.DTO.ProjectDTOrequest;
import stdio.tech.DTO.ProjectDTOreponse;
import stdio.tech.service.ProjectService;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @GetMapping("/project/list")
    private ResponseEntity<List<ProjectDTOreponse>> listProjects() {
        return new ResponseEntity<>(projectService.readAll(), HttpStatus.OK);
    }
    @PostMapping("/project/create")
    private ResponseEntity<ProjectDTOreponse> addProject(@RequestBody ProjectDTOrequest projectDTOrequest) {
        return new ResponseEntity<>(projectService.add(projectDTOrequest), HttpStatus.CREATED);
    }

}
