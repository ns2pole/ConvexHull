package org.example;

import static org.example.ArrayListMethodInteger.*;

import java.util.ArrayList;


public class Ratio {
	private int denominator;
	private int numerator;
	Ratio(int den,int nume){
		if(den < 0 && nume < 0) {
			this.denominator = -1 * den;
			this.numerator = -1 * nume;
		} else {
			this.denominator = den;
			this.numerator = nume;
		}
	}
	
	protected int getDenominator() {
		return this.denominator;
	}
	protected int getNumerator() {
		return this.numerator;
	}
	
	protected void displayDenominator() {
		System.out.println(this.denominator);
	}
	
	protected static int getFieldNum() {
		return 2;
	}
	
	protected Ratio add(Ratio ratio) {
		int resultDenominator = this.denominator + ratio.denominator;
		int resultNumerator = this.numerator + ratio.numerator;
		return new Ratio(resultDenominator, resultNumerator);
	}
	/**約分*/
	protected Ratio getIrreducibleRatio() {
		int GCD = ArrayListMethodInt.getGCDOf(denominator, numerator);
		int newDenominator = this.denominator / GCD;
		int newNumerator = this.numerator / GCD;
		return new Ratio(newDenominator,newNumerator);
	}
	/**掛け算*/
	protected Ratio getProductRatio(Ratio ratio) {
		int multipliedDenominator = this.denominator * ratio.denominator;
		int multipliedNumerator = this.numerator * ratio.numerator;
		Ratio multipliedRatio = new Ratio(multipliedDenominator,multipliedNumerator);
		return multipliedRatio.getIrreducibleRatio();
	}
	/**足し算*/
	protected Ratio getAddedRatio(Ratio ratio) {
		int addedDenominator = this.denominator * ratio.denominator;
		int firstNumerator = this.numerator * ratio.denominator;
		int secondNumerator = this.denominator * ratio.numerator;
		int addedNumerator = firstNumerator + secondNumerator;
		Ratio addedRatio = new Ratio(addedDenominator,addedNumerator);
		return addedRatio.getIrreducibleRatio();
	}
	/**既約であるならばtrueを返す:(12,9) false*/
	protected boolean isIrreducible(){
		int GCD = ArrayListMethodInt.getGCDOf(denominator, numerator);
		if(GCD == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	public boolean equals(Ratio ratio) {
		if(this.denominator == ratio.denominator && this.numerator == ratio.numerator) {
			return true;
		}else {
			return false;
		}
	}
	/**割り算*/
	protected Ratio divide (Ratio ratio) {
		int dividedDenominator = this.denominator * ratio.numerator;
		int dividedNumerator = this.numerator * ratio.denominator;
		Ratio dividedRatio = new Ratio(dividedDenominator,dividedNumerator);
		return dividedRatio.getIrreducibleRatio();
	}
	
	/**引き算*/
	protected Ratio minus (Ratio ratio) {
		int minusedDenominator = this.denominator * ratio.denominator;
		int firstNumerator = this.numerator * ratio.denominator;
		int secondNumerator = this.denominator * ratio.numerator;
		int minusedNumerator = firstNumerator - secondNumerator;
		Ratio minusedRatio = new Ratio(minusedDenominator,minusedNumerator);
		return minusedRatio.getIrreducibleRatio();
	}
	
	/**帯分数へ変換*/
	protected MixedFraction toMixedFraction() {
		int resultNumerator = this.numerator % this.denominator;
		int resultFraction = this.numerator / this.denominator;
		return new MixedFraction(resultFraction,this.denominator,resultNumerator);
	}
	//分母分子に√ -> 有理化
	protected IntRootRatio toRoot() {
		IntRootRatio rootRatio = new IntRootRatio(toIntRoot(this.denominator),toIntRoot(this.numerator));
		IntRootRatio resultRatio = rationalizeOf(rootRatio);
		return resultRatio;
	}
	
	protected double toDesimal() {
		return (Double) null;
	}
	//toDesimal:小数点以下まで平方根を出す 54321 -> 233...
	
	//二桁を一桁で割った商
	//num1 = 割る数
	protected int getQuotient(int num1) {
		
		return 0;
	}
	
	//3,7 ->30 / 7 -> 4
	protected  static int timeAndDivideAnswer(int num1, int num2) {
		int result = num1 * 10 / num2;
		return result;
	}
	
	//3,7 ->30 / 7 -> 2
	protected int timeAndDivideRemainder(int num1, int num2) {
		int result = num1 * 10 % num2;
		return result;
	}
	
//	3,7 -> false 4,5 ->true
	protected boolean hasOnlyTwoOrFive(int num1) {
		ArrayList<Integer> primeFactors = ArrayListMethodInteger.getPrimeFactorsOf(num1);
		for(int i = 0;i < primeFactors.size();i++) {
			if(primeFactors.get(i) != 2 && primeFactors.get(i) != 5) {
				return false;
			}
		}
		return true;
	}
	
	
	//わる→商と余りをほぞんする→余りを割る
	protected Decimal getDecimal(int digitNum) {
		int numerator = this.numerator;
		int denominator = this.denominator;
		int remainder = numerator % denominator;
		ArrayList<Integer> decimals = new ArrayList<Integer>();
		int integerVal = numerator / denominator;
		
		Integer decimalVal = null;
		for(int i = 0;i < digitNum;i++) {
			decimals.add(timeAndDivideAnswer(remainder, denominator));
			remainder = timeAndDivideRemainder(remainder, denominator);
		}
		decimalVal = decimals.get(0);
		String decimalValString = Integer.toString(decimalVal);
		for(int i= 1; i < decimals.size();i++) {
			decimalValString = decimalValString + Integer.toString(decimals.get(i));
		}
		String integerValString = Integer.toString(integerVal);
		Decimal result = new Decimal(integerValString, decimalValString);
		return result;
	}
	
	protected String getRecurringDecimal() {
		int remainder = this.numerator % this.denominator;
		int firstRemainder = this.numerator % this.denominator;
		ArrayList<Integer> decimals = new ArrayList<Integer>();
		
		decimals.add(timeAndDivideAnswer(remainder, this.denominator));
		remainder = timeAndDivideRemainder(remainder, this.denominator);
		
		//分母が2と5の時のみ割り切れるので空を返す
		if(hasOnlyTwoOrFive(denominator) == true) {
			return "";
		}else {
			while(remainder != firstRemainder) {
			decimals.add(timeAndDivideAnswer(remainder, denominator));
			remainder = timeAndDivideRemainder(remainder, denominator);
		}
		Integer resultInteger = null;
		resultInteger = decimals.get(0);
		String result = Integer.toString(resultInteger);
		for(int i= 1; i < decimals.size();i++) {
			result = result + decimals.get(i);
		}
		return result;
		}
	}

	boolean isZero() {
		if(this.numerator == 0) {
			return true;
		} else {
			return false;
		}
	}

	public Ratio getInverse() {
		return new Ratio(this.numerator, this.denominator);
	}

	@Override
	public boolean equals (Object obj) {
		Ratio r = (Ratio)obj;
		if(this.denominator == r.denominator &&
				this.numerator == r.numerator
		) {
			return true;
		} else {
			return false;
		}
	}
}
