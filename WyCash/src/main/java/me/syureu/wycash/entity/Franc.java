package me.syureu.wycash.entity;

public class Franc {

	private int amount;

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		return new Franc(amount * multiplier);
	}

	@Override
	public boolean equals(Object obj) {
		return amount == ((Franc)obj).amount;
	}
}
