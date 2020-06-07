package spring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findByEmail(String email);
    Optional<User> findById(Long id);

    @Modifying
    @Query("update User  set scanDocument = ?1 where id = ?2")
    void updateUser(String average, Long id);
}
