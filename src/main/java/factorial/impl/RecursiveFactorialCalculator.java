package factorial.impl;

import factorial.BasicFactorialCalculator;
import factorial.tools.ArithmeticOperations;

import java.util.Map;

public class RecursiveFactorialCalculator<T extends Number> extends BasicFactorialCalculator<T> {
    public RecursiveFactorialCalculator(ArithmeticOperations<T> operations) {
        super(operations);
    }

    @Override
    protected T calculate(Map.Entry<Integer, T> entry, int n) {
        T prevResult = factorial(entry, n - 1);
        return operations.mul(operations.from(n), prevResult);
    }
}
