package org.example.v2.service;

import lombok.AllArgsConstructor;
import org.example.calculating.analyzer.LexicalAnalyzer;
import org.example.calculating.analyzer.SyntacticAnalyzer;
import org.example.calculating.token.Token;
import org.example.domain.calculator.Calculator;
import org.example.dto.calculator.CalculatorDTO;
import org.example.repo.calculator.CalculatorRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ReactiveCalculatorServiceImpl implements ReactiveCalculatorService {
    private CalculatorRepo calculatorRepo;

    private static String analyzeAndCompute(String expression) {
        SyntacticAnalyzer sa = new SyntacticAnalyzer();
        LexicalAnalyzer la = new LexicalAnalyzer();
        sa.analyze(expression);
        Token.Tokens tokens = new Token.Tokens(sa.getTokens());

        return String.valueOf(la.expression(tokens));

    }

    @Override
    public Mono<CalculatorDTO> compute(CalculatorDTO calculatorDTO) {
        if (calculatorDTO.getExpression().isEmpty() || calculatorDTO.getExpression() == null) {
            throw new IllegalArgumentException("Missing expression");
        }
        Calculator calculator = new Calculator();
        calculator.setExpression(calculatorDTO.getExpression());
        calculator.setResult(analyzeAndCompute(calculatorDTO.getExpression()));
        calculatorRepo.save(calculator);

        calculatorDTO.setResult(calculator.getResult());

        return Mono.just(calculatorDTO);
    }


}
