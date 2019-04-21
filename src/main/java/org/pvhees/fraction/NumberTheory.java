package org.pvhees.fraction;

import java.math.BigInteger;

public class NumberTheory {

    public static int gcd(int a, int b) {
        // gcd van negatieve nummers is gelijk aan de gcd van de positieve varianten
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int savedB = b;
            b = a % b;
            a = savedB;
        }

        return a;
    }

}
