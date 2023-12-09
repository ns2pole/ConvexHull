    package org.example;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.util.Objects;

    public class Dot {
        protected int x;
        protected int y;

        Dot(int x, int y) {
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
            Dot dot = (Dot) o;
            return x == dot.x && y == dot.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }