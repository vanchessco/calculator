package org.example.calculating.analyzer;

import org.example.calculating.function.ProcessFunction;
import org.example.calculating.token.OperationType;
import org.example.calculating.token.Token;
import org.example.calculating.token.TokenType;
import org.example.exception.calculator.InvalidExpressionException;
import org.example.exception.calculator.InvalidSyntaxException;

import java.util.ArrayList;
import java.util.List;

public class SyntacticAnalyzer {
    private List<Token> tokens;

    public SyntacticAnalyzer() {
        this.tokens = new ArrayList<>();
    }

    public List<Token> getTokens() {
        return tokens = new ArrayList<>(this.tokens);
    }

    public void analyze(String value) {
        int index = 0;
        while (index < value.length()) {
            char c = value.charAt(index);
            switch (c) {
                case ' ' -> {
                    index++;
                }
                case '(' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.OPEN_BRACKET, String.valueOf(c)));
                    index++;
                }
                case ')' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.CLOSE_BRACKET, String.valueOf(c)));
                    index++;
                }
                case '+' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.ADD, String.valueOf(c)));
                    index++;
                }
                case '-' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.SUBSTRATE, String.valueOf(c)));
                    index++;
                }
                case '*' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.MULTIPLY, String.valueOf(c)));
                    index++;
                }
                case '/' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.DIVIDE, String.valueOf(c)));
                    index++;
                }
                case ',' -> {
                    tokens.add(new Token(TokenType.OPERATION, OperationType.COMMA, String.valueOf(c)));
                    index++;
                }
                default -> {
                    StringBuilder sb = new StringBuilder();
                    if (!Character.isDigit(c) && !Character.isLetter(c)) {
                        throw new InvalidSyntaxException(String.format("Invalid syntax: \'%s\',Index: %s", c, index));
                    }
                    if (Character.isDigit(c) || c == '.') {
                        do {
                            sb.append(c);
                            index++;
                            if (index >= value.length()) {
                                break;
                            }
                            c = value.charAt(index);
                        } while (Character.isDigit(c) || c == '.');
                        tokens.add(new Token(TokenType.NUMBER, sb.toString()));
                    } else {
                        if (Character.isLetter(c)) {
                            do {
                                sb.append(c);
                                index++;
                                //проверка конца строки
                                if (index >= value.length()) {
                                    break;
                                }
                                c = value.charAt(index);
                            } while (Character.isLetter(c));
                            //проверка названия функции
                            if (ProcessFunction.getFunctions().containsKey(sb.toString())) {
                                tokens.add(new Token(TokenType.OPERATION, OperationType.FUNCTION, sb.toString()));
                            } else {
                                throw new InvalidExpressionException(String.format("Invalid function name: \'%s\'", sb));
                            }
                        }
                    }
                }
            }
        }
        tokens.add(new Token(TokenType.OPERATION, OperationType.END));
    }
}
