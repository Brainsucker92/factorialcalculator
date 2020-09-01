package factorial;

import java.util.Comparator;
import java.util.function.BiFunction;

public abstract class LongFactorialCalculator extends BasicFactorialCalculator<Long> {
    @Override
    protected Long identity() {
        return 1L;
    }

    @Override
    protected final Long getOverflowLimit() {
        return Long.MAX_VALUE;
    }

    @Override
    protected BiFunction<Long, Integer, Long> getDivisionFunction() {
        return (aLong, integer) -> aLong / integer;
    }

    @Override
    protected Comparator<Long> getComparator() {
        return Comparator.naturalOrder();
    }
}