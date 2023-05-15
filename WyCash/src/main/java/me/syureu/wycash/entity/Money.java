package me.syureu.wycash.entity;

public class Money {
	protected int amount;

	@Override
	public boolean equals(Object obj) {
		return amount == ((Dollar)obj).amount;
	}

}
