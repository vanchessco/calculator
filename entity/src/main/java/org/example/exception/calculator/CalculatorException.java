package org.example.exception.calculator;

import org.example.exception.util.ExceptionDetail;

public class CalculatorException extends RuntimeException {

    private ExceptionDetail exceptionDetail;

    public CalculatorException(String message) {
        super(message);
    }

    public ExceptionDetail getExceptionDetail() {
        return this.exceptionDetail;
    }

    public void setExceptionDetail(ExceptionDetail exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }
}
