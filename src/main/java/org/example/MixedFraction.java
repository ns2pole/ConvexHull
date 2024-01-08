package org.example;

public class MixedFraction {
	private int denominator;
	private int numerator;
	private int fraction;
	MixedFraction(int frac,int den,int nume){
		this.denominator = den;
		this.numerator = nume;
		this.fraction = frac;
	}
	protected int getDenominator() {
		return this.denominator;
	}
	protected int getNumerator() {
		return this.numerator;
	}
	protected int getFraction() {
		return this.fraction;
	}
	
	@Override
	public String toString() {
		if(this.numerator == 0) {
			return this.fraction + "";
		}else if(this.fraction == 0){
			return this.numerator + "/" + this.denominator;
		}else {
			return this.fraction + "+" + this.numerator + "/" + this.denominator;
		}
	}
	/**同じかどうか判定*/
	protected boolean equals(MixedFraction frac) {
		if(this.numerator == frac.numerator && this.denominator == frac.denominator && this.fraction == frac.fraction) {
			return true;
		}else {
			return false;
		}
	}
	/**Ratioに変換*/
	protected Ratio toRatio() {
		int resultNumerator = this.fraction * this.denominator + this.numerator;
		return new Ratio(this.denominator,resultNumerator);
	}
	
	
	/**足し算*/
	protected MixedFraction add(MixedFraction frac) {
		int resultDenominator = this.denominator * frac.denominator;
		int firstNumerator = this.numerator * frac.denominator + resultDenominator * this.fraction;
		int secondNumerator = frac.numerator * this.denominator + resultDenominator * frac.fraction;
		int resultNumerator = firstNumerator + secondNumerator;
		Ratio result = new Ratio(resultDenominator,resultNumerator);
		MixedFraction changedResult = result.toMixedFraction();
		return changedResult;
	}
	
	/**引き算*/
	protected MixedFraction minus(MixedFraction frac) {
		MixedFraction firstOne = new MixedFraction(this.fraction,this.denominator,this.numerator);
		Ratio firstRatio = firstOne.toRatio();
		MixedFraction secondOne = new MixedFraction(frac.fraction,frac.denominator,frac.numerator);
		Ratio secondRatio = secondOne.toRatio();
		Ratio resultRatio = firstRatio.minus(secondRatio);
		MixedFraction result = resultRatio.toMixedFraction();
		return result;
	}
	
	/**掛け算*/
	protected MixedFraction product(MixedFraction frac) {
		MixedFraction firstOne = new MixedFraction(this.fraction,this.denominator,this.numerator);
		Ratio firstRatio = firstOne.toRatio();
		MixedFraction secondOne = new MixedFraction(frac.fraction,frac.denominator,frac.numerator);
		Ratio secondRatio = secondOne.toRatio();
		Ratio resultRatio = firstRatio.times(secondRatio);
		MixedFraction result = resultRatio.toMixedFraction();
		return result;
	}
	
	/**割り算*/
	protected MixedFraction divide(MixedFraction frac) {
		MixedFraction firstOne = new MixedFraction(this.fraction,this.denominator,this.numerator);
		Ratio firstRatio = firstOne.toRatio();
		MixedFraction secondOne = new MixedFraction(frac.fraction,frac.denominator,frac.numerator);
		Ratio secondRatio = secondOne.toRatio();
		Ratio resultRatio = firstRatio.divide(secondRatio);
		MixedFraction result = resultRatio.toMixedFraction();
		System.out.println(result);
		return result;
	}
}
