package HVLO.TEXTRPG.field.repository;

import HVLO.TEXTRPG.field.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
}
