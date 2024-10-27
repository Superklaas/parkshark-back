package com.superklaas.service;

import com.superklaas.domain.models.division.Division;
import com.superklaas.domain.repository.DivisionRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@NoArgsConstructor
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public Division createDivision(Division division) {
        return divisionRepository.save(division);
    }

    public List<Division> getAllDivisions(){
        return divisionRepository.findAll();
    }

    public Division getDivisionById(Integer id){
        return divisionRepository.findById(id).orElse(null);
    }

}
