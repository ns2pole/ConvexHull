package org.example;

public class IntRootRatio {
	private IntRoot denominator;
	private IntRoot numerator;
	IntRootRatio(IntRoot den,IntRoot nume){
		this.denominator = den;
		this.numerator = nume;
	}
	
	protected IntRoot getDenominator() {
		return this.denominator;
	}
	protected IntRoot getNumerator() {
		return this.numerator;
	}
	
	@Override
	public String toString() {
		return this.numerator.toString() + "/" + this.denominator.toString();
	}
	
	public boolean equals(IntRootRatio ratio) {
		if(this.denominator.equals(ratio.denominator) && this.numerator.equals(ratio.numerator)) {
			return true;
		}else {
			return false;
		}
	}
	
	
//	protected IntRootRatio add(IntRootRatio ratio) {
//		int resultDenominator = this.denominator + ratio.denominator;
//		int resultNumerator = this.numerator + ratio.numerator;
//		return new IntRootRatio(resultDenominator, resultNumerator);
//	}
	
	protected IntRootRatio product(IntRootRatio ratio) {
		IntRoot denominator = this.denominator.getProductedRoot(ratio.denominator);
		IntRoot numerator = this.numerator.getProductedRoot(ratio.numerator);
		IntRootRatio result= new IntRootRatio(denominator,numerator);
		
		return result;
	}
	
	
	//RatioToRoot(有理化含む)
	
	//開平法メソッド(getRootDeimal)
	//public decimal getRootDeimal(IntRoot num1)
	
	//数を2桁ごとに区切るメソッド(splitNumber)
	//public int splitNumber(int int1,int digits) int1:数　digits:桁目
	
	//以下の最大の平方根求めるメソッド(maxSquare)...*
	//public int maxSquare(int int1) int1:数
	
	//平方根*2,先頭-平方数,二桁おろす
	
	//(平方数*10 + 末尾) * 末尾 が超えないように最大になるのを求めるメソッド(maxLastNumber)
	//public int maxLastNumber(int int1) int1:数
	
	//先頭 - (平方数*10 + 末尾) * 末尾 して二桁おろす...*
	//*部分を繰り返し ただ二回目以降は「最後の工程は位置のくらいを下ろして足す」に変化(plusLastDigit)
	
}
