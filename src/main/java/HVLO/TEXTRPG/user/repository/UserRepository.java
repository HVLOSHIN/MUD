package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLoginId(String loginId);
    boolean existsByUsername(String username);


    Optional<User> findByLoginId(String loginId);

}
