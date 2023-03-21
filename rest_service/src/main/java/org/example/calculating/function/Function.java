package org.example.calculating.function;

import java.util.List;


@FunctionalInterface
public interface Function {
    double apply(List<Double> values);
}
