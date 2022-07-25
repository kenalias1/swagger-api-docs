package stdio.tech.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//ToDo rename
public class MemberDTOresponse {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String address;
    private String finishedProjects;
    private String unfinishedProjects;
    private List<SkillDTO> skills = new ArrayList<>();
    private List<ProjectDTOrequest> projectSet = new ArrayList<>();

}
