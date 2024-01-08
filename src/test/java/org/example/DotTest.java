package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DotTest {

    @Test
    void existOnRightFor() {

    }

    @Test
    void existOnLeftFor() {
    }

    @Test
    void existOnLine() {
        Dot origin1 = new Dot(new Ratio(1),new Ratio(1));
        Dot to = new Dot(new Ratio(2),new Ratio(4));
        DirectedLineSegment dlsg = new DirectedLineSegment(origin1, to);
        Dot target1 = new Dot(new Ratio(5),new Ratio(3));
        Dot target2 = new Dot(new Ratio(-1),new Ratio(5));
        Dot target3 = new Dot(new Ratio(3),new Ratio(7));
        Dot target4 = new Dot(new Ratio(0),new Ratio(-2));
        assertFalse(target1.existOnLine(dlsg));
        assertFalse(target2.existOnLine(dlsg));
        assertTrue(target3.existOnLine(dlsg));
        assertTrue(target4.existOnLine(dlsg));
    }

    @Test
    void existOnLeft() {
        Dot origin1 = new Dot(new Ratio(1),new Ratio(1));
        Dot to = new Dot(new Ratio(2),new Ratio(4));
        DirectedLineSegment dlsg = new DirectedLineSegment(origin1, to);
        Dot target1 = new Dot(new Ratio(5),new Ratio(3));
        Dot target2 = new Dot(new Ratio(-1),new Ratio(5));
        Dot target3 = new Dot(new Ratio(3),new Ratio(7));
        Dot target4 = new Dot(new Ratio(0),new Ratio(-2));
        assertTrue(target1.existOnLeftFor(dlsg));
        assertFalse(target2.existOnLeftFor(dlsg));
        assertFalse(target3.existOnLeftFor(dlsg));
        assertFalse(target4.existOnLeftFor(dlsg));
    }

    @Test
    void existOnRight() {
        Dot origin1 = new Dot(new Ratio(1),new Ratio(1));
        Dot to = new Dot(new Ratio(2),new Ratio(4));
        DirectedLineSegment dlsg = new DirectedLineSegment(origin1, to);
        Dot target1 = new Dot(new Ratio(5),new Ratio(3));
        Dot target2 = new Dot(new Ratio(-1),new Ratio(5));
        Dot target3 = new Dot(new Ratio(3),new Ratio(7));
        Dot target4 = new Dot(new Ratio(0),new Ratio(-2));
        assertFalse(target1.existOnRightFor(dlsg));
        assertTrue(target2.existOnRightFor(dlsg));
        assertFalse(target3.existOnRightFor(dlsg));
        assertFalse(target4.existOnRightFor(dlsg));
    }
}