package be.willekens.multi.module.template.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDivisionDto {

    private String name;
    private String originalName;
    private String director;
    @JsonProperty(required = false)
    private Integer parentId;

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

    public CreateDivisionDto setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }
}
