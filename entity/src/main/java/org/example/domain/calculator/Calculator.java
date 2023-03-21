package org.example.domain.calculator;


import lombok.AllArgsConstructor;
import org.example.domain.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
public class Calculator extends AbstractEntity {

    @NotNull(groups = CalculatorValidator.class)
    @NotEmpty(groups = CalculatorValidator.class)
    @Column(nullable = false)
    private String expression;

    ;
    private String result;
    public Calculator() {
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Calculator c = (Calculator) o;
        if (Objects.equals(this.id, c.id)) return true;

        return Objects.equals(this.expression, c.expression) && Objects.equals(this.result, c.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, result);
    }

    public interface CalculatorValidator {
    }

}
