package org.example;

public class DirectedLineSegment {
    protected Dot from;
    protected Dot to;

    protected Vector2D direction;

    DirectedLineSegment(Dot from, Dot to) {
        if(from.equals(to)) {
            throw new IdenticalPointsException();
        }
        this.from = from;
        this.to = to;
        this.direction = Vector2D.get2DVector(from, to);
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


    @Override
    public String toString() {
        return this.from.toString() + "->" + this.to.toString();
    }
}