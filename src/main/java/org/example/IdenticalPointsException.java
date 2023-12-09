package org.example;

public class IdenticalPointsException extends IllegalArgumentException {
	public IdenticalPointsException() {
		super("同一の点からは直線が定まりません");
	}

}