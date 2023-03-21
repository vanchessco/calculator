package org.example.v1.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.example.dto.calculator.CalculatorDTO;
import org.example.v1.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/calc")
@Api(value = "CalcControllerV1")
public class CalculatorRestControllerV1 {

    private CalculatorService calculatorService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Compute expression")
    @ApiResponse(message = "Expression was successfully computed", code = 200)
    public ResponseEntity<CalculatorDTO> calculate(@Valid @RequestBody CalculatorDTO calculatorDTO) {
        CalculatorDTO result = calculatorService.compute(calculatorDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
