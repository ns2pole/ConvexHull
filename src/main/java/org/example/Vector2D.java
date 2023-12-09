    package org.example;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.Objects;

    public class Vector2D {
        protected int x;
        protected int y;

        Vector2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Vector2D get2DVector(Dot from, Dot to) {
            return new Vector2D(to.x - from.x, to.y - from.y);
        }

        //vector (1,1)->vector (1,-1)
        Vector2D getNormalVector() {
            if(this.isZero()) {
                throw new NormalVectorException();
            }
            return new Vector2D(this.y, -this.x);
        }

        boolean isZero() {
            return this.x == 0 && this.y == 0;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vector2D dot = (Vector2D) o;
            return x == dot.x && y == dot.y;
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
    }