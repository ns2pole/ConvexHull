package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    @Test
    void getCoordinateFor() {
        Dot origin1 = new Dot(new Ratio(1),new Ratio(1));
        Vector2D firstAxisVec1 = new Vector2D(new Ratio(1), new Ratio(3));
        Vector2D secondAxisVec1 = new Vector2D(new Ratio(3), new Ratio(-1));

        Dot target1 = new Dot(new Ratio(5),new Ratio(3));
        Coordinate actual1 = Linear2DEquation.getCoordinateFor(origin1, firstAxisVec1, secondAxisVec1, target1);
        Coordinate expected1 = new Coordinate(new Ratio(1), new Ratio(1));
        assertEquals(expected1, actual1);

        Dot target2 = new Dot(new Ratio(-1), new Ratio(5));
        Coordinate actual2 = Linear2DEquation.getCoordinateFor(origin1, firstAxisVec1, secondAxisVec1, target2);
        Coordinate expected2 = new Coordinate(new Ratio(1), new Ratio(-1));
        assertEquals(expected2, actual2);

        Dot target3 = new Dot(new Ratio(3), new Ratio(7));
        Coordinate actual3 = Linear2DEquation.getCoordinateFor(origin1, firstAxisVec1, secondAxisVec1, target3);
        Coordinate expected3 = new Coordinate(new Ratio(2), new Ratio(0));
        assertEquals(expected3, actual3);

        Dot target4 = new Dot(new Ratio(0), new Ratio(-2));
        Coordinate actual4 = Linear2DEquation.getCoordinateFor(origin1, firstAxisVec1, secondAxisVec1, target4);
        Coordinate expected4 = new Coordinate(new Ratio(-1), new Ratio(0));
        assertEquals(expected4, actual4);

    }
}