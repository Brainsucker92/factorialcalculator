package factorial;

import java.util.Map;

public interface FactorialCalculator<T extends Number> {

    T factorial(int n);

    /**
     * Calculates the factorial based on a previously calculated (lower) result. This way, already calculated results can
     * be reused to reduce calculation time.
     *
     * @param entry The previously calculated result
     * @param n     The number of the factorial to calculate
     * @return The result of the calculation
     * @throws IllegalArgumentException if n is negative
     */
    T factorial(Map.Entry<Integer, T> entry, int n);
}
