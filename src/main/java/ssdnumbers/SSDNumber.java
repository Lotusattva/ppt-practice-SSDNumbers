package ssdnumbers;

import java.util.Map.Entry;
import java.util.*;

public class SSDNumber {

    /********** Task 1 **********/

    public static boolean isSemiSelfDescriptive(String intAsString) {
        Map<Integer, Integer> digitFreq = new HashMap<>(9);
        for (char c : intAsString.toCharArray()) {
            int digit = c - '0';
            digitFreq.put(digit, digitFreq.getOrDefault(digit, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : digitFreq.entrySet()) {
            if (entry.getKey() != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    /********** Task 2 **********/

    /**
     * Obtain the largest SSDNumber (as a String) with {@code numDigits} digits that
     * contains the digit {@code mustContainDigit}.
     * 
     * @param numDigits        the number of digits in the SSDNumber,
     *                         {@code numDigits} > 0
     * @param mustContainDigit a digit that must be present in the number being
     *                         generated, 0 < {@code mustContainDigit} < 10
     * @return the largest SSDNumber (as a String) with {@code numDigits} digits
     *         that contains the digit {@code mustContainDigit}
     * @throws NoSuchElementException if no such SSDNumber exists
     */
    public static String getLargestSSDNumber(int numDigits, int mustContainDigit)
            throws NoSuchElementException {
        numDigits -= mustContainDigit;
        if (numDigits < 0) {
            throw new NoSuchElementException();
        }
        List<Integer> digits = new ArrayList<>();
        digits.add(mustContainDigit);
        digits = getDigits(numDigits, digits);
        if (digits == null) {
            throw new NoSuchElementException();
        }
        StringBuilder sb = new StringBuilder();
        digits.sort((a, b) -> b - a);
        for (int digit : digits) {
            for (int i = 0; i < digit; i++) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    private static List<Integer> getDigits(int numDigits, List<Integer> digits) {
        if (digits.size() == 9 && numDigits > 0) {
            return null;
        }
        if (numDigits == 0) {
            return digits;
        }
        List<Integer> candidates = new ArrayList<>(9);
        candidates.addAll(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
        candidates.removeAll(digits);
        candidates.sort((a, b) -> b - a);
        for (int candidate : candidates) {
            if (numDigits >= candidate) {
                List<Integer> newDigits = new ArrayList<>(digits);
                newDigits.add(candidate);
                if (numDigits == candidate) {
                    return newDigits;
                } else {
                    List<Integer> result = getDigits(numDigits - candidate, newDigits);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }

    /********** Task 3 **********/

    /**
     * Obtain an iterator that iterates over all SSDNumbers of a given length
     * (specified by {@code numDigits}), starting with the smallest such
     * number and going up to the largest such number.
     *
     * @param numDigits the number of digits in the SSDNumbers we are iterating
     *                  over,
     *                  {@code numDigits} > 0
     * @return an iterator that iterates over all SSDNumbers of a given length
     *         (specified by {@code numDigits}), starting with the smallest such
     *         number and going up to the largest such number.
     */
    public static SSDNumberIterator getSSDNumberIterator(int numDigits) {
        // TODO: Implement this method
        return null;
    }

}
