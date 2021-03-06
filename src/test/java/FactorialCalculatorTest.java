import java.util.stream.Stream;

import factorial.FactorialCalculator;
import factorial.impl.GuavaFactorialCalculator;
import factorial.impl.IterativeBigIntFactorialCalculator;
import factorial.impl.IterativeLongFactorialCalculator;
import factorial.impl.MemoizedFactorialCalculator;
import factorial.impl.RecursiveBigIntFactorialCalculator;
import factorial.impl.RecursiveLongFactorialCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    private static final Number[] factorials = {1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L};

    public static Stream<Arguments> provideArguments() {
        return Stream.of(Arguments.of(new GuavaFactorialCalculator()),
                Arguments.of(new IterativeBigIntFactorialCalculator()),
                Arguments.of(new IterativeLongFactorialCalculator()),
                Arguments.of(new RecursiveBigIntFactorialCalculator()),
                Arguments.of(new RecursiveLongFactorialCalculator()),
                Arguments.of(new MemoizedFactorialCalculator<>(new RecursiveLongFactorialCalculator())));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void factorialTest(FactorialCalculator<Number> calculator) {
        for (int i = 0; i < factorials.length; i++) {
            assertEquals(factorials[i].longValue(), calculator.factorial(i).longValue());
        }
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void test_negative(FactorialCalculator<Number> calculator) {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
}