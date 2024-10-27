package com.superklaas.service;

import com.superklaas.domain.models.address.PostalCode;
import com.superklaas.domain.repository.PostalCodeRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@NoArgsConstructor
public class PostalCodeService {

    @Autowired
    private PostalCodeRepository postalCodeRepository;

    public PostalCode getByPostalCode(String postalCode){
        return postalCodeRepository.findByPostalCode(postalCode);
    }

    public PostalCode createPostalCode(PostalCode postalCode){
        return postalCodeRepository.save(postalCode);
    }
}
