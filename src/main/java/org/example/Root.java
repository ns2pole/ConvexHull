package org.example;

public class Root {
	private Ratio coff;//ルートの係数
	private int inside;//ルートの中身
	Root(Ratio coff,int inside){
		this.coff = coff;
		this.inside = inside;
	}
	
	protected Ratio getCoff() {
		return this.coff;
	}
	protected int getInsider() {
		return this.inside;
	}
	
	@Override
	public String toString() {
		return this.coff + "√" + this.inside;
	}
	
	public boolean equals(Root r1) {
		if(this.coff.equals(r1.coff) && this.inside == r1.inside) {
			return true;
		}else {
			return false;
		}
	}
	
	protected Root getProductedRoot(Root r1) {
		Ratio newCoff = this.coff.getProductRatio(r1.coff);
		int newInside = this.inside * r1.inside;
		Root result = new Root(newCoff,newInside);
		return result;
	}
	
}
