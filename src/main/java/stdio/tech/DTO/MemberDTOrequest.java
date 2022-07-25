package stdio.tech.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class MemberDTOrequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("birthday")
    private LocalDate birthday;
    @JsonProperty("address")
    private String address;
    @JsonProperty("finishedProjects")
    private  String finishedProjects;
    @JsonProperty("unfinishedProjects")
    private  String  unfinishedProjects;
    @JsonProperty("skills")
    private List<Integer> skills =  new ArrayList<>();
    private List<Integer> projectSet = new ArrayList<>();




}
