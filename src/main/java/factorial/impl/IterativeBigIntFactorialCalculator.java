package factorial.impl;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.BigIntegerArithmeticOperations;

import java.math.BigInteger;

public class IterativeBigIntFactorialCalculator extends IterativeFactorialCalculator<BigInteger> {

    private static final ArithmeticOperations<BigInteger> operations = new BigIntegerArithmeticOperations();

    public IterativeBigIntFactorialCalculator() {
        super(operations);
    }
}
