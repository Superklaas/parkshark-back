package com.superklaas.service;

import com.superklaas.domain.models.division.Division;
import com.superklaas.domain.repository.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DivisionServiceTest {
    @Mock
    private DivisionRepository divisionRepository;
    @InjectMocks
    private DivisionService divisionService;

    @Test
    void createNewDivision_thenReturnsDivision() {
        Division divisionParent = new Division("TestD","Test","D1");
        Division division = new Division("TestD2","Test2","D2").setParentDivision(divisionParent);
        when(divisionRepository.save(division)).thenReturn(division);

        Assertions.assertThat(divisionService.createDivision(division)).isEqualTo(division);
        verify(divisionRepository).save(division);
    }






}
