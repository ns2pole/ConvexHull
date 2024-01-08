    package org.example;
    import java.awt.*;
    import java.util.Random;
    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.Objects;

    public class Dot {
        protected Ratio x;
        protected Ratio y;
        private int size;

        Dot(Ratio x, Ratio y) {
            this.x = x;
            this.y = y;
            this.size = 10;
        }

        protected void draw(Graphics g) {
            g.fillRect(this.x.roundingOff() - (this.size / 2), this.y.roundingOff() - (this.size / 2), this.size,this.size);
        }

        static protected Dot getRandomly() {
            Random r = new Random();
            int randomNumerator1 = r.nextInt(40) * 10 + 100;
            Ratio randomRatio1 = new Ratio(1, randomNumerator1);
            int randomNumerator2 = r.nextInt(40) * 10 + 100;
            Ratio randomRatio2 = new Ratio(1, randomNumerator2);
            return new Dot(randomRatio1, randomRatio2);
        }



        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dot dot = (Dot) o;
            return x.equals(dot.x) && y.equals(dot.y);
        }

        protected boolean existOnRightFor(DirectedLineSegment dLSeg) {
            Coordinate coord = Linear2DEquation.getCoordinateFor(
                    dLSeg.from,
                    dLSeg.direction,
                    dLSeg.direction.getNormalVector(),
                    this);
            if(coord.y.isNegative()) {
                return true;
            } else {
                return false;
            }
        }

        protected boolean existOnLeftFor(DirectedLineSegment dLSeg) {
            Coordinate coord = Linear2DEquation.getCoordinateFor(
                    dLSeg.from,
                    dLSeg.direction,
                    dLSeg.direction.getNormalVector(),
                    this);
            if(coord.y.isPositive()) {
                return true;
            } else {
                return false;
            }
        }

        static void drawConvexHull(HashSet<Dot> dots, Graphics g) {
            // 処理前の時刻を取得

            for(Dot d : dots) {
                d.draw(g);
            }

            HashSet<Segment> segments = getAllSegmentOf(dots);

            for(Segment s : segments) {
                if(s.isConvexHullSideOf(dots)) {
                    s.draw(g);
                }
            }

        }

        static HashSet<Segment> getAllSegmentOf(HashSet<Dot> dots) {

            ArrayList<Dot> dotsList = new ArrayList<>(dots); // HashSetをArrayListに変換
            HashSet<Segment> segments = new HashSet<>();
            for (int i = 0; i < dotsList.size(); i++) {
                for (int j = i + 1; j < dotsList.size(); j++) {
                    Segment s = new Segment(dotsList.get(i), dotsList.get(j));
                    segments.add(s);
                }
            }

            return segments;
        }

        //延長線上も含む
        protected boolean existOnLine(DirectedLineSegment dLSeg) {
            Coordinate coord = Linear2DEquation.getCoordinateFor(
                    dLSeg.from,
                    dLSeg.direction,
                    dLSeg.direction.getNormalVector(),
                    this);
            if(coord.y.isZero()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }



    }