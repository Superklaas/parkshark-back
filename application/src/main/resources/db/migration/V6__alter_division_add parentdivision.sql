alter table divisions
    add parent_division_id integer
    constraint fk4_divisions_to_divisions
        references divisions;
