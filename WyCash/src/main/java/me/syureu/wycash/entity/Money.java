package me.syureu.wycash.entity;

public class Money {
	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass()) && amount == ((Money)obj).amount;
	}

	@Override public String toString() {
		return "Money{" +
			"amount=" + amount +
			", currency='" + currency + '\'' +
			'}';
	}

	public String currency() {
		return this.currency;
	}

	public Money times(int multiplier) {
		return null;
	}

}
