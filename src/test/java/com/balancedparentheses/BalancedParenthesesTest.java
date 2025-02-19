package com.balancedparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedParenthesesTest {

    @Test
    void isBalanced_whenOnePairOfBracketsIsBalanced_returnTrue() {
        assertTrue(BalancedParentheses.isBalanced("()"));
    }

    @Test
    void isBalanced_whenOnePairOfBracketsIsNotBalanced_returnFalse() {
        assertFalse(BalancedParentheses.isBalanced("(("));
    }

    @Test
    void isBalanced_whenTwoPairsOfBracketsAreBalanced_returnTrue() {
        assertTrue(BalancedParentheses.isBalanced("()[]{}"));
    }

    @Test
    void isBalanced_whenTwoPairsOfBracketsAreNotBalanced_returnFalse() {
        assertFalse(BalancedParentheses.isBalanced("([)]"));
    }
    @Test
    void isBalanced_whenTwoPairsOfBracketsAreNotBalanced_returnFalse2() {
        assertFalse(BalancedParentheses.isBalanced("[(])"));
    }
    @Test
    void isBalanced_whenTwoPairsOfBracketsAreNotBalanced_returnFalse3() {
        assertFalse(BalancedParentheses.isBalanced("{(})"));
    }

    @Test
    void isBalanced_whenThreePairsOfBracketsAreBalanced_returnTrue() {
        assertTrue(BalancedParentheses.isBalanced("([{}])"));
    }
    @Test
    void isBalanced_whenThreePairsOfBracketsAreNotBalanced_returnFalse() {
        assertFalse(BalancedParentheses.isBalanced("([{}])("));
    }

    @Test
    void isBalanced_whenThreePairsOfBracketsAreNotBalanced_returnFalse2() {
        assertFalse(BalancedParentheses.isBalanced("{{)(}}"));
    }


    @Test
    void isBalanced_whenThreePairsOfBracketsAreBalanced_returnTrue3() {
        assertTrue(BalancedParentheses.isBalanced("[({})]"));
    }
    @Test
    void isBalanced_whenThreePairsOfBracketsAreBalanced_returnTrue4() {
        assertTrue(BalancedParentheses.isBalanced("{}([])"));
    }
    @Test
    void isBalanced_whenTBracketsAreBalanced_returnTrue() {
        assertTrue(BalancedParentheses.isBalanced("{()}[[{}]]"));
    }


}