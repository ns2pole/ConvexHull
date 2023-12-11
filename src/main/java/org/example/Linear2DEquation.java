package org.example;

import java.util.Objects;
import java.util.logging.Level;

public class Linear2DEquation {
    private Ratio coff1;
    private Ratio coff2;
    private Ratio c;

    Linear2DEquation(Ratio coff1, Ratio coff2, Ratio c) {
        this.coff1 = coff1;
        this.coff2 = coff2;
        this.c = c;
    }

    //(3, 4, 2) -> (1, 4/3, 2/3) -> (1, 4/3, 2/3) -> (1, 4/3, 2/3) -> (1, 0, 0)
    //(5, 2, 1) -> (1, 2/5, 1/5) -> (0, 14/15, 7/15) -> (0, 1, 1/2) -> (0, 1, 1/2)

    //(0, 3, 2) -> (0, 1, 2/3) -> (1, 2/3, 2/3)
    //(3, 2, 2) -> (1, 2/3, 2/3) -> (0, 1, 2/3)

    //(3, 2, 2) -> (1, 2/3, 2/3) -> (0, 1, 2/3)
    //(0, 3, 2) -> (0, 1, 2/3) -> (1, 2/3, 2/3)

    //(0, 3, 2) -> (0, 1, 2/3) -> (1, 0, 1/2)
    //(4, 0, 2) -> (1, 0, 1/2) -> (0, 1, 2/3)
    static Solution getSolution(Linear2DEquation le2D_1, Linear2DEquation le2D_2) {
        //1次従属で解なし
        Pair initial = new Pair<>(le2D_1, le2D_2);
        Pair<Linear2DEquation> pair = toUnitForNonZeroFirstCoff(initial);
        Pair<Linear2DEquation> sortedPair = getSortedPair(pair);
        if(pair.getFirst().equals(pair.getSecond())) {
            //3x+2y=4,//6x+4y=8
            return new Solution(null, null, "解は" + le2D_1.toString() + "上の全ての点です");
        } else if(existInverse(pair)){
            //1次従属で解が無数にあり
            //解が1つだけ存在
            //2x+10y=4,//3x+9y=15
            //x+5y=2,//x+3y=5
            if(sortedPair.getSecond().getFirstNonZeroIndex() == 0) {
                Pair<Linear2DEquation> sweptedPair = getSweptedEqs(sortedPair);
                //x+5y=2,//-2y=3
                Pair<Linear2DEquation> pair2 = toUnitForNonZeroFirstCoff(sweptedPair);
                //x+5y=2,//y=-3/2
                Linear2DEquation tmp = pair2.getSecond().timesBy(pair2.getFirst().coff2);
                //x+5y=2,//5y=-15/2
                Linear2DEquation newLe2D_1 = pair2.getFirst().substructBy(tmp);
                //x=19/2,//5y=-15/2
                return new Solution(newLe2D_1.c, pair2.getSecond().c, "唯一の解が見つかりました");
            } else {
                //2x+5y=2,//y=3/5
                Linear2DEquation tmp = sortedPair.getSecond().timesBy(sortedPair.getFirst().coff2);
                Linear2DEquation newLe2D_1 = sortedPair.getFirst().substructBy(tmp);
                return new Solution(newLe2D_1.c, sortedPair.getSecond().c, "唯一の解が見つかりました");
            }
        } else {
            //3x+2y=4,//6x+4y=10
            return new Solution(null, null, "解はありません");
        }

    }



    Linear2DEquation timesBy(Ratio r) {
        return new Linear2DEquation(
                this.coff1.getProductRatio(r),
                this.coff2.getProductRatio(r),
                this.c.getProductRatio(r));
    }

    Linear2DEquation substructBy(Linear2DEquation li2D) {
        return new Linear2DEquation(
                this.coff1.minus(li2D.coff1),
                this.coff2.minus(li2D.coff2),
                this.c.minus(li2D.c));
    }

    int getFirstNonZeroIndex() {
        if(!coff1.isZero()) {
            return 0;
        } else if(!coff2.isZero()) {
            return 1;
        } else {
            return 2;
        }
    }

    Ratio getFirstNonZeroCoff() {
        if(!coff1.isZero()) {
            return coff1;
        }
        if(!coff2.isZero()) {
            return coff2;
        }
        else {
            throw new IllegalArgumentException("全ての係数が0になっています。");
        }
    }

    public Linear2DEquation toUnitForNonZeroFirstCoff() {
        Ratio nonZeroFirstCoff = this.getFirstNonZeroCoff();
        return this.timesBy(nonZeroFirstCoff.getInverse());
    }

    static Pair<Linear2DEquation> getSortedPair(Pair<Linear2DEquation> pair) {
        if(pair.getFirst().getFirstNonZeroIndex() > pair.getSecond().getFirstNonZeroIndex()) {
            return new Pair<>(pair.getSecond(), pair.getFirst());
        } else {
            return pair;
        }
    }

    static Pair<Linear2DEquation> toUnitForNonZeroFirstCoff(Pair<Linear2DEquation> pair) {
        Linear2DEquation first = pair.getFirst().toUnitForNonZeroFirstCoff();
        Linear2DEquation second = pair.getSecond().toUnitForNonZeroFirstCoff();
        return new Pair<>(first, second);
    }

    static Pair<Linear2DEquation> getSweptedEqs(Pair<Linear2DEquation> pair) {
        return new Pair<>(pair.getFirst(), pair.getSecond().substructBy(pair.getFirst()));
    }

    //step1.getLCMで第1係数を揃えてそのPairをリターンする
    //step2.Pair[最初の1本目, step1の2本目-1本目/第2係数]をリターンする
    //step3.Pair[最初の1本目-step2の2本目*1本目の第2係数, step2の2本目]をリターンする
    //Pair[step3の1本目のc,step3の2本目のc]をリターンする

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Linear2DEquation)) {
            return false;
        }

        Linear2DEquation other = (Linear2DEquation) o;
        return this.coff1.equals(other.coff1) &&
                this.coff2.equals(other.coff2) &&
                this.c.equals(other.c);
    }

    static boolean existInverse(Pair<Linear2DEquation> pair) {
        Ratio det =
                pair.getFirst().coff1.getProductRatio(
                        pair.getSecond().coff2).minus(
                        pair.getFirst().coff2.getProductRatio(pair.getSecond().coff1)
                );
        if (det.isZero()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(coff1, coff2, c);
    }

    @Override
    public String toString() {
        return this.coff1 + " x + " +  this.coff2 + " y = " +  this.c;
    }
}

