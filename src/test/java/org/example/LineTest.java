package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LineTest {

    @Test
    public void testConstructor_throwsExceptionForIdenticalDots() {
        Dot dot1 = new Dot(1, 2);
        Dot dot2 = new Dot(1, 2);
        assertThrows(IdenticalPointsException.class, () -> {
            new Line(dot1, dot2);
        });
    }

    @Test
    public void getLinear2DPolynomial() {

        //Linear2DPolynomialはax+by+c=0を表すクラス。
        //例えば、new Linear2DPolynomial(2, -1, -1)は2x-y-1=0を表す。
        //(1,1),(2,3)を通る点は2x-y-1=0
        Linear2DPolynomial expected1 = new Linear2DPolynomial(2, -1, -1);
        Dot d1_1 = new Dot(1, 1);
        Dot d2_1 = new Dot(2, 3);
        Linear2DPolynomial actual1 = new Line(d1_1, d2_1).getLinear2DPolynomial();
        assertEquals(expected1, actual1);

        //(1,3),(2,3)を通る点はy-3=0
        Linear2DPolynomial expected2 = new Linear2DPolynomial(0, 1, -3);
        Dot d1_2 = new Dot(1, 3);
        Dot d2_2 = new Dot(2, 3);
        Linear2DPolynomial actual2 = new Line(d1_2, d2_2).getLinear2DPolynomial();
        assertEquals(expected2, actual2);

        //(3,1),(3,2)を通る点はx-3=0
        Linear2DPolynomial expected3 = new Linear2DPolynomial(1, 0, -3);
        Dot d1_3 = new Dot(3, 1);
        Dot d2_3 = new Dot(3, 2);
        Linear2DPolynomial actual3 = new Line(d1_3, d2_3).getLinear2DPolynomial();
        assertEquals(expected3, actual3);

        //(1,1),(3,3)を通る点はx-y=0
        Linear2DPolynomial expected4 = new Linear2DPolynomial(1, -1, 0);
        Dot d1_4 = new Dot(1, 1);
        Dot d2_4 = new Dot(3, 3);
        Linear2DPolynomial actual4 = new Line(d1_4, d2_4).getLinear2DPolynomial();
        assertEquals(expected4, actual4);


    }

}