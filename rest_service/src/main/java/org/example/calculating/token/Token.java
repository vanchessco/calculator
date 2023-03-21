package org.example.calculating.token;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Token {
    @Getter
    private TokenType type;
    @Getter
    private OperationType operationType;

    @Getter
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Token(TokenType type, OperationType operationType) {
        this.type = type;
        this.operationType = operationType;
    }

    public Token(TokenType type, OperationType operationType, String value) {
        this.type = type;
        this.operationType = operationType;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Token:{TokenType:%s,Value:%s,OperationType:%s}", this.type, this.value, this.operationType);
    }

    public static class Tokens {
        private List<Token> tokens;
        private int index;

        public Tokens(List<Token> tokens) {
            this.tokens = new ArrayList<>(tokens);
        }

        public int getIndex() {
            return index;
        }

        public Token getNextToken() {
            return tokens.get(index++);
        }

        public void stepBack() {
            index--;
        }
    }
}

