/*     / \____  _    _  ____   ______  / \ ____  __    _______
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  //  /\__\   JΛVΛSLΛNG
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/ \ /__\ \   Copyright 2014-2016 Javaslang, http://javaslang.io
 * /___/\_/  \_/\____/\_/  \_/\__\/__/\__\_/  \_//  \__/\_____/   Licensed under the Apache License, Version 2.0
 */
package javaslang.collection.euler;

import javaslang.collection.Stream;
import static javaslang.collection.euler.Utils.factors;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Euler12Test {

    /**
     * <strong>Problem 12: Highly divisible triangular number</strong>
     * <p>
     * The sequence of triangle numbers is generated by adding the natural
     * numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 =
     * 28. The first ten terms would be:
     * <p>
     * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
     * <p>
     * Let us list the factors of the first seven triangle numbers:
     * <pre>
     * 1: 1
     * 3: 1,3
     * 6: 1,2,3,6
     * 10: 1,2,5,10
     * 15: 1,3,5,15
     * 21: 1,3,7,21
     * 28: 1,2,4,7,14,28
     * </pre>
     * <p>
     * We can see that 28 is the first triangle number to have over five
     * divisors.
     * <p>
     * What is the value of the first triangle number to have over five hundred
     * divisors?
     */
    @Test
    public void shouldSolveProblem12() {
        assertThat(valueOfFirstTriangleNumberWithMoreDivisorsThan(5)).isEqualTo(28);
        assertThat(valueOfFirstTriangleNumberWithMoreDivisorsThan(500)).isEqualTo(76_576_500);
    }

    private static long valueOfFirstTriangleNumberWithMoreDivisorsThan(long divisorCount) {
        return triangleNumbers()
                .find(t -> divisorCount(t) > divisorCount)
                .get();
    }

    private static Stream<Long> triangleNumbers() {
        return Stream.from(1L).scanLeft(0L, (a, l) -> a + l);
    }

    private static long divisorCount(long number) {
        return factors(number).length();
    }
}
