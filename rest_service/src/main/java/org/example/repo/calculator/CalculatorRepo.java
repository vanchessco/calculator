package org.example.repo.calculator;

import org.example.domain.calculator.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepo extends JpaRepository<Calculator, Long> {
}
