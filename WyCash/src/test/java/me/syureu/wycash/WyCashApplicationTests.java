package me.syureu.wycash;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import me.syureu.wycash.entity.Dollar;
import me.syureu.wycash.entity.Franc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WyCashApplicationTests {

	/**
	 * 통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 얻을 수 있어야 한다.
	 */

	/**
	 * <b>어떤 금액(주가)을 어떤 수(주식의 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.</b>
	 *
	 * $5 + 10CHF = $10(환율이 2:1일 경우)
	 * <del>$5 X 2 = $10</del>
	 * <del>amount를 private으로 만들기</del>
	 * <del>Dollar 부작용(side effect)?</del>
	 * Money 반올림?
	 * <del>equals()</del>
	 * Equal null
	 * Equal object
	 * hashcode()
	 * <del>5CHF * 2 = 10CHF</del>
	 * Dollar/Franc 중복
	 * <del>공용 equals</del>
	 * 공용 times
	 * Franc과 Dollar 비교하기
	 */
	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}

	@Test
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));
	}

	@Test
	public void testFrancMultiplication() {
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}

	@Test
	public void testFrancEquality() {
		assertTrue(new Franc(5).equals(new Franc(5)));
		assertFalse(new Franc(5).equals(new Franc(6)));
	}

}
