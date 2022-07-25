package stdio.tech.repository;

import stdio.tech.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StdioMemberRepository extends JpaRepository<Member, Integer> {
    Member findByName(String name);
    List<Member> findAllByIdIn(List<Integer> ids);
}