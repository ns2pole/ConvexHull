package org.example;

import java.util.Objects;

public class Linear2DPolynomial {
    private int a;
    private int b;
    private int c;

    Linear2DPolynomial(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Linear2DPolynomial)) {
            return false;
        }

        Linear2DPolynomial other = (Linear2DPolynomial) o;
        return this.a == other.a && this.b == other.b && this.c == other.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return this.a + "x+" +  this.b + "y+" +  this.c + " = 0";
    }
}