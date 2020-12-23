package factorial;

import java.util.AbstractMap;
import java.util.Map;

public abstract class BasicFactorialCalculator<T extends Number> implements FactorialCalculator<T> {
    @Override
    public T factorial(int n) {
        Map.Entry<Integer, T> entry = new AbstractMap.SimpleEntry<>(1, identity());
        return factorial(entry, n);
    }

    @Override
    public T factorial(Map.Entry<Integer, T> entry, int n) {
        checkArgument(n);
        // 0 <= n
        if (n < 2) {
            return identity();
        }
        if (isReusable(entry, n)) {
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

    protected abstract T identity();

    private void checkArgument(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative numbers.");
        }
    }

    private boolean isReusable(Map.Entry<Integer, T> entry, int n) {
        return n == entry.getKey();
    }
}
