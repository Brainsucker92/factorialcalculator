package factorial;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.LongArithmeticOperations;

public abstract class LongFactorialCalculator extends BasicFactorialCalculator<Long> {

    private static final ArithmeticOperations<Long> LONG_ARITHMETIC_OPERATIONS = new LongArithmeticOperations();

    public LongFactorialCalculator() {
        super(LONG_ARITHMETIC_OPERATIONS);
    }
}