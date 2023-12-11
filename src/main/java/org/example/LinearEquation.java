package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class LinearEquation {
    private ArrayList<Ratio> cofficients;
    private Ratio c;

    LinearEquation(ArrayList<Ratio> cofficients, Ratio c) {
        this.cofficients = cofficients;
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
    static ArrayList<Ratio> getSolution(ArrayList<LinearEquation> eqs) {
        //TODO copyの仕方
        ArrayList<LinearEquation> sweptingEqs = eqs;
        for(int i = 0; i < eqs.size(); i++) {
            int sweptedNum = getSweptedNum(sweptingEqs);
            if(sweptedNum == eqs.size()) {
                break;
            }
            sweptingEqs = sortAndToUnitAndSwept(sweptingEqs);
        }
        return getAllConst(sweptingEqs);
    }

    LinearEquation timesBy(Ratio r) {
        ArrayList<Ratio> newcofficients = new ArrayList<>();
        for (Ratio coeff : this.cofficients) {
            newcofficients.add(coeff.getProductRatio(r));
        }
        return new LinearEquation(newcofficients, this.c.getProductRatio(r));
    }

    LinearEquation minus(LinearEquation other) {
        ArrayList<Ratio> newcofficients = new ArrayList<>();
        for (int i = 0; i < this.cofficients.size(); i++) {
            newcofficients.add(this.cofficients.get(i).minus(other.cofficients.get(i)));
        }
        return new LinearEquation(newcofficients, this.c.minus(other.c));
    }

    //全てをnonZeroFirstIndexでsort
    //targetRow,targetColumnを取得
    //sweptByでtargetRowの方程式でtargetColumnについて掃き出しを行う



    private LinearEquation toUnitForFirstNonZeroIndex() {
        Ratio r = this.cofficients.get(this.getFirstNonZeroIndex());
        Ratio inverse = r.getInverse();
        return this.timesBy(inverse);
    }

    // 2/1 x_0 + 3/2 x_1 + 4/3 x_2 = 3/1,
    // 5/4 x_0 + 6/5 x_1 + 7/6 x_2 = 3/2,
    // 8/7 x_0 + 9/8 x_1 + 10/9 x_2 = 4/3 ->

    // [1/1 x_0 + 3/4 x_1 + 2/3 x_2 = 3/2,
    // 0/1 x_0 + 21/80 x_1 + 1/3 x_2 = -3/8,
    // 0/1 x_0 + 15/56 x_1 + 22/63 x_2 = -8/21]

    public static ArrayList<LinearEquation> sortAndToUnitAndSwept(ArrayList<LinearEquation> eqs) {
        ArrayList<LinearEquation> sortedEqs = getSorted(eqs);
        ArrayList<LinearEquation> unitedEqs = toUnitForTargetRow(sortedEqs);
        return getTargetRowEq(unitedEqs).sweptFor(unitedEqs);
    }

    public static LinearEquation getTargetRowEq(ArrayList<LinearEquation> eqs) {
        return eqs.get(getTargetRowNum(eqs));

    }

    public static ArrayList<LinearEquation> toUnitForTargetRow(ArrayList<LinearEquation> eqs) {
        LinearEquation targetRow = eqs.get(getTargetColumnNum(eqs));
        ArrayList<LinearEquation> newEqs = new ArrayList<>();
        for(LinearEquation eq : eqs) {
            if(targetRow.equals(eq)) {
                newEqs.add(eq.toUnitForFirstNonZeroIndex());
            } else {
                newEqs.add(eq);
            }
        }
        return newEqs;
    }

    static ArrayList<Ratio> getAllCoffsOf(int columnNum, ArrayList<LinearEquation> eqs) {
        ArrayList<Ratio> coffs = new ArrayList<>();
        for (LinearEquation eq : eqs) {
            coffs.add(eq.cofficients.get(columnNum));
        }
        return coffs;
    }

    static ArrayList<Ratio> getZeroRatiosExclude(int index, int dimension) {
        ArrayList<Ratio> ratios = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {  // ここでリストのサイズを設定します
            if (i == index) {
                ratios.add(new Ratio(1, 1)); // 指定されたインデックスに1を設定
            } else {
                ratios.add(new Ratio(1, 0)); // それ以外は0
            }
        }
        return ratios;
    }

    static ArrayList<LinearEquation> cutRow(int from, int to, ArrayList<LinearEquation> eqs) {
        ArrayList<LinearEquation> result = new ArrayList<>(eqs); // 元のリストのコピー

        if (from < 0 || to >= result.size() || from > to) {
            throw new IllegalArgumentException("指定範囲が誤っています。");
        }

        for (int i = to - 1; i >= from; i--) {
            System.out.println(result);
            System.out.println("from");
            System.out.println(from);
            System.out.println("to");
            System.out.println(to);
            System.out.println(result);
            result.remove(i); // 指定範囲の行（方程式）を削除
        }

        return result;
    }

    static ArrayList<LinearEquation> cutColumn(int from, int to, ArrayList<LinearEquation> eqs) {
        if (eqs.isEmpty() || from < 0 || to < from) {
            throw new IllegalArgumentException("指定範囲が誤っています。");
        }
        ArrayList<LinearEquation> result = new ArrayList<>();
        for (LinearEquation eq : eqs) {
            ArrayList<Ratio> cofficients = new ArrayList<>(eq.cofficients);
            Ratio c = new Ratio(eq.c.getDenominator(), eq.c.getNumerator());
            if (to >= cofficients.size()) {
                throw new IllegalArgumentException("指定範囲が誤っています。");
            }
            for (int i = to - 1; i >= from; i--) {
                cofficients.remove(i); // 指定範囲の列（係数）を削除
            }
            LinearEquation newEq = new LinearEquation(cofficients, c);
            result.add(newEq);
        }
        return result;
    }

    static int getTargetRowNum(ArrayList<LinearEquation> eqs) {
        for (int i = 0; i < eqs.size(); i++) {
            ArrayList<Ratio> ratios = getAllCoffsOf(i, eqs);
            if(!ratios.equals(getZeroRatiosExclude(i, eqs.size()))) {
                return i;
            }
        }
        throw new IllegalArgumentException("掃き出しが終了しています。");
    }

    static int getSweptedNum(ArrayList<LinearEquation> eqs) {
        int sweptedNum = 0;
        for (int i = 0; i < eqs.size(); i++) {
            ArrayList<Ratio> ratios = getAllCoffsOf(i, eqs);
            if(ratios.equals(getZeroRatiosExclude(i, eqs.size()))) {
                sweptedNum++;
            }
        }
        return sweptedNum;
    }

    static ArrayList<LinearEquation> cut(int from ,int to, ArrayList<LinearEquation> eqs) {
        ArrayList<LinearEquation> eqs1 = cutRow(from, to, eqs);
        ArrayList<LinearEquation> result = cutColumn(from, to, eqs1);
        return result;
    }

    static int getTargetColumnNum(ArrayList<LinearEquation> eqs) {
        int sweptedNum = getSweptedNum(eqs);
        ArrayList<LinearEquation> newEqs = cut(0, sweptedNum, eqs);
        return sweptedNum + newEqs.get(0).getFirstNonZeroIndex();
    }

    int getFirstNonZeroIndex() {
        for (int i = 0; i < this.cofficients.size(); i++) {
            if (!this.cofficients.get(i).isZero()) {
                return i;
            }
        }
        throw new IllegalArgumentException("全ての係数が0です。");
    }

    public static ArrayList<LinearEquation> getSorted(ArrayList<LinearEquation> equations) {
        Collections.sort(equations, (eq1, eq2) -> {
            int index1 = eq1.getFirstNonZeroIndex();
            int index2 = eq2.getFirstNonZeroIndex();
            return Integer.compare(index1, index2);
        });
        return equations;
    }

    public LinearEquation sweptFor(LinearEquation eq) {
        int index = this.getFirstNonZeroIndex();
        Ratio r1 = this.cofficients.get(index);
        Ratio r2 = eq.cofficients.get(index);
        return eq.minus(this.timesBy(r2.divide(r1)));
    }

    public ArrayList<LinearEquation> sweptFor(ArrayList<LinearEquation> equations) {
        ArrayList<LinearEquation> sweptedEqs = new ArrayList<>();
        for (LinearEquation eq : equations) {
            if(!eq.equals(this)) {
                LinearEquation tmp = this.sweptFor(eq);
                sweptedEqs.add(tmp);
            } else {
                sweptedEqs.add(this);
            }
        }
        return sweptedEqs;
    }

    public static ArrayList<Ratio> getAllConst(ArrayList<LinearEquation> eqs) {
        ArrayList<Ratio> allConsts = new ArrayList<>();
        for(LinearEquation eq : eqs) {
            allConsts.add(eq.c);
        }
        return allConsts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinearEquation)) return false;
        LinearEquation other = (LinearEquation) o;
        return Objects.equals(cofficients, other.cofficients) &&
                Objects.equals(c, other.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cofficients, c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cofficients.size(); i++) {
            sb.append(cofficients.get(i).toString()).append(" x_").append(i).append(" + ");
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append(" = ").append(c.toString());
        return sb.toString();
    }
}

