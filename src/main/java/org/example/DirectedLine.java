package org.example;

public class DirectedLine {
    private Dot from;
    private Vector2D direction;

    DirectedLine(Dot d1, Dot d2) {
        if(d1.equals(d2)) {
            throw new IdenticalPointsException();
        }
        this.from = from;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.from.toString() + ":->" + this.direction.toString();
    }
}