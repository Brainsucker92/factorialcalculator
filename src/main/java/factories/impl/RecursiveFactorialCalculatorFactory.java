package factories.impl;

import factorial.BigIntegerFactorialCalculator;
import factorial.LongFactorialCalculator;
import factorial.impl.RecursiveBigIntFactorialCalculator;
import factorial.impl.RecursiveLongFactorialCalculator;
import factories.FactorialCalculatorFactory;

/**
 * Returns factorial calculators with an recursive implementation.
 */
public class RecursiveFactorialCalculatorFactory implements FactorialCalculatorFactory {

    private static FactorialCalculatorFactory instance;

    protected RecursiveFactorialCalculatorFactory() {
        // restrict object creation
    }

    public static synchronized FactorialCalculatorFactory getInstance() {
        if (instance == null) {
            instance = new RecursiveFactorialCalculatorFactory();
        }
        return instance;
    }

    @Override
    public LongFactorialCalculator getLongCalculator() {
        return new RecursiveLongFactorialCalculator();
    }

    @Override
    public BigIntegerFactorialCalculator getBigIntegerCalculator() {
        return new RecursiveBigIntFactorialCalculator();
    }
}
