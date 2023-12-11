package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinearEquationTest {

    // 3/2 x_1 + 4/3 x_2 = 3/1,
    private LinearEquation getTest2DEq_1() {
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 2), new Ratio(2, 3), new Ratio(3, 4))
        );
        Ratio cEq1 = new Ratio(1, 3);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);
        return eq1;
    }

    // 6/5 x_1 + 7/6 x_2 = 3/2,
    private LinearEquation getTest2DEq_2() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(5, 6), new Ratio(6, 7))
        );
        Ratio cEq2 = new Ratio(2, 3);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        return eq2;
    }

    // 9/8 x_1 + 10/9 x_2 = 4/3
    private LinearEquation getTest2DEq_3() {
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(8, 9), new Ratio(9, 10))
        );
        Ratio cEq3 = new Ratio(3, 4);
        LinearEquation eq3 = new LinearEquation(coefficientsEq3, cEq3);
        return eq3;
    }

    // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
    private LinearEquation getTest3DEq_1() {
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 2), new Ratio(2, 3), new Ratio(3, 4))
        );
        Ratio cEq1 = new Ratio(1, 3);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);
        return eq1;
    }

    // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    private LinearEquation getTest3DEq_2() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(4, 5), new Ratio(5, 6), new Ratio(6, 7))
        );
        Ratio cEq2 = new Ratio(2, 3);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        return eq2;
    }

    // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
    private LinearEquation getTest3DEq_3() {
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(7, 8), new Ratio(8, 9), new Ratio(9, 10))
        );
        Ratio cEq3 = new Ratio(3, 4);
        LinearEquation eq3 = new LinearEquation(coefficientsEq3, cEq3);
        return eq3;
    }

    private LinearEquation getTest3DFirstIndexUnitEq_1() {
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 1), new Ratio(4, 3), new Ratio(3, 2))
        );
        Ratio cEq1 = new Ratio(2, 3);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);
        return eq1;
    }

    // 0/1 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    private LinearEquation getTestIndexZero3DEq_2() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(5, 6), new Ratio(6, 7))
        );
        Ratio cEq2 = new Ratio(2, 3);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        return eq2;
    }

    // 0/1 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
    private LinearEquation getTestIndexZero3DEq_3() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(8, 9), new Ratio(9, 10))
        );
        Ratio cEq2 = new Ratio(3, 4);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        return eq2;
    }





    private ArrayList<LinearEquation> getTest3DEqs_1() {
        // 既存のeq1
        LinearEquation eq1 = getTest3DEq_1();
        LinearEquation eq2 = getTest3DEq_2();
        LinearEquation eq3 = getTest3DEq_3();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        System.out.println(eqs);
        return eqs;
    }

    // 1/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
    // 0/1 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    // 0/1 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
    private ArrayList<LinearEquation> getTest3DEqs_2() {
        LinearEquation eq1 = getTest3DFirstIndexUnitEq_1();
        LinearEquation eq2 = getTestIndexZero3DEq_2();
        LinearEquation eq3 = getTestIndexZero3DEq_3();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        return eqs;
    }

    // 6/5 x_1 + 7/6 x_2 = 3/2,
    // 9/8 x_1 + 10/9 x_2 = 4/3
    private ArrayList<LinearEquation> getTest2DEqs() {
        LinearEquation eq1 = getTest2DEq_2();
        LinearEquation eq2 = getTest2DEq_3();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2));
        System.out.println(eqs);
        return eqs;
    }
    @Test
    void toUnitAndSwept() {
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        ArrayList<LinearEquation> actual = LinearEquation.toUnitAndSwept(eqs);

        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 2), new Ratio(2, 3), new Ratio(3, 4))
        );
        Ratio cEq1 = new Ratio(1, 3);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);

        // 新しい方程式eq2
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(80, 21), new Ratio(3, 1))
        );
        Ratio cEq2 = new Ratio(8, -3);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);

        // 新しい方程式eq3
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(56, 15), new Ratio(63, 22))
        );
        Ratio cEq3 = new Ratio(21, -8);

    }

    @Test
    void getSolution() {
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        int targetRow = LinearEquation.getTargetRowNum(eqs);
        ArrayList<LinearEquation> unitEqsForTargetRow = LinearEquation.toUnitForTargetRow(eqs);
        ArrayList<LinearEquation> newEqs = unitEqsForTargetRow.get(targetRow).sweptFor(unitEqsForTargetRow);


        assertEquals(1,1);
    }

    @Test
    void cut() {
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        ArrayList<LinearEquation> actual = LinearEquation.cut(0,0,eqs);
        ArrayList<LinearEquation> expected = getTest2DEqs();
        assertEquals(expected, actual);
    }

    @Test
    void getTargetColumnNum() {
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        int actual = LinearEquation.getTargetColumnNum(eqs);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void getSweptedNum() {
        ArrayList<LinearEquation> eqs1 = getTest3DEqs_1();
        int actual1 = LinearEquation.getSweptedNum(eqs1);
        int expected1 = 0;
        assertEquals(expected1, actual1);
        ArrayList<LinearEquation> eqs2 = getTest3DEqs_2();
        int actual2 = LinearEquation.getSweptedNum(eqs2);
        System.out.println(eqs2);
        int expected2 = 1;
        assertEquals(expected2, actual2);
    }

    @Test
    void timesBy() {
    }

    @Test
    void minus() {
    }

    @Test
    void getFirstNonZeroIndex() {
    }

    @Test
    void getSortedEqs() {
    }

    @Test
    void sweptFor() {
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        LinearEquation eq = eqs.get(0);
        ArrayList<LinearEquation> actual = eq.sweptFor(eqs);
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 2), new Ratio(2, 3), new Ratio(3, 4))
        );
        Ratio cEq1 = new Ratio(1, 3);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);

        // 新しい方程式eq2
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(80, 21), new Ratio(3, 1))
        );
        Ratio cEq2 = new Ratio(8, -3);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);

        // 新しい方程式eq3
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(56, 15), new Ratio(63, 22))
        );
        Ratio cEq3 = new Ratio(21, -8);

        // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
        // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
        // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21]

        LinearEquation eq3 = new LinearEquation(coefficientsEq3, cEq3);
        ArrayList<LinearEquation> expected = new ArrayList<>(List.of(eq1, eq2, eq3));
        System.out.println(actual);

        assertEquals(expected, actual);
    }

    @Test
    void testSweptFor() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}