package org.example.v2.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.example.dto.calculator.CalculatorDTO;
import org.example.v2.service.ReactiveCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v2/calc")
@Api(value = "ReactiveCalcController")
public class ReactiveCalculatorRestControllerV2 {

    private ReactiveCalculatorService calculatorService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Reactive computation expression")
    @ApiResponse(message = "Expression was successfully computed", code = 200)
    public ResponseEntity<Mono<CalculatorDTO>> calculate(@Valid @RequestBody CalculatorDTO calculatorDTO) {
        return new ResponseEntity<>(calculatorService.compute(calculatorDTO), HttpStatus.OK);
    }

}
