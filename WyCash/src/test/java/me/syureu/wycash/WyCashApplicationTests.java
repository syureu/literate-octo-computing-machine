package me.syureu.wycash;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import me.syureu.wycash.entity.Bank;
import me.syureu.wycash.entity.Expression;
import me.syureu.wycash.entity.Money;
import me.syureu.wycash.entity.Sum;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WyCashApplicationTests {

    /**
     * 통화가 다른 두 금액을 더해서 주어진 환율에 맞게 변한 금액을 얻을 수 있어야 한다.
     */

    /**
     * <b>어떤 금액(주가)을 어떤 수(주식의 수)에 곱한 금액을 결과로 얻을 수 있어야 한다.</b>
     * <p>
     * <del>$5 + 10CHF = $10(환율이 2:1일 경우)</del>
     * <del>$5 + $5 = $10</b>
     * $5 + $5에서 Money 반환하기
     * <del>Bank.reduce(Money)</del>
     * <del>Money에 대한 통화 변환을 수행하는 Reduce</del>
     * <del>Reduce(Bank, String)</del>
     * Sum.plus
     * Expression.times
     * <del>$5 X 2 = $10</del>
     * <del>amount를 private으로 만들기</del>
     * <del>Dollar 부작용(side effect)?</del>
     * Money 반올림?
     * <del>equals()</del>
     * Equal null
     * Equal object
     * hashcode()
     * <del>5CHF * 2 = 10CHF</del>
     * <del>Dollar/Franc 중복</del>
     * <del>공용 equals</del>
     * <del>공용 times</del>
     * <del>Franc과 Dollar 비교하기</del>
     * <del>통화?</del>
     * testFrancMultiplication을 지워야 할까?
     */
    @Test
    void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    void testDollarMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    void testFrancEquality() {
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }
}
