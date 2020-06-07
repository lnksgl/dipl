package spring.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByName(String name);

    @Modifying
    @Query("update Group u set u.name = ?1, u.content = ?2 where u.id = ?3")
    void updateGroup(String name, String content, Long id);

    @Modifying
    @Query("update Group u set u.average = ?1 where u.id = ?2")
    void updateGroup(String average, Long id);
}
