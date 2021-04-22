package be.willekens.multi.module.template.api.mappers;

import be.willekens.multi.module.template.api.dtos.CreateDivisionDto;
import be.willekens.multi.module.template.api.dtos.ReceiveDivisionDto;
import be.willekens.multi.module.template.domain.models.division.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division createDivisionDto_to_Division(CreateDivisionDto createDivisionDto) {
        return new Division(
                createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                createDivisionDto.getDirector());
    }

    public ReceiveDivisionDto division_to_receiveDivisionDto(Division division) {
        return new ReceiveDivisionDto()
                .setId(division.getId())
                .setName(division.getName())
                .setOriginalName(division.getOriginalName())
                .setDirector(division.getDirector());
    }


}
