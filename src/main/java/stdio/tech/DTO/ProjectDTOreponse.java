package stdio.tech.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stdio.tech.common.enumType.StatusEnum;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTOreponse {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("memberCount")
    private int memberCount;
    @JsonProperty("status")
    private StatusEnum status;
    @JsonProperty("memberSet")
    private List<MemberDTOrequest> memberSet = new ArrayList<>();
}
