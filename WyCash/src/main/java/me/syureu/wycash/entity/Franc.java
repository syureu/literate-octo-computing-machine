package me.syureu.wycash.entity;

public class Franc extends Money {

	private String currency;

	public Franc(int amount) {
		this.amount = amount;
		this.currency = "CHF";
	}

	@Override public String currency() {
		return currency;
	}

	public Money times(int multiplier) {
		return new Franc(amount * multiplier);
	}

}
