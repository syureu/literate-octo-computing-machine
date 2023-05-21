package me.syureu.wycash.entity;

public abstract class Money {
	protected int amount;

	public static Money dollar(int amount) {
		return new Dollar(amount);
	}

	public static Money franc(int amount) {
		return new Franc(amount);
	}

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass()) && amount == ((Money)obj).amount;
	}

	public abstract String currency();

	public abstract Money times(int multiplier);

}
