package me.syureu.wycash.entity;

public class Money {
	protected int amount;

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass()) && amount == ((Money)obj).amount;
	}

}
