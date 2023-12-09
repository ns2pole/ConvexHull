package org.example;

public class Line {
    private Dot d1;
    private Dot d2;

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

    //テストは(1,1)(2,2)では、1,-1,0
    //テストは(1,1)(2,3)では、2,-1,-1
    //テストは(1,1)(2,1)では、0,1,-1
    //テストは(1,1)(1,2)では、1,0,-1


    public Linear2DPolynomial getLinear2DPolynomial() {
        if(d1.y == d2.y) {
            return new Linear2DPolynomial(0, 1, -d1.y);
        }
        if(d1.x == d2.x) {
            return new Linear2DPolynomial(1,0, -d1.x);
        }
        int xCoff = d1.y - d2.y;
        int yCoff = d2.x - d1.x;
        int c = d1.x * d2.y - d2.x * d1.y;
        int gcd = ArrayListMethodInt.getGCDNumbers(xCoff, yCoff, c);
        if(xCoff / gcd < 0) {
            return new Linear2DPolynomial(-1 * xCoff / gcd, -1 * yCoff / gcd, -1 * c / gcd);
        } else {
            return new Linear2DPolynomial(xCoff / gcd, yCoff / gcd, c / gcd);
        }
    }

    @Override
    public String toString() {
        return this.d1.toString() + "," + this.d2.toString();
    }
}