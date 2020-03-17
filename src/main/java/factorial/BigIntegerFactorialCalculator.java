package factorial;

import java.math.BigInteger;

public abstract class BigIntegerFactorialCalculator extends BasicFactorialCalculator<BigInteger> {
    @Override
    protected BigInteger identity() {
        return BigInteger.ONE;
    }

    protected final BigInteger getOverflowLimit() {
        return null;
    }
}
