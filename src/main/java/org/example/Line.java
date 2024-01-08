package org.example;

import java.util.HashSet;

public class Line {
    protected Dot d1;
    protected Dot d2;
    Line(Dot d1, Dot d2) {
        if(d1.equals(d2)) {
            throw new IdenticalPointsException();
        }
        this.d1 = d1;
        this.d2 = d2;
    }

//    ax1+by1+c=0
//    ax2+by2+c=0
//    ax1x2+by1x2+cx2=0
//    ax1x2+bx1y2+cx1=0

//    b(y1x2-x1y2)+c(x2-x1)=0
//    b=c(x2-x1)/(x1y2-y1x2)
//    a=-by1-c=(-c(y1(x1-x2)/(y1x2-x1y2)+1))/x1
//    a=c(y1-y2)/(x1y2-y1x2)
//    c=(y1x2-x1y2)として
    //a= -y1+y2, b=x1-x2, c=y1x2-x1y2

    //テストは(1,1)(2,2)では、1,-1,0
    //テストは(1,1)(2,3)では、2,-1,-1
    //テストは(1,1)(2,1)では、0,1,-1
    //テストは(1,1)(1,2)では、1,0,-1


    //一旦整数値のみ受け付ける。型の変換をroundingOff()でとりあえずの対処
    public Linear2DPolynomial getLinear2DPolynomial() {
        if(d1.y.roundingOff() == d2.y.roundingOff()) {
            return new Linear2DPolynomial(0, 1, -d1.y.roundingOff());
        }
        if(d1.x.roundingOff() == d2.x.roundingOff()) {
            return new Linear2DPolynomial(1,0, -d1.x.roundingOff());
        }
        int xCoff = d1.y.roundingOff() - d2.y.roundingOff();
        int yCoff = d2.x.roundingOff() - d1.x.roundingOff();
        int c = d1.x.roundingOff() * d2.y.roundingOff() - d2.x.roundingOff() * d1.y.roundingOff();
        int gcd = ArrayListMethodInt.getGCDNumbers(xCoff, yCoff, c);
        if(xCoff / gcd < 0) {
            return new Linear2DPolynomial(-1 * xCoff / gcd, -1 * yCoff / gcd, -1 * c / gcd);
        } else {
            return new Linear2DPolynomial(xCoff / gcd, yCoff / gcd, c / gcd);
        }
    }

    @Override
    public boolean equals(Object object) {
        if(getClass() != object.getClass()) {
            return false;
        }
        Line line = (Line) object;
        if(d1.equals(line.d1) && d2.equals(line.d2)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return this.d1.toString() + "," + this.d2.toString();
    }
}