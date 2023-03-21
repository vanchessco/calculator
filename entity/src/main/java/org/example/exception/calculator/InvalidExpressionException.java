package org.example.exception.calculator;

public class InvalidExpressionException extends CalculatorException {
    public InvalidExpressionException(String message) {
        super(message);
    }

}
