package org.example;

public class NormalVectorException extends IllegalArgumentException {
	public NormalVectorException() {
		super("0ベクトルに対する法線ベクトルは定義できません。");
	}

}