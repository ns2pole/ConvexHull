package org.example;

public class Decimal {
	private String integralValue;//整数部分
	protected String decimal;//小数部分
	Decimal(String val,String dec){
		this.integralValue = val;
		this.decimal = dec;
	}
	
	@Override
	public String toString() {
		return this.integralValue + "." + this.decimal;
	}
	
	public boolean equals(Decimal decimal) {
		if(this.integralValue.equals(decimal.integralValue) && this.decimal.equals(decimal.decimal)) {
			return true;
		}else {
			return false;
		}
	}
}
