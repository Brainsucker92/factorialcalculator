package factorial.impl;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.LongArithmeticOperations;

public class RecursiveLongFactorialCalculator extends RecursiveFactorialCalculator<Long> {

    private static final ArithmeticOperations<Long> operations = new LongArithmeticOperations();

    public RecursiveLongFactorialCalculator() {
        super(operations);
    }
}
