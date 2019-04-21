package org.pvhees.fraction;

public class Fraction {

    private final int denominator;
    private final int numerator;

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("zero denominator");
        }

        int gcd = NumberTheory.gcd(numerator, denominator);

        // normalize denominator so that only numerator is negative for negative fraction
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    public Fraction add(Fraction other) {
        int numerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int denominator = this.denominator * other.denominator;

        return new Fraction(numerator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;

        Fraction that = (Fraction) o;

        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return  31 * denominator + numerator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
