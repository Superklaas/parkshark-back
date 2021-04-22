package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.division.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
