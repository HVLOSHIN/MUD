package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.entity.UserField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFieldRepository extends JpaRepository<UserField, Long> {
    List<UserField> findByUserId(Long userId);
}
