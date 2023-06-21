package me.syureu.wycash.entity;

public class Money {
	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	@Override
	public boolean equals(Object obj) {
		return amount == ((Money)obj).amount && currency().equals(((Money)obj).currency());
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
		return new Money(amount * multiplier, currency);
	}

	public Expression plus(Money addend) {
		return new Money(amount + addend.amount, currency);
	}

}
