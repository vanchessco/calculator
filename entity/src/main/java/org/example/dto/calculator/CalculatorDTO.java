package org.example.dto.calculator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CalculatorDTO {
    private Long id;

    ;
    @NotNull(groups = CalculatorDTO.CalculatorDTOValidator.class)
    @NotEmpty(groups = CalculatorDTO.CalculatorDTOValidator.class)
    private String expression;
    private String result;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public interface CalculatorDTOValidator {
    }
}
