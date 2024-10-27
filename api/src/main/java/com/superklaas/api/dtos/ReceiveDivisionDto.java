package com.superklaas.api.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReceiveDivisionDto {

    private int id;
    private String name;
    private String originalName;
    private String director;
    private Integer parentId;

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

    public ReceiveDivisionDto setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }
}
