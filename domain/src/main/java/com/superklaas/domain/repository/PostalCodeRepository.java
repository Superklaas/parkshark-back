package com.superklaas.domain.repository;

import com.superklaas.domain.models.address.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostalCodeRepository extends JpaRepository<PostalCode, Integer> {

    PostalCode findByPostalCode(String postalCode);
}
