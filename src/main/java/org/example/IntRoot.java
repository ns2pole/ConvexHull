package org.example;

import static org.example.ArrayListMethodInteger.*;

import java.util.ArrayList;

public class IntRoot {
	private int coff;//ルートの係数
	private int inside;//ルートの中身
	IntRoot(int coff,int inside){
		this.coff = coff;
		this.inside = inside;
	}
	
	protected int getCoff() {
		return this.coff;
	}
	
	protected int getInsider() {
		return this.inside;
	}
	
	@Override
	public String toString() {
		if(this.inside == 1) {
			return this.coff + "";
		}else if(this.coff == 1) {
			return "√" + this.inside;
		}else {
			return this.coff + "√" + this.inside;
		}
	}
	
	public boolean equals(IntRoot r1) {
		if(this.coff == r1.coff && this.inside == r1.inside) {
			return true;
		}else {
			return false;
		}
	}
	
	protected IntRoot getProductedRoot(IntRoot r1) {
		int newCoff = this.coff * r1.coff;
		int newInside = this.inside * r1.inside;
		ArrayList<Integer> primeFactors = getPrimeFactorsOf(newInside);
		if(detectDoubleNum(primeFactors).size() >= 1) {
			ArrayList<Integer> coffs = detectDoubleNum(primeFactors);
			int rootCoff = 1;
			for(int i = 0; i < coffs.size(); i++) {
				int a = coffs.get(i);
				rootCoff = rootCoff * a;
			}
			int resultCoff = newCoff * rootCoff;
			ArrayList<Integer> resultInside = detectSingleNum(primeFactors);
			int inside = 1;
				for(int i = 0;i<resultInside.size();i++) {
				int a = resultInside.get(i);
				inside = inside * a;
			}
				IntRoot result = new IntRoot(resultCoff,inside);
				return result;
		}else {
			IntRoot result = new IntRoot(newCoff,newInside);
		return result;
		}
		
	}
	
//	protected Decimal toDecimal() {
//
//	}
	//protected IntRoot getAddedRoot(IntRoot r1) {
		
	//}
	
}
