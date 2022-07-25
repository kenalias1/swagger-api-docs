package stdio.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stdio.tech.model.Project;
import stdio.tech.model.Skill;

import java.util.List;


@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    public Skill findByName(String name);
    List<Skill> findAllByIdIn(List<Integer> ids);
}