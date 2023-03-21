package org.example.v1.service;


import org.example.dto.calculator.CalculatorDTO;
import org.example.exception.calculator.InvalidSyntaxException;
import org.example.repo.calculator.CalculatorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceNegativeUnitTest {


    @Mock
    private CalculatorRepo calculatorRepo;
    @InjectMocks
    private CalculatorServiceImpl calculatorServiceImpl;

    private CalculatorDTO calculator;


    @BeforeEach
    public void setUp() {
        calculator = new CalculatorDTO();
    }

    @Test
    public void minNegativeTest() {
        calculator.setExpression("min(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });


        calculator.setExpression(".min(10,10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("min(-.10.,+9)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("min(10.231,10.230).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("min(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

    }

    @Test
    public void maxNegativeTest() {
        calculator.setExpression("max(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".max(10,10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("max(.-10,+9)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("max(10.231,10.230).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("max(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void sinNegativeTest() {
        calculator.setExpression("sin(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".sin()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("sin(.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("sin(-10.231).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("sin(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void cosNegativeTest() {
        calculator.setExpression("cos(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".cos()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("cos(.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("cos(-10.231).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("cos(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void tanNegativeTest() {
        calculator.setExpression("tan(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".tan()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("tan(.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("tan(-10.231).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("tan(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void sqrtNegativeTest() {
        calculator.setExpression("sqrt(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".sqrt()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("sqrt(.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("sqrt(-10.231).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("sqrt(10+2*(23.45/3)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void powNegativeTest() {
        calculator.setExpression("pow(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".pow()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("pow(2,.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("pow(-2,10.231).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("pow(10+2*(23.45/3),-23).0");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("pow(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void naturalLogNegativeTest() {
        calculator.setExpression("log(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".log()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("log(.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("log(-2.0.)");
        assertThrows(NumberFormatException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("log(10+2*(23.45/3)).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("log(10+2*(23.45/3)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void baseLogNegativeTest() {
        calculator.setExpression("logB(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".logB()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logB(2,.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logB(-2,10.231).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logB(-(10+2*(23.45/3),-23)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logB(10+2*(23.45/3),23");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }

    @Test
    public void decimalLogNegativeTest() {
        calculator.setExpression("logD(10,)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression(".logD()");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logD(.-10)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logD(-2.0.)");
        assertThrows(NumberFormatException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logD(10+2*(23.45/3)).");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });

        calculator.setExpression("logD(10+2*(23.45/3)");
        assertThrows(InvalidSyntaxException.class, () -> {
            calculatorServiceImpl.compute(calculator);
        });
    }
}
