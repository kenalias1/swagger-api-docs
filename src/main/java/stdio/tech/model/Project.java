package stdio.tech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stdio.tech.common.enumType.StatusEnum;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "stdio_projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "membercount")
    private int memberCount;
    @Column(name = "projectstatus")
    private StatusEnum status;

    @ManyToMany(mappedBy = "projectSet", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"projectSet"})
    private List<Member> memberSet = new ArrayList<>();

}
