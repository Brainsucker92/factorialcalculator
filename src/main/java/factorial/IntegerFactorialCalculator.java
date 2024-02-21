package factorial;

import factorial.tools.ArithmeticOperations;
import factorial.tools.impl.IntegerArithmeticOperations;

public abstract class IntegerFactorialCalculator extends BasicFactorialCalculator<Integer> {

    private static final ArithmeticOperations<Integer> INTEGER_ARITHMETIC_OPERATIONS = new IntegerArithmeticOperations();

    public IntegerFactorialCalculator() {
        super(INTEGER_ARITHMETIC_OPERATIONS);
    }
}
