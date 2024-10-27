package com.superklaas.api.controllers;

import com.superklaas.api.dtos.CreateDivisionDto;
import com.superklaas.api.dtos.ReceiveDivisionDto;
import com.superklaas.api.mappers.DivisionMapper;
import com.superklaas.domain.models.division.Division;
import com.superklaas.service.DivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = DivisionController.DIVISION_RESOURCE_PATH)
public class DivisionController {

    private static final Logger logger = LoggerFactory.getLogger(DivisionController.class);

    public static final String DIVISION_RESOURCE_PATH = "/divisions";
    private final DivisionService divisionService;
    private final DivisionMapper divisionMapper;

    @Autowired
    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper) {
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PreAuthorize("hasAuthority('CREATE_DIVISION')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReceiveDivisionDto createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
        logger.info("Attempt to create a division");
        Division division =
                divisionService.createDivision(divisionMapper.createDivisionDto_to_Division(createDivisionDto));
        return divisionMapper.division_to_receiveDivisionDto(division);
    }

    @PreAuthorize("hasAuthority('VIEW_ALL_DIVISIONS')")
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ReceiveDivisionDto> getall(){
        return divisionService.getAllDivisions().stream().map(divisionMapper::division_to_receiveDivisionDto).collect(Collectors.toList());
    }

}
