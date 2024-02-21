package factorial;

import factorial.tools.ArithmeticOperations;

import java.util.AbstractMap;
import java.util.Map;

public abstract class BasicFactorialCalculator<T extends Number> implements FactorialCalculator<T> {

    protected ArithmeticOperations<T> operations;

    public BasicFactorialCalculator(ArithmeticOperations<T> operations) {
        this.operations = operations;
    }

    @Override
    public T factorial(int n) {
        Map.Entry<Integer, T> entry = new AbstractMap.SimpleEntry<>(1, operations.identity());
        return factorial(entry, n);
    }

    @Override
    public T factorial(Map.Entry<Integer, T> entry, int n) {
        checkArgument(n);
        // 0 <= n
        if (n < 2) {
            return operations.identity();
        }
        if (n == entry.getKey()) {
            return entry.getValue();
        }
        return calculate(entry, n);
    }

    /**
     * DO NOT CALL THIS METHOD RECURSIVELY! Call {@link #factorial(Map.Entry, int)} instead.
     *
     * @param entry A previously calculated factorial result as key-value-pair.
     * @param n     The number to calculate factorial form.
     * @return The result of the factorial calculation.
     */
    protected abstract T calculate(Map.Entry<Integer, T> entry, int n);

    private void checkArgument(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative numbers.");
        }
    }
}
