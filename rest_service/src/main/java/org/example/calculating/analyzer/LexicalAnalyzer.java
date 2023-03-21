package org.example.calculating.analyzer;

import org.example.calculating.function.Function;
import org.example.calculating.function.ProcessFunction;
import org.example.calculating.token.OperationType;
import org.example.calculating.token.Token;
import org.example.calculating.token.TokenType;
import org.example.exception.calculator.InvalidSyntaxException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Syntax analysis rules:
 * 1)Expression: addAndSubstrate
 * 2)AddAndSubstrate: multiplyAndDivide + OR - multiplyAndDivide
 * 3)MultiplyAndDivide: multiplier * OR /  multiplier
 * 4)Multiplier: function OR unaryOperator OR number OR expr in ()
 * 5)UnaryOperator: '-' multiplier
 * 6)Function: function_name (expression1,expression2,...,n)
 */

public class LexicalAnalyzer {

    public double expression(Token.Tokens tokens) {
        Token token = tokens.getNextToken();
        //если конец строки с выражением
        if (token.getType().equals(TokenType.OPERATION) && token.getOperationType().equals(OperationType.END)) {
            return 0;
        } else {
            //вернуться на 1 позицию назад ,чтобы не потерять token
            tokens.stepBack();
            return addAndSubstrate(tokens);
        }
    }

    private double addAndSubstrate(Token.Tokens tokens) {
        double value = multiplyAndDivide(tokens);
        while (true) {
            Token token = tokens.getNextToken();
            if (token.getType().equals(TokenType.OPERATION)) {
                switch (token.getOperationType()) {
                    //бинарный '+-'
                    case ADD -> value += multiplyAndDivide(tokens);
                    case SUBSTRATE -> value -= multiplyAndDivide(tokens);
                    case COMMA, FUNCTION, CLOSE_BRACKET, END -> {
                        tokens.stepBack();
                        return value;
                    }
                    default ->
                            throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", token.getValue(), tokens.getIndex()));

                }
            }
        }
    }

    private double multiplyAndDivide(Token.Tokens tokens) {
        double value = multiplier(tokens);
        while (true) {
            Token token = tokens.getNextToken();
            if (token.getType().equals(TokenType.OPERATION)) {
                switch (token.getOperationType()) {
                    case MULTIPLY -> value *= multiplier(tokens);
                    case DIVIDE -> value /= multiplier(tokens);
                    case ADD, SUBSTRATE, COMMA, FUNCTION, CLOSE_BRACKET, END -> {
                        tokens.stepBack();
                        return value;
                    }
                    default ->
                            throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", token.getValue(), tokens.getIndex()));

                }
            }
        }
    }

    private double multiplier(Token.Tokens tokens) {
        Token token = tokens.getNextToken();
        switch (token.getType()) {
            case NUMBER -> {
                return Double.parseDouble(token.getValue());
            }
            case OPERATION -> {
                double value = 0;
                switch (token.getOperationType()) {
                    case OPEN_BRACKET -> {
                        //вычисляем выражение в скобках
                        value = expression(tokens);
                        // после вычисления index должен быть в позиции закрывающей скобки
                        token = tokens.getNextToken();
                        if (!token.getOperationType().equals(OperationType.CLOSE_BRACKET)) {
                            throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", token.getValue(), tokens.getIndex()));
                        }
                    }
                    //унарный минус
                    case SUBSTRATE -> {
                        value = multiplier(tokens);
                        return -value;
                    }
                    //унарный плюс
                    case ADD -> {
                        value = multiplier(tokens);
                        return +value;
                    }
                    case FUNCTION -> {
                        //откатываем индекс на 'название_функции'
                        tokens.stepBack();
                        return function(tokens);
                    }
                }
                return value;
            }
            default ->
                    throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", token.getValue(), tokens.getIndex()));
        }

    }

    private double function(Token.Tokens tokens) {
        //получаем имя функции
        String functionName = tokens.getNextToken().getValue();
        //берем след токен
        //должен соответствовать '('
        Token token = tokens.getNextToken();

        if (!token.getOperationType().equals(OperationType.OPEN_BRACKET)) {
            throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", token.getValue(), tokens.getIndex()));
        }

        List<Double> args = new ArrayList<>();
        token = tokens.getNextToken();

        if (!Objects.equals(token.getOperationType(), OperationType.CLOSE_BRACKET)) {
            //откатываем индекс на '('
            tokens.stepBack();
            do {
                //вычисляем выражение до ',' или ')'
                args.add(expression(tokens));
                //переходим к ',' или ')'
                token = tokens.getNextToken();
                if (!Objects.equals(token.getOperationType(), OperationType.COMMA) && !Objects.equals(token.getOperationType(), OperationType.CLOSE_BRACKET)) {
                    throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", token.getValue(), tokens.getIndex()));
                }
                //пока есть аргументы в функции
            } while (Objects.equals(token.getOperationType(), OperationType.COMMA));
        }

        //получаем map функций
        Map<String, ProcessFunction> functions = ProcessFunction.getFunctions();
        //ищем переданную функцию в map
        ProcessFunction pf = functions.get(functionName);
        //вычисляем
        Function function = pf.getFunction();

        return function.apply(args);

    }
}
