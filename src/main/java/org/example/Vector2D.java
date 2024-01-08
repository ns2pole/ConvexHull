    package org.example;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.Objects;

    public class Vector2D {
        protected Ratio x;
        protected Ratio y;

        Vector2D(Ratio x, Ratio y) {
            this.x = x;
            this.y = y;
        }

        static Vector2D get2DVector(Dot from, Dot to) {
            return new Vector2D(to.x.minus(from.x) , to.y.minus(from.y));
        }

        //vector (1,1)->vector (1,-1)
        Vector2D getNormalVector() {
            if(this.isZero()) {
                throw new NormalVectorException();
            }
            return new Vector2D(this.y, this.x.times(new Ratio(-1,1)));
        }

        boolean isZero() {
            return this.x.isZero() && this.y.isZero();
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
            return x.equals(dot.x) && y.equals(dot.y);
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
    }