package stdio.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stdio.tech.model.Project;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public Project findByName(String name);
    List<Project> findAllByIdIn(List<Integer> ids);
}