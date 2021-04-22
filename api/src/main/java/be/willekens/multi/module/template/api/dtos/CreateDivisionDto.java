package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDivisionDto {

    private String name;
    private String originalName;
    private String director;

    public CreateDivisionDto setName(String name) {
        this.name = name;
        return this;
    }

    public CreateDivisionDto setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public CreateDivisionDto setDirector(String director) {
        this.director = director;
        return this;
    }
}
