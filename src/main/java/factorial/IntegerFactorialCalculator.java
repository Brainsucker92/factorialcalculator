package factorial;

import java.util.Map;

public abstract class IntegerFactorialCalculator extends BasicFactorialCalculator<Integer> {
    @Override
    protected Integer identity() {
        return 1;
    }

    @Override
    protected Integer calculate(Map.Entry<Integer, Integer> entry, int n) {
        Integer fac = calculate(n - 1);
        if (Integer.MAX_VALUE / n < fac) {
            throw new ArithmeticException("Overflow detected");
        }
        return n * fac;
    }

    protected abstract Integer calculate(int n);
}
