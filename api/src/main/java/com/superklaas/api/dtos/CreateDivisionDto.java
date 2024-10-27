package com.superklaas.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDivisionDto {

    private String name;
    private String originalName;
    private String director;
    private Integer parentId;


    public CreateDivisionDto(String name, String originalName, String director, Integer parentId) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentId = parentId;
    }

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
