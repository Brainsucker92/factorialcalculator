package factorial.impl;

import java.util.AbstractMap;
import java.util.Map;

import factorial.FactorialCalculator;

public abstract class BasicFactorialCalculator<T extends Number> implements FactorialCalculator<T> {
    @Override
    public T factorial(int n) {
        Map.Entry<Integer, T> entry = new AbstractMap.SimpleEntry<>(1, identity());
        return factorial(entry, n);
    }

    @Override
    public T factorial(Map.Entry<Integer, T> entry, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative numbers.");
        } else if (n >= 2) {
            return calculate(entry, n);
        }
        // 0 <= n < 2
        return identity();
    }

    protected abstract T calculate(Map.Entry<Integer, T> entry, int n);

    protected abstract T identity();
}
