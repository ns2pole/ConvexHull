package org.example;

import java.util.Objects;

public class Solution {
    private Ratio solutionX;
    private Ratio solutionY;
    private String description;

    Solution(Ratio solutionX, Ratio solutionY, String description) {
        this.solutionX = solutionX;
        this.solutionY = solutionY;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Solution)) {
            return false;
        }
        Solution other = (Solution) o;
        if(this.solutionX == null &&
                this.solutionY == null
        ) {
            return this.description.equals(other.description);
        } else {
            return this.solutionX.equals(other.solutionX) &&
                    this.solutionY.equals(other.solutionY) &&
                    this.description.equals(other.description);
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(solutionX, solutionY, description);
    }

    @Override
    public String toString() {
        return this.description + " : " +  this.solutionX + " , " +  this.solutionY;
    }
}

