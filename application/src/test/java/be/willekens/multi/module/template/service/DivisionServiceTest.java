package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.division.Division;
import be.willekens.multi.module.template.domain.repository.DivisionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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

        assertThat(divisionService.createDivision(division)).isEqualTo(division);
        verify(divisionRepository).save(division);
    }






}