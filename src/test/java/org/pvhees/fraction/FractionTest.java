package org.pvhees.fraction;

import org.junit.Test;
import org.pvhees.fraction.Fraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FractionTest {

    // IDEA: rework into data driven test ?

    @Test
    public void zeroPlusZero() {
        assertEquals(new Fraction(0).add(new Fraction(0)), new Fraction(0));
    }

    @Test
    public void nonZeroPlusNonZero() {
        assertEquals(new Fraction(1).add(new Fraction(2)), new Fraction(3));
    }

    @Test
    public void addingSevenThirdsAndFourFifthsGivesFortySevenFifteenths() {
        testFractionSum(7, 3, 4, 5, 47, 15);
    }

    @Test
    public void twoHalvesMakeOne() {
        testFractionSum(1, 2, 1, 2, 1, 1);
    }

    @Test
    public void equalDenominatorsAndNumeratorsBothPositive() {
        testFractionSum(1, 4, 5, 4, 3, 2);
    }

    @Test
    public void equalDenominatorsSecondNumeratorNegative() {
        testFractionSum(1, 4, -1, 4, 0, 4);
    }

    @Test
    public void equalDenominatorsFirstNumeratorNegative() {
        testFractionSum(-1, 4, 1, 4, 0, 4);
    }

    @Test
    public void equalDenominatorsBothNumeratorsNegative() {
        testFractionSum(-1, 4, -1, 4, -1, 2);
    }

    @Test
    public void differentDenominatorsBothPositive() {
        testFractionSum(1, 2, 1, 4, 3, 4);
    }

    private void testFractionSum(int num1, int denom1, int num2, int denom2, int numRes, int denomRes) {
        Fraction sum = new Fraction(num1, denom1).add(new Fraction(num2, denom2));
        assertEquals(sum , new Fraction(numRes, denomRes));
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroes() {
        Fraction sum = new Fraction(0, 0).add(new Fraction(0, 0));
        fail("Expected NPE");
    }

}
