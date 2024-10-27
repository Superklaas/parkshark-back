package com.superklaas.domain.models.division;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "original_name")
    private String originalName;
    @Column(name = "director")
    private String director;
    @ManyToOne
    @JoinColumn(name = "parent_division_id", nullable = true)
    private Division parentDivision;

    public Division(String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public Division setParentDivision(Division parentDivision) {
        this.parentDivision = parentDivision;
        return this;
    }
}
