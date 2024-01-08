package org.example;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {

    @Test
    public void test_get2DVector() {
        Vector2D expected1 = new Vector2D(new Ratio(4), new Ratio(3));
        Dot d1_from = new Dot(new Ratio(1), new Ratio(7));
        Dot d1_to = new Dot(new Ratio(5), new Ratio(10));
        Vector2D actual1 = Vector2D.get2DVector(d1_from, d1_to);
        assertEquals(expected1, actual1);

        Vector2D expected2 = new Vector2D(new Ratio(-1), new Ratio(2));
        Dot d2_from = new Dot(new Ratio(-1), new Ratio(7));
        Dot d2_to = new Dot(new Ratio(-2), new Ratio(9));
        Vector2D actual2 = Vector2D.get2DVector(d2_from, d2_to);
        assertEquals(expected2, actual2);

        Vector2D expected3 = new Vector2D(new Ratio(0), new Ratio(0));
        Dot d3_from = new Dot(new Ratio(1), new Ratio(7));
        Dot d3_to = new Dot(new Ratio(1), new Ratio(7));
        Vector2D actual3 = Vector2D.get2DVector(d3_from, d3_to);
        assertEquals(expected3, actual3);
    }

    @Test
    public void test_getNormalVector() {
        Vector2D expected1 = new Vector2D(new Ratio(4), new Ratio( 3));
        Vector2D vec1 = new Vector2D(new Ratio(-3), new Ratio(4));
        Vector2D actual1 = vec1.getNormalVector();
        assertEquals(expected1, actual1);

        Vector2D expected2 = new Vector2D(new Ratio(0), new Ratio(-3));
        Vector2D vec2 = new Vector2D(new Ratio(3), new Ratio(0));
        Vector2D actual2 = vec2.getNormalVector();
        assertEquals(expected2, actual2);

        Vector2D expected3 = new Vector2D(new Ratio(3), new Ratio(0));
        Vector2D vec3 = new Vector2D(new Ratio(0), new Ratio(3));
        Vector2D actual3 = vec3.getNormalVector();
        assertEquals(expected3, actual3);

        Vector2D vec4 = new Vector2D(new Ratio(0), new Ratio(0));
        assertThrows(NormalVectorException.class, () -> vec4.getNormalVector());
    }

    @Test
    public void test_getHashSet() {
        Vector2D tmp = new Vector2D(new Ratio(3),new Ratio(2));
        Vector2D tmp2 = new Vector2D(new Ratio(3),new Ratio(2));
        HashMap<String, Vector2D> actual1 = new HashMap<>();
        actual1.put("1つめ" ,tmp);
        HashMap<String, Vector2D> actual2 = new HashMap<>();
        actual2.put("1つめ" ,tmp2);
        assertEquals(actual1.get("1つめ"), actual2.get("1つめ"));
    }
}