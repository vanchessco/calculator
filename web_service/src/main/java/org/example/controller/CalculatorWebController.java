package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.client.feign.CalculatorFeignClient;
import org.example.dto.calculator.CalculatorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CalculatorWebController {

    private CalculatorFeignClient feignClient;

    @GetMapping
    public String home() {
        return "home";
    }


    @GetMapping(path = "/calc")
    public String calc(Model model) {
        model.addAttribute("calc", new CalculatorDTO());
        return "expr";
    }

    @PostMapping(path = "/calc")
    public String calc(@Valid @ModelAttribute("calc") @RequestBody CalculatorDTO calculator, Model model) {
        try {
            model.addAttribute("expression", feignClient.getCalc(calculator).getBody().getExpression());
            model.addAttribute("answer", feignClient.getCalc(calculator).getBody().getResult());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }

        return "expr";
    }
}
