package com.superklaas.domain.repository;

import com.superklaas.domain.models.division.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
