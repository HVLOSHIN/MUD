package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.entity.UserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLogRepository extends JpaRepository<UserLog, Long> {
    List<UserLog> findByUserId(Long userId);
    Page<UserLog> findByUserId(Long userId, Pageable pageable);
}
