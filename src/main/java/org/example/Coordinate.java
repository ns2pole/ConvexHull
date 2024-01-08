    package org.example;

    import java.util.Objects;

    public class Coordinate {
        protected Ratio x;
        protected Ratio y;

        Coordinate(Ratio x, Ratio y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate dot = (Coordinate) o;
            return x.equals(dot.x) && y.equals(dot.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }