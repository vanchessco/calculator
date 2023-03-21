package org.example.exception_handler;


import org.example.exception.calculator.InvalidExpressionException;
import org.example.exception.calculator.InvalidSyntaxException;
import org.example.exception.calculator.WrongNumberOfArgumentsException;
import org.example.exception.util.ExceptionDetail;
import org.example.exception.util.ExceptionDetailConstructor;
import org.example.exception.visitor.VisitorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDetail> handleVisitorNotFoundException(WebRequest request, VisitorNotFoundException e) {
        ExceptionDetail ex = ExceptionDetailConstructor.construct(request, e);
        ex.setTitle("Object not found");
        ex.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(ex, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetail> handleIllegalArgumentException(WebRequest request, IllegalArgumentException e) {
        ExceptionDetail ex = ExceptionDetailConstructor.construct(request, e);
        ex.setTitle("Illegal argument");
        ex.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(ex, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetail> handleInvalidExpressionException(WebRequest request, InvalidExpressionException e) {
        ExceptionDetail ex = ExceptionDetailConstructor.construct(request, e);
        ex.setTitle("Invalid expression");
        ex.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(ex, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetail> handleInvalidSyntaxException(WebRequest request, InvalidSyntaxException e) {
        ExceptionDetail ex = ExceptionDetailConstructor.construct(request, e);
        ex.setTitle("Invalid Syntax");
        ex.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(ex, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetail> handleWrongNumberOfArgumentsException(WebRequest request, WrongNumberOfArgumentsException e) {
        ExceptionDetail ex = ExceptionDetailConstructor.construct(request, e);
        ex.setTitle("Invalid number of arguments");
        ex.setStatus(HttpStatus.BAD_REQUEST.value());


        return new ResponseEntity<>(ex, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetail> handleNumberFormatException(WebRequest request, NumberFormatException e) {
        ExceptionDetail ex = ExceptionDetailConstructor.construct(request, e);
        ex.setTitle("Invalid expression");
        ex.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(ex, null, HttpStatus.BAD_REQUEST);
    }


}
