package org.pvhees.fraction;

import org.junit.Test;
import org.pvhees.fraction.NumberTheory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GcdTest {

    @Test
    public void smallerNumberFirst() throws Exception {
        assertThat(NumberTheory.gcd(2, 4), equalTo(2));
    }

    @Test
    public void largerNumberFirst() throws Exception {
        assertThat(NumberTheory.gcd(4, 2), equalTo(2));
    }

    @Test
    public void oneIsZero() throws Exception {
        assertThat(NumberTheory.gcd(1234, 0), equalTo(1234));
        assertThat(NumberTheory.gcd(0, 1234), equalTo(1234));
    }

    @Test
    public void bothAreZero() throws Exception {
        assertThat(NumberTheory.gcd(0, 0), equalTo(0));
    }

    @Test
    public void oneIsNegative() throws Exception {
        assertThat(NumberTheory.gcd(-1230, 123), equalTo(123));
        assertThat(NumberTheory.gcd(1230, -123), equalTo(123));
    }

    @Test
    public void bothAreNegative() throws Exception {
        assertThat(NumberTheory.gcd(-1230, -123), equalTo(123));
    }

}
