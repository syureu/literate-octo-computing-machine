package me.syureu.wycash.entity;

public interface Expression {
	Money reduce(Bank bank, String to);
}
