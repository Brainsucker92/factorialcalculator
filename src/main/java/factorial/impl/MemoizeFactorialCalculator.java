package factorial.impl;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import factorial.FactorialCalculator;

public class MemoizeFactorialCalculator<T extends Number> implements FactorialCalculator<T> {

    private FactorialCalculator<T> calculator;

    private TreeMap<Integer, T> factorialBuffer = new TreeMap<>(Comparator.naturalOrder());

    public MemoizeFactorialCalculator(FactorialCalculator<T> calculator) {
        this.calculator = calculator;
    }

    @Override
    public T factorial(int n) {
        return calculator.factorial(n);
    }

    @Override
    public T factorial(Map.Entry<Integer, T> entry, int n) {
        if (factorialBuffer.containsKey(n)) {
            // Result is already known
            return factorialBuffer.get(n);
        }

        // Check internal buffer first:
        Map.Entry<Integer, T> floorEntry = factorialBuffer.floorEntry(n);
        if (floorEntry == null) {
            // factorialBuffer is empty
            int i = 1;
            T identity = calculator.factorial(i);
            factorialBuffer.put(i, identity);
        }
        Integer externalKey = entry.getKey();

        // Compare keys and decide which entry to use:
        Map.Entry<Integer, T> closestEntry;
        do {
            // Find current floorEntry:
            floorEntry = factorialBuffer.floorEntry(n);
            Integer floorEntryKey = floorEntry.getKey();

            // Determine closest entry:
            int diff = floorEntryKey.compareTo(externalKey);
            closestEntry = (diff > 0) ? floorEntry : entry;

            // Calculate new entry:
            int newKey = closestEntry.getKey() + 1;
            T newValue = calculator.factorial(closestEntry, newKey);

            // Update current data:
            factorialBuffer.put(newKey, newValue);
        } while (closestEntry.getKey() < n);

        return factorialBuffer.get(n);
    }
}
