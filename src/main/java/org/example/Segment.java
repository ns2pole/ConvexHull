package org.example;

import java.awt.*;
import java.util.HashSet;

public class Segment {
    private Dot d1;
    private Dot d2;

    Segment(Dot d1, Dot d2) {
        if(d1.equals(d2)) {
            throw new IdenticalPointsException();
        }
        this.d1 = d1;
        this.d2 = d2;
    }

    //dotsが線分の片側(つまり右側ばかりまたは左側ばかりにのみ存在する時に、凸包の線分となる。)
    boolean isConvexHullSideOf(HashSet<Dot> dots) {
        DirectedLineSegment dls = new DirectedLineSegment(d1, d2);
        HashSet<Dot> onLineDots = new HashSet<>();
        HashSet<Dot> onLeftDots = new HashSet<>();
        HashSet<Dot> onRightDots = new HashSet<>();
        for(Dot d : dots){
            if(d.existOnLine(dls)) {
                onLineDots.add(d);
            } else if(d.existOnLeftFor(dls)) {
                onLeftDots.add(d);
            } else if(d.existOnRightFor(dls)) {
                onRightDots.add(d);
            }
        }
        /*どっちかが空なら片方のみに点が散らばっている*/
        if(onLeftDots.size() == 0 || onRightDots.size() == 0) {
            return true;
        }/*「どちらも空ではない」はすなわち直線の両側に点が散らばっている*/ else {
            return false;
        }
    }

    protected void draw(Graphics g) {
        System.out.println(this.d1.x.roundingOff());
        System.out.println(this.d1.y.roundingOff());
        System.out.println(this.d2.x.roundingOff());
        System.out.println(this.d2.y.roundingOff());
        g.drawLine(this.d1.x.roundingOff(), this.d1.y.roundingOff(), this.d2.x.roundingOff(), this.d2.y.roundingOff());
    }

    @Override
    public boolean equals(Object object) {
        if(getClass() != object.getClass()) {
            return false;
        }
        Segment line = (Segment) object;
        if(d1.equals(line.d1) && d2.equals(line.d2)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return this.d1.toString() + "--" + this.d2.toString();
    }
}