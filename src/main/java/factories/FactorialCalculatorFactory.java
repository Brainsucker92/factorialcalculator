package factories;

import factorial.BigIntegerFactorialCalculator;
import factorial.LongFactorialCalculator;

public interface FactorialCalculatorFactory {

    // IntegerFactorialCalculator getIntegerCalculator();

    LongFactorialCalculator getLongCalculator();

    BigIntegerFactorialCalculator getBigIntegerCalculator();
}
