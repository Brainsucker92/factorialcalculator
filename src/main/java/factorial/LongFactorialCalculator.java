package factorial;

import java.util.Map;

public abstract class LongFactorialCalculator extends BasicFactorialCalculator<Long> {
    @Override
    protected Long identity() {
        return 1L;
    }

    @Override
    protected Long calculate(Map.Entry<Integer, Long> entry, int n) {
        Long fac = calculate(n - 1);
        if (Long.MAX_VALUE / n < fac) {
            throw new ArithmeticException("Overflow detected");
        }
        return n * fac;
    }

    protected abstract Long calculate(int n);
}
