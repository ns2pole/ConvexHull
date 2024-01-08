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

    // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
    private LinearEquation getSweptedTest3DEq2_By_Eq1() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(80, 21), new Ratio(3, 1))
        );
        Ratio cEq2 = new Ratio(8, -3);
        return new LinearEquation(coefficientsEq2, cEq2);
    }

    // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21,
    private LinearEquation getSweptedTest3DEq3_By_Eq1() {
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(56, 15), new Ratio(63, 22))
        );
        Ratio cEq3 = new Ratio(21, -8);
        return new LinearEquation(coefficientsEq3, cEq3);
    }

    // 1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
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


    // 5/1 x_0 + 9/1 x_1 + 2/1 x_2 + 1/1 x_3 = 6/1,
    private LinearEquation getTest4DEq_1() {
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 5), new Ratio(1, 9), new Ratio(1, 2), new Ratio(1, 1))
        );
        Ratio cEq1 = new Ratio(1, 6);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);
        return eq1;
    }

    // 1/1 x_0 + 3/1 x_1 + 1/1 x_2 + 2/1 x_3 = 1/1,
    private LinearEquation getTest4DEq_2() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 1), new Ratio(1, 3), new Ratio(1, 1), new Ratio(1, 2))
        );
        Ratio cEq2 = new Ratio(1, 1);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        return eq2;
    }

    // 0/1 x_0 + 0/1 x_1 + 1/1 x_2 + 1/1 x_3 = 2/1
    private LinearEquation getTest4DEq_3() {
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(1, 0), new Ratio(1, 1), new Ratio(1, 1))
        );
        Ratio cEq3 = new Ratio(1, 2);
        LinearEquation eq3 = new LinearEquation(coefficientsEq3, cEq3);
        return eq3;
    }

    // 1/1 x_0 + 3/1 x_1 + 0/1 x_2 + 0/1 x_3 = 4/1
    private LinearEquation getTest4DEq_4() {
        ArrayList<Ratio> coefficientsEq4 = new ArrayList<>(
                List.of(new Ratio(1, 1), new Ratio(1, 3), new Ratio(1, 0), new Ratio(1, 0))
        );
        Ratio cEq4 = new Ratio(1, 4);
        LinearEquation eq4 = new LinearEquation(coefficientsEq4, cEq4);
        return eq4;
    }


    // 5/1 x_0 + 9/1 x_1 + 2/1 x_2 + 1/1 x_3 = 6/1,
    // 1/1 x_0 + 3/1 x_1 + 1/1 x_2 + 2/1 x_3 = 1/1,
    // 0/1 x_0 + 0/1 x_1 + 1/1 x_2 + 1/1 x_3 = 2/1,
    // 1/1 x_0 + 3/1 x_1 + 0/1 x_2 + 0/1 x_3 = 4/1,
    private ArrayList<LinearEquation> getTest4DEqs_1() {
        LinearEquation eq1 = getTest4DEq_1();
        LinearEquation eq2 = getTest4DEq_2();
        LinearEquation eq3 = getTest4DEq_3();
        LinearEquation eq4 = getTest4DEq_4();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3, eq4));
        System.out.println(eqs);
        return eqs;
    }

    // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
    // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
    private ArrayList<LinearEquation> getTest3DEqs_1() {
        LinearEquation eq1 = getTest3DEq_1();
        LinearEquation eq2 = getTest3DEq_2();
        LinearEquation eq3 = getTest3DEq_3();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        System.out.println(eqs);
        return eqs;
    }

    // 1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
    // 0/1 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    // 0/1 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
    private ArrayList<LinearEquation> getTest3DEqs_2() {
        LinearEquation eq1 = getTest3DFirstIndexUnitEq_1();
        LinearEquation eq2 = getTestIndexZero3DEq_2();
        LinearEquation eq3 = getTestIndexZero3DEq_3();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        return eqs;
    }

    //1/1 x_0 + 0/1 x_1 + -1/16 x_2 = 9/16
    private LinearEquation getSweptedTest3DEq1_By_Eq2() {
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 1), new Ratio(1, 0), new Ratio(16, -1))
        );
        Ratio cEq1 = new Ratio(16, 9);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);
        return eq1;
    }

    //0/1 x_0 + 1/1 x_1 + 35/36 x_2 = 5/4
    private LinearEquation getTest3DFirstIndexUnitEq_2() {
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(1, 1), new Ratio(36, 35))
        );
        Ratio cEq2 = new Ratio(4, 5);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        return eq2;
    }

    //0/1 x_0 + 0/1 x_1 + 5/288 x_2 = -7/96
    private LinearEquation getSweptedTest3DEq3_By_Eq2() {
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(1, 0), new Ratio(288, 5))
        );
        Ratio cEq3 = new Ratio(96, -7);
        LinearEquation eq3 = new LinearEquation(coefficientsEq3, cEq3);
        return eq3;
    }



    // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
    // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
    // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21
    private ArrayList<LinearEquation> getTest3DEqs_3() {
        LinearEquation eq1 = getTest3DEq_1();
        LinearEquation eq2 = getSweptedTest3DEq2_By_Eq1();
        LinearEquation eq3 = getSweptedTest3DEq3_By_Eq1();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        return eqs;
    }

    // 1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
    // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
    // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21
    private ArrayList<LinearEquation> getTest3DEqs_4() {
        LinearEquation eq1 = getTest3DFirstIndexUnitEq_1();
        LinearEquation eq2 = getSweptedTest3DEq2_By_Eq1();
        LinearEquation eq3 = getSweptedTest3DEq3_By_Eq1();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        return eqs;
    }


    //1/1 x_0 + 0/1 x_1 + -1/16 x_2 = 9/16
    //0/1 x_0 + 1/1 x_1 + 35/36 x_2 = 5/4
    //0/1 x_0 + 0/1 x_1 + 5/288 x_2 = -7/96
    private ArrayList<LinearEquation> getTest3DEqs_5() {
        LinearEquation eq1 = getSweptedTest3DEq1_By_Eq2();
        LinearEquation eq2 = getTest3DFirstIndexUnitEq_2();
        LinearEquation eq3 = getSweptedTest3DEq3_By_Eq2();
        ArrayList<LinearEquation> eqs = new ArrayList<>(List.of(eq1, eq2, eq3));
        return eqs;
    }

    //1/1 x_0 + 0/1 x_1 + 0/1 x_2 = 3/10
    //0/1 x_0 + 1/1 x_1 + 0/1 x_2 = 16/3
    //0/1 x_0 + 0/1 x_1 + 1/1 x_2 = -21/5

    private ArrayList<LinearEquation> getTest3DEqs_6() {
        ArrayList<Ratio> coefficientsEq1 = new ArrayList<>(
                List.of(new Ratio(1, 1), new Ratio(1, 0), new Ratio(1, 0))
        );
        Ratio cEq1 = new Ratio(10, 3);
        LinearEquation eq1 = new LinearEquation(coefficientsEq1, cEq1);
        ArrayList<Ratio> coefficientsEq2 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(1, 1), new Ratio(1, 0))
        );
        Ratio cEq2 = new Ratio(3, 16);
        LinearEquation eq2 = new LinearEquation(coefficientsEq2, cEq2);
        ArrayList<Ratio> coefficientsEq3 = new ArrayList<>(
                List.of(new Ratio(1, 0), new Ratio(1, 0), new Ratio(1, 1))
        );
        Ratio cEq3 = new Ratio(5, -21);
        LinearEquation eq3 = new LinearEquation(coefficientsEq3, cEq3);
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

    // 1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
    // 0/1 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    // 0/1 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
    //->
    //1/1 x_0 + 0/1 x_1 + 0/1 x_2 = 3/10
    //0/1 x_0 + 1/1 x_1 + 0/1 x_2 = 16/3
    //0/1 x_0 + 0/1 x_1 + 1/1 x_2 = -21/5

    @Test
    void getSolution() {
        ArrayList<LinearEquation> eq = getTest3DEqs_2();
        ArrayList<Ratio> actual = LinearEquation.getSolution(eq);
        ArrayList<Ratio> expected = new ArrayList<>(List.of(
                new Ratio(10, 3),
                new Ratio(3, 16),
                new Ratio(5, -21)
        ));
        assertEquals(expected, actual);

        ArrayList<LinearEquation> eq2 = getTest3DEqs_1();
        ArrayList<Ratio> actual2 = LinearEquation.getSolution(eq2);
        ArrayList<Ratio> expected2 = new ArrayList<>(List.of(
                new Ratio(8, 21),
                new Ratio(3, -5),
                new Ratio(16, 3)
        ));
        assertEquals(expected2, actual2);

        ArrayList<LinearEquation> eq3 = getTest4DEqs_1();

        ArrayList<Ratio> actual3 = LinearEquation.getSolution(eq3);
        ArrayList<Ratio> expected3 = new ArrayList<>(List.of(
                new Ratio(2, -15),
                new Ratio(6, 23),
                new Ratio(1, 7),
                new Ratio(1, -5)
        ));
        assertEquals(expected3, actual3);


    }
    @Test
    void sortAndToUnitAndSwept() {
        // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
        // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
        // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
        //->
        // 1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
        // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
        // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21
//        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
//        ArrayList<LinearEquation> actual_eq1 = LinearEquation.sortAndToUnitAndSwept(eqs);
//        ArrayList<LinearEquation> expected_eq1 = getTest3DEqs_4();
//        assertEquals(expected_eq1, actual_eq1);
//
//
//        int actual_num1 = LinearEquation.getSweptedNum(actual_eq1);
//        int expected_num1 = 1;
//        assertEquals(expected_num1, actual_num1);
//
//        // 1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
//        // 0/1 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
//        // 0/1 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
//        //->
//        //1/1 x_0 + 0/1 x_1 + -1/16 x_2 = 9/16
//        //0/1 x_0 + 1/1 x_1 + 35/36 x_2 = 5/4
//        //0/1 x_0 + 0/1 x_1 + 5/288 x_2 = -7/96
//
//        ArrayList<LinearEquation> eqs2 = getTest3DEqs_2();
//        ArrayList<LinearEquation> actual_eq2 = LinearEquation.sortAndToUnitAndSwept(eqs2);
//        ArrayList<LinearEquation> expected_eq2 = getTest3DEqs_5();
//        assertEquals(expected_eq2, actual_eq2);
//
//        int actual_num1_2 = LinearEquation.getSweptedNum(actual_eq2);
//        int expected_num1_2 = 2;
//        assertEquals(expected_num1_2, actual_num1_2);

        //1/1 x_0 + 0/1 x_1 + -1/16 x_2 = 9/16
        //0/1 x_0 + 1/1 x_1 + 35/36 x_2 = 5/4
        //0/1 x_0 + 0/1 x_1 + 5/288 x_2 = -7/96
        //->
        //1/1 x_0 + 0/1 x_1 + 0/1 x_2 = 3/10
        //0/1 x_0 + 1/1 x_1 + 0/1 x_2 = 16/3
        //0/1 x_0 + 0/1 x_1 + 1/1 x_2 = -21/5

        ArrayList<LinearEquation> eqs3 = getTest3DEqs_5();
        ArrayList<LinearEquation> actual_eq3 = LinearEquation.sortAndToUnitAndSwept(eqs3);
        ArrayList<LinearEquation> expected_eq3 = getTest3DEqs_6();
        assertEquals(expected_eq3, actual_eq3);

        int actual_num1_3 = LinearEquation.getSweptedNum(actual_eq3);
        int expected_num1_3 = 3;
        assertEquals(expected_num1_3, actual_num1_3);
    }

    @Test
    void cut() {
        // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
        // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
        // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
        // ->
        // 6/5 x_1 + 7/6 x_2 = 3/2,
        // 9/8 x_1 + 10/9 x_2 = 4/3
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        ArrayList<LinearEquation> actual = LinearEquation.cut(0,1,eqs);
        ArrayList<LinearEquation> expected = getTest2DEqs();
        assertEquals(expected, actual);

        // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
        // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
        // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
        // ->
        //10/9 x_2 = 4/3
        ArrayList<LinearEquation> eqs2 = getTest3DEqs_1();
        ArrayList<LinearEquation> actual2 = LinearEquation.cut(0,2,eqs2);
        Ratio ratio = new Ratio(9, 10);
        ArrayList<Ratio> ratios = new ArrayList<>(List.of(ratio));
        Ratio c = new Ratio(3,4);
        LinearEquation eq = new LinearEquation(ratios, c);
        ArrayList<LinearEquation> expected2 = new ArrayList<>(List.of(eq));
        assertEquals(expected2, actual2);
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

        // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
        // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
        // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3
        //->
        // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
        // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
        // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21]
        ArrayList<LinearEquation> eqs = getTest3DEqs_1();
        LinearEquation eq = eqs.get(0);
        ArrayList<LinearEquation> actual = eq.sweptFor(eqs);
        ArrayList<LinearEquation> expected = getTest3DEqs_3();
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