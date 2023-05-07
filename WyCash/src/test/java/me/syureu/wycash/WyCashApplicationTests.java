package me.syureu.wycash;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import me.syureu.wycash.entity.Dollar;

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
	 * amount를 private으로 만들기
	 * <del>Dollar 부작용(side effect)?</del>
	 * Money 반올림?
	 * equals()
	 * hashcode()
	 */
	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

}
