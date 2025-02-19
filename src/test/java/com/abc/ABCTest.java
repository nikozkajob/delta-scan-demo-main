package com.abc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ABCTest {

    @Test
    void canMakeWord_whenOneLetter_returnTrue() {
        assertTrue(ABC.canMakeWord("a"));
    }

    @Test
    void canMakeWord_whenTwoLetters_returnTrue() {
        assertTrue(ABC.canMakeWord("ba"));
    }

    @Test
    void canMakeWord_whenWordIsBark_returnTrue() {
        assertTrue(ABC.canMakeWord("BARK"));
    }

    @Test
    void canMakeWord_whenWordIsBOOK_returnFalse() {
        assertFalse(ABC.canMakeWord("BOOK"));
    }

    @Test
    void canMakeWord_whenWordIsTREAT_returnTrue() {
        assertTrue(ABC.canMakeWord("TREAT"));
    }

    @Test
    void canMakeWord_whenWordIsCOMMON_returnFalse() {
        assertFalse(ABC.canMakeWord("COMMON"));
    }
    @Test
    void canMakeWord_whenWordIsSQUAD_returnTrue() {
        assertTrue(ABC.canMakeWord("SQUAD"));
    }
    @Test
    void canMakeWord_whenWordIsCONFUSE_returnTrue() {
        assertTrue(ABC.canMakeWord("CONFUSE"));
    }
    @Test
    void canMakeWord_whenWordIsOO_returnTrue() {
        assertTrue(ABC.canMakeWord("OO"));
    }
}