package factorial.impl;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.LongArithmeticOperations;

public class IterativeLongFactorialCalculator extends IterativeFactorialCalculator<Long> {

    private static ArithmeticOperations<Long> operations = new LongArithmeticOperations();

    public IterativeLongFactorialCalculator() {
        super(operations);
    }
}
