package be.willekens.multi.module.template.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReceiveDivisionDto {

    private int id;
    private String name;
    private String originalName;
    private String director;

    public ReceiveDivisionDto setId(int id) {
        this.id = id;
        return this;
    }

    public ReceiveDivisionDto setName(String name) {
        this.name = name;
        return this;
    }

    public ReceiveDivisionDto setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public ReceiveDivisionDto setDirector(String director) {
        this.director = director;
        return this;
    }
}
