package me.syureu.wycash.entity;

public abstract class Money {
	protected int amount;

	public static Money dollar(int amount) {
		return new Dollar(amount);
	}

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass()) && amount == ((Money)obj).amount;
	}

	public abstract Money times(int multiplier);

}
