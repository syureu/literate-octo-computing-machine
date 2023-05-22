package me.syureu.wycash.entity;

public class Dollar extends Money {

	private String currency;

	public Dollar(int amount) {
		this.amount = amount;
		this.currency = "USD";
	}

	@Override public String currency() {
		return this.currency;
	}

	public Money times(int multiplier) {
		return new Dollar(amount * multiplier);
	}

}
