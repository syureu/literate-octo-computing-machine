package me.syureu.wycash.entity;

public class Dollar extends Money{

	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}

	@Override
	public boolean equals(Object obj) {
		return amount == ((Dollar)obj).amount;
	}
}
