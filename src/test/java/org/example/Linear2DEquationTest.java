package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Linear2DEquationTest {

    @Test
    void getSolution() {
        // 3a+4b=2,
        // 5a+2b=1
        // a=0,b=1/2
        Linear2DEquation le2D1_1 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(1,4),
                new Ratio(1,2));
        Linear2DEquation le2D2_1 = new Linear2DEquation(
                new Ratio(1,5),
                new Ratio(1,2),
                new Ratio(1,1));
        Solution expected1 = new Solution(new Ratio(1, 0), new Ratio(2,1), "唯一の解が見つかりました");
        Solution actual1 = Linear2DEquation.getSolution(le2D1_1,le2D2_1);
        assertEquals(expected1, actual1);

        // a+4b=5/3,
        // 3a+2b=1
        // a=1/15,b=2/5
        Linear2DEquation le2D1_2 = new Linear2DEquation(
                new Ratio(1,1),
                new Ratio(1,4),
                new Ratio(3,5));
        Linear2DEquation le2D2_2 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(1,2),
                new Ratio(1,1));
        Solution expected2 = new Solution(new Ratio(15, 1), new Ratio(5,2), "唯一の解が見つかりました");
        Solution actual2 = Linear2DEquation.getSolution(le2D1_2,le2D2_2);
        assertEquals(expected2, actual2);

        // 1a/3+b/2=1,
        // 2a/5+2b/3=4
        // a=-60,b=42
        Linear2DEquation le2D1_3 = new Linear2DEquation(
                new Ratio(3,1),
                new Ratio(2,1),
                new Ratio(1,1));
        Linear2DEquation le2D2_3 = new Linear2DEquation(
                new Ratio(5,2),
                new Ratio(3,2),
                new Ratio(1,4));
        Solution expected3 = new Solution(new Ratio(1, -60), new Ratio(1,42), "唯一の解が見つかりました");
        Solution actual3 = Linear2DEquation.getSolution(le2D1_3,le2D2_3);
        assertEquals(expected3, actual3);


        // 3a/2+b/2=1
        // 2b/3 =4
        // a=-4/3,b=6
        Linear2DEquation le2D1_4 = new Linear2DEquation(
                new Ratio(2,3),
                new Ratio(2,1),
                new Ratio(1,1));
        Linear2DEquation le2D2_4 = new Linear2DEquation(
                new Ratio(1,0),
                new Ratio(3,2),
                new Ratio(1,4));
        Solution expected4 = new Solution(new Ratio(3, -4), new Ratio(1,6), "唯一の解が見つかりました");
        Solution actual4 = Linear2DEquation.getSolution(le2D1_4, le2D2_4);
        assertEquals(expected4, actual4);

        // b/2=1,
        // 3a+2b/3 =4
        // a=8/9,b=2
        Linear2DEquation le2D1_5 = new Linear2DEquation(
                new Ratio(1,0),
                new Ratio(2,1),
                new Ratio(1,1));
        Linear2DEquation le2D2_5 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(3,2),
                new Ratio(1,4));
        Solution expected5 = new Solution(new Ratio(9, 8), new Ratio(1,2), "唯一の解が見つかりました");
        Solution actual5 = Linear2DEquation.getSolution(le2D1_5, le2D2_5);
        assertEquals(expected5, actual5);


        // 3a=4
        // b/2=1
        // a=4/3,b=2
        Linear2DEquation le2D2_6 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(1,0),
                new Ratio(1,4));
        Linear2DEquation le2D1_6 = new Linear2DEquation(
                new Ratio(1,0),
                new Ratio(2,1),
                new Ratio(1,1));
        Solution expected6 = new Solution(new Ratio(3, 4), new Ratio(1,2), "唯一の解が見つかりました");
        Solution actual6 = Linear2DEquation.getSolution(le2D1_6,le2D2_6);
        assertEquals(expected6, actual6);

        // b/2=1
        // 3a=4
        // a=4/3,b=2
        Linear2DEquation le2D1_7 = new Linear2DEquation(
                new Ratio(1,0),
                new Ratio(2,1),
                new Ratio(1,1));
        Linear2DEquation le2D2_7 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(1,0),
                new Ratio(1,4));
        Solution expected7 = new Solution(new Ratio(3, 4), new Ratio(1,2), "唯一の解が見つかりました");
        Solution actual7 = Linear2DEquation.getSolution(le2D1_7, le2D2_7);
        assertEquals(expected7, actual7);



        // 1a/3+b/2=1,
        // 2a/3+b=4
        // 解なし
        Linear2DEquation le2D1_8 = new Linear2DEquation(
                new Ratio(3,1),
                new Ratio(2,1),
                new Ratio(1,1));
        Linear2DEquation le2D2_8 = new Linear2DEquation(
                new Ratio(3,2),
                new Ratio(1,1),
                new Ratio(1,4));
        Solution expected8 = new Solution(null, null, "解はありません");
        Solution actual8 = Linear2DEquation.getSolution(le2D1_8, le2D2_8);
        assertEquals(expected8, actual8);

        // 1a/3+b/2=1,
        // 2a/3+b=2
        // 方程式が被っており解は無数にある。
        Linear2DEquation le2D1_9 = new Linear2DEquation(
                new Ratio(3,1),
                new Ratio(2,1),
                new Ratio(1,1));
        Linear2DEquation le2D2_9 = new Linear2DEquation(
                new Ratio(3,2),
                new Ratio(1,1),
                new Ratio(1,2));
        Solution expected9 = new Solution(null, null, "解は" + le2D1_9.toString() + "上の全ての点です");
        Solution actual9 = Linear2DEquation.getSolution(le2D1_9, le2D2_9);
        assertEquals(expected9, actual9);

    }

    @Test
    void existInverse() {
        Linear2DEquation le2D1_1 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(1,4),
                new Ratio(1,2));
        Linear2DEquation le2D2_1 = new Linear2DEquation(
                new Ratio(1,6),
                new Ratio(1,8),
                new Ratio(1,1));
        Pair<Linear2DEquation> pair1 = new Pair<>(le2D1_1,le2D2_1);
        assertFalse(Linear2DEquation.existInverse(pair1));
        Linear2DEquation le2D1_2 = new Linear2DEquation(
                new Ratio(1,3),
                new Ratio(1,3),
                new Ratio(1,2));
        Linear2DEquation le2D2_2 = new Linear2DEquation(
                new Ratio(1,6),
                new Ratio(1,8),
                new Ratio(1,1));
        Pair<Linear2DEquation> pair2 = new Pair<>(le2D1_2,le2D2_2);
        assertTrue(Linear2DEquation.existInverse(pair2));

    }


    @Test
    void timesBy() {
    }

    @Test
    void substructBy() {
    }

    @Test
    void getFirstNonZeroCoff() {
    }

    @Test
    void toUnitForNonZeroFirstCoff() {
    }

    @Test
    void testToUnitForNonZeroFirstCoff() {
    }

    @Test
    void getSweptedEqs() {
    }
}