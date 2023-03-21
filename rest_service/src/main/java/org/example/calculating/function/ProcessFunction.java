package org.example.calculating.function;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;
import org.example.exception.calculator.WrongNumberOfArgumentsException;

import java.util.HashMap;
import java.util.Map;

public enum ProcessFunction {

    MIN("min", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        return args.stream().min(Double::compare).get();
    }),
    MAX("max", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        return args.stream().max(Double::compare).get();
    }),
    SIN("sin", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 1) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 1");
        }

        return Precision.round(FastMath.sin(Math.toRadians(args.get(0))), 10);
    }),
    COS("cos", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 1) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 1");
        }

        return Precision.round(FastMath.cos(Math.toRadians(args.get(0))), 10);
    }),
    TAN("tan", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 1) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 1");
        }
        return Precision.round(FastMath.tan(Math.toRadians(args.get(0))), 10);
    }),
    SQRT("sqrt", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        return Precision.round(FastMath.sqrt(args.get(0)), 7);
    }),
    POW("pow", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 2) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 2");
        }

        return Precision.round(FastMath.pow(args.get(0), args.get(1)), 11);
    }),
    NATURAL_LOG("log", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 1) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 1");
        }

        return Precision.round(FastMath.log(args.get(0)), 10);
    }),
    BASE_LOG("logB", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 2) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 2");
        }

        return Precision.round(FastMath.log(args.get(0), args.get(1)), 10);
    }),
    DECIMAL_LOG("logD", args -> {
        if (args.isEmpty()) {
            throw new IllegalArgumentException("Empty argument list");
        }
        if (args.size() != 1) {
            throw new WrongNumberOfArgumentsException("Number of arguments != 1");
        }

        return Precision.round(FastMath.log10(args.get(0)), 10);
    });

    private final String functionName;
    private final Function function;

    ProcessFunction(String functionName, Function function) {
        this.functionName = functionName;
        this.function = function;
    }

    public static Map<String, ProcessFunction> getFunctions() {
        Map<String, ProcessFunction> map = new HashMap<>();
        map.put("min", ProcessFunction.MIN);
        map.put("max", ProcessFunction.MAX);
        map.put("sin", ProcessFunction.SIN);
        map.put("cos", ProcessFunction.COS);
        map.put("tan", ProcessFunction.TAN);
        map.put("sqrt", ProcessFunction.SQRT);
        map.put("pow", ProcessFunction.POW);
        map.put("log", ProcessFunction.NATURAL_LOG);
        map.put("logB", ProcessFunction.BASE_LOG);
        map.put("logD", ProcessFunction.DECIMAL_LOG);

        return map;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public Function getFunction() {
        return this.function;
    }

    @Override
    public String toString() {
        return String.format("ProcessFunction{name:%s,function:%s}", this.functionName, this.function);
    }
}
