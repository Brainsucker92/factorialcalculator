package factorial;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.function.BiFunction;

public abstract class BigIntegerFactorialCalculator extends BasicFactorialCalculator<BigInteger> {
    @Override
    protected BigInteger identity() {
        return BigInteger.ONE;
    }

    protected final BigInteger getOverflowLimit() {
        return null;
    }

    @Override
    protected BiFunction<BigInteger, Integer, BigInteger> getDivisionFunction() {
        // Not required
        return null;
    }

    @Override
    protected Comparator<BigInteger> getComparator() {
        // Not required
        return null;
    }
}
