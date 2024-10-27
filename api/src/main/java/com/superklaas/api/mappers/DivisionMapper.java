package com.superklaas.api.mappers;

import com.superklaas.api.dtos.CreateDivisionDto;
import com.superklaas.api.dtos.ReceiveDivisionDto;
import com.superklaas.domain.models.division.Division;
import com.superklaas.service.DivisionService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DivisionMapper {

    @Autowired
    private DivisionService divisionService;

    public Division createDivisionDto_to_Division(CreateDivisionDto createDivisionDto) {
        return new Division(
                createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                createDivisionDto.getDirector())
                .setParentDivision(createDivisionDto.getParentId() == null ? null :
                        divisionService.getDivisionById(createDivisionDto.getParentId()));

    }

    public ReceiveDivisionDto division_to_receiveDivisionDto(Division division) {
        return new ReceiveDivisionDto()
                .setId(division.getId())
                .setName(division.getName())
                .setOriginalName(division.getOriginalName())
                .setDirector(division.getDirector())
                .setParentId(division.getParentDivision() == null ? null :
                        division.getParentDivision().getId());
    }


}
