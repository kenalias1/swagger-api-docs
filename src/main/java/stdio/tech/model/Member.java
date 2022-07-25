package stdio.tech.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "stdio_members")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "address")
    private String address;

    @Column(name = "finished_projects")
    private String finishedProjects;

    @Column(name = "unfinished_project")
    private  String  unfinishedProjects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_project",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    @JsonIgnoreProperties(value = {"memberSet"})
    private List<Project> projectSet = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;
}
