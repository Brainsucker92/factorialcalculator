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

    public final boolean canOverflow() {
        return getOverflowLimit() != null;
    }

    protected abstract T calculate(Map.Entry<Integer, T> entry, int n);

    protected abstract T identity();

    /**
     * Checks whether the multiplication of {@code prevResult} with {@code n} would overflow the value provided by
     * {@code getOverflowLimit}
     *
     * @param prevResult A result that has been calculated previously
     * @param n          The value to check whether overflow occurs or not
     * @return True, if multiplication would overflow the value provided by {@code getOverflowLimit}. False otherwise
     */
    protected boolean isOverflow(T prevResult, int n) {
        T overflowLimit = getOverflowLimit();
        if (!canOverflow()) {
            return false;
        }
        return (overflowLimit.longValue() / n) < prevResult.longValue();
    }

    /**
     * Checks for an occurring overflow and throws an Exception if overflow is detected.
     *
     * @param prevResult A previously calculated result
     * @param n          The value to check overflow with
     * @throws ArithmeticException If overflow is detected
     */
    protected final void checkOverflow(T prevResult, int n) {
        if (isOverflow(prevResult, n)) {
            throw new ArithmeticException("Overflow detected for n=" + n);
        }
    }

    protected abstract T getOverflowLimit();

    private void checkArgument(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative numbers.");
        }
    }

    private boolean isReusable(Map.Entry<Integer, T> entry, int n) {
        return n == entry.getKey();
    }
}
