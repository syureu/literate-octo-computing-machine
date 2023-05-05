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
	 * 빨간 막대
	 * $5 + 10CHF = $10(환율이 2:1일 경우)
	 * <b>$5 X 2 = $10</b>
	 * amount를 private으로 만들기
	 * Dollar 부작용(side effect)?
	 * Money 반올림?
	 *
	 * 컴파일 에러
	 * <del>Dollar 클래스가 없음</del>
	 * <del>생성자가 없음 (Dollar의 int 하나를 갖는)</del>
	 * <b>times(int) 메서드가 없음</b>
	 * amount 필드가 없음
	 */
	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		five.times(2);
		assertEquals(10, five.amount);
	}
	
}
