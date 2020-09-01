package factorial;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiFunction;

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
     * {@link #getOverflowLimit()}
     *
     * @param prevResult A result that has been calculated previously
     * @param n          The value to check whether overflow occurs or not
     * @return True, if multiplication would overflow the value provided by {@link #getOverflowLimit()}. False otherwise
     */
    protected boolean isOverflow(T prevResult, int n) {
        if (!canOverflow()) {
            return false;
        }

        T overflowLimit = getOverflowLimit();
        BiFunction<T, Integer, T> divisionFunction = getDivisionFunction();
        T divResult = divisionFunction.apply(overflowLimit, n);
        Comparator<T> comparator = getComparator();
        int cmp = comparator.compare(divResult, prevResult);
        return cmp < 0;
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

    protected abstract BiFunction<T, Integer, T> getDivisionFunction();

    protected abstract Comparator<T> getComparator();

    private void checkArgument(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of negative numbers.");
        }
    }

    private boolean isReusable(Map.Entry<Integer, T> entry, int n) {
        return n == entry.getKey();
    }
}
