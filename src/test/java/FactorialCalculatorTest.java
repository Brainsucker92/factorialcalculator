import java.util.stream.Stream;

import factorial.FactorialCalculator;
import factorial.impl.GuavaFactorialCalculator;
import factorial.impl.IterativeBigIntFactorialCalculator;
import factorial.impl.IterativeLongFactorialCalculator;
import factorial.impl.MemoizeFactorialCalculator;
import factorial.impl.RecursiveBigIntFactorialCalculator;
import factorial.impl.RecursiveLongFactorialCalculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    private static final Number[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

    public static Stream<Arguments> provideArguments() {
        return Stream.of(Arguments.of(new GuavaFactorialCalculator()),
                Arguments.of(new IterativeBigIntFactorialCalculator()),
                Arguments.of(new IterativeLongFactorialCalculator()),
                Arguments.of(new RecursiveBigIntFactorialCalculator()),
                Arguments.of(new RecursiveLongFactorialCalculator()),
                Arguments.of(new MemoizeFactorialCalculator<>(new RecursiveLongFactorialCalculator())));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void factorialTest(FactorialCalculator<Number> calculator) {
        for (int i = 0; i < factorials.length; i++) {
            assertEquals(factorials[i], calculator.factorial(i).intValue());
        }
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void test_negative(FactorialCalculator<Number> calculator) {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }

    @Disabled
    public void test_overflow(FactorialCalculator<Integer> calculator) {
        // TODO
    }
}