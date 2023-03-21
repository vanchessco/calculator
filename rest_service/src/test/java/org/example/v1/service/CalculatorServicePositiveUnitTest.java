package org.example.v1.service;


import org.example.dto.calculator.CalculatorDTO;
import org.example.exception.calculator.CalculatorException;
import org.example.repo.calculator.CalculatorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculatorServicePositiveUnitTest {

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
    public void minPositiveTest() throws CalculatorException {
        calculator.setExpression("min(10,9)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "9.0");

        calculator.setExpression("min(10,10)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "10.0");

        calculator.setExpression("min(-10,+9)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "-10.0");

        calculator.setExpression("min(10.231,10.230)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "10.23");

        calculator.setExpression("min(10+2*(23.45/3),23)");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "23.0");
    }

    @Test
    public void maxPositiveTest() throws CalculatorException {
        calculator.setExpression("max(10,9)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "10.0");

        calculator.setExpression("max(10,10)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "10.0");

        calculator.setExpression("max(-10,+9)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "9.0");

        calculator.setExpression("max(10.231,10.230)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "10.231");

        calculator.setExpression("max(10+2*(23.45/3),12301203)");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "1.2301203E7");
    }

    @Test
    public void sinPositiveTest() throws CalculatorException {
        calculator.setExpression("sin(1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "0.6847035819");

        calculator.setExpression("sin(-1023523.2123)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "-0.6847035819");

        calculator.setExpression("-sin(1023523.2123)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "-0.6847035819");

        calculator.setExpression("sin(12409174091724907121341245121)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "0.8812848333");

        calculator.setExpression("sin(10+2*(23.45/3))");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "0.4326103405");
    }

    @Test
    public void cosPositiveTest() throws CalculatorException {
        calculator.setExpression("cos(1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "0.7288216551");

        calculator.setExpression("cos(-1023523.2123)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "0.7288216551");

        calculator.setExpression("-cos(1023523.2123)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "-0.7288216551");

        calculator.setExpression("cos(12409174091724907121341245121)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "-0.472585487");

        calculator.setExpression("cos(10+2*(23.45/3))");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "0.9015809965");
    }

    @Test
    public void tanPositiveTest() throws CalculatorException {
        calculator.setExpression("tan(1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "0.9394665719");

        calculator.setExpression("tan(-1023523.2123)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "-0.9394665719");

        calculator.setExpression("-tan(1023523.2123)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "-0.9394665719");

        calculator.setExpression("tan(12409174091724907121341245121)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "-1.864815695");

        calculator.setExpression("tan(10+2*(23.45/3))");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "0.4798352474");
    }

    @Test
    public void sqrtPositiveTest() throws CalculatorException {
        calculator.setExpression("sqrt(1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "1011.6932402");

//        calculator.setExpression("sqrt(-1023523.2123)");
//        Calculator expected1 = calculatorServiceImpl.compute(calculator);
//        assertEquals(expected1.getResult(), "-1011.6932402");

        calculator.setExpression("-sqrt(1023523.2123)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "-1011.6932402");

        calculator.setExpression("sqrt(12409174091724907121341245121)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "1.1139647252819502E14");

        calculator.setExpression("sqrt(10+2*(23.45/3))");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "5.0629372");
    }

    @Test
    public void powPositiveTest() throws CalculatorException {
        calculator.setExpression("pow(1023523.2123,1)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "1023523.2123");

        calculator.setExpression("pow(1023523.2123,2)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "1.0475997661169109E12");

        calculator.setExpression("pow(-1023523.2123,10)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "1.2617606059848069E60");

        calculator.setExpression("-pow(12345,23.5)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "-1.4126699768405344E96");

        calculator.setExpression("-pow(12*23+91/2*(4-5),23.5)");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "-3.3324746048447825E55");

    }

    @Test
    public void naturalLogPositiveTest() throws CalculatorException {
        calculator.setExpression("log(1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "13.8387613632");

        calculator.setExpression("log(1023523)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "13.8387611557");

        calculator.setExpression("log(+1023523.2123)");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "13.8387613632");

        calculator.setExpression("+log(1023523.2123)");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "13.8387613632");

        calculator.setExpression("-log(12*23+91/2*(4-5.13))");
        CalculatorDTO expected4 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected4.getResult(), "-5.4142542547");
    }

    @Test
    public void baseLogPositiveTest() throws CalculatorException {
        calculator.setExpression("logB(2,1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "19.9651123907");

        calculator.setExpression("+logB(10,1023523.2123)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "6.0100976964");

        calculator.setExpression("-logB(10,12*23+91/2*(4-5.13))");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "-2.3513807464");

        calculator.setExpression("-logB(10,+(12*23+91/2*(4-5.13)))");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "-2.3513807464");
    }

    @Test
    public void decimalLogPositiveTest() throws CalculatorException {
        calculator.setExpression("logD(1023523.2123)");
        CalculatorDTO expected = calculatorServiceImpl.compute(calculator);
        assertEquals(expected.getResult(), "6.0100976964");

//        calculator.setExpression("logB(-2,1023523.2123)");
//        Calculator expected1 = calculatorServiceImpl.compute(calculator);
//        assertEquals(expected1.getResult(), "-19.9651123907");

        calculator.setExpression("+logD(1023523.2123)");
        CalculatorDTO expected1 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected1.getResult(), "6.0100976964");

        calculator.setExpression("-logD(12*23+91/2*(4-5.13))");
        CalculatorDTO expected2 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected2.getResult(), "-2.3513807464");

        calculator.setExpression("-----logD(+(12*23+91/2*(4-5.13)))");
        CalculatorDTO expected3 = calculatorServiceImpl.compute(calculator);
        assertEquals(expected3.getResult(), "-2.3513807464");
    }
}
