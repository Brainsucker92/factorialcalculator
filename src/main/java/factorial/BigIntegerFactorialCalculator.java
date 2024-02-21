package factorial;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.BigIntegerArithmeticOperations;

import java.math.BigInteger;

public abstract class BigIntegerFactorialCalculator extends BasicFactorialCalculator<BigInteger> {

    private static final ArithmeticOperations<BigInteger> BIG_INTEGER_ARITHMETIC_OPERATIONS = new BigIntegerArithmeticOperations();

    public BigIntegerFactorialCalculator() {
        super(BIG_INTEGER_ARITHMETIC_OPERATIONS);
    }
}
