package factorial.impl;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.BigIntegerArithmeticOperations;

import java.math.BigInteger;

public class RecursiveBigIntFactorialCalculator extends RecursiveFactorialCalculator<BigInteger> {

    private static final ArithmeticOperations<BigInteger> operations = new BigIntegerArithmeticOperations();

    public RecursiveBigIntFactorialCalculator() {
        super(operations);
    }
}
