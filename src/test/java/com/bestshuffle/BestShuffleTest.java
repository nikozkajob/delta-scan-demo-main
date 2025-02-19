package com.bestshuffle;

import com.arrayshuffle.ShuffleScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestShuffleTest {

    @Test
    void getShuffleScore_whenInputIsStringOfTwoChars_returnScorefrom0to2() {
        ShuffleScore shuffleScore = BestShuffle.getShuffleScore("qw");
        int score = shuffleScore.getScore();
        System.out.println(score);
        assertTrue(score == 0 || score == 2);
    }

    @Test
    void getShuffleScore_whenInputIsStringOfThreeChars_returnScorefrom0to3() {
        ShuffleScore shuffleScore = BestShuffle.getShuffleScore("qwe");
        int score = shuffleScore.getScore();
        System.out.println(score);
        assertTrue(score >= 0 && score <= 3);
    }
    @Test
    void getShuffleScore_whenInputIsEmptyString_return0() {
        ShuffleScore shuffleScore = BestShuffle.getShuffleScore("");
        int score = shuffleScore.getScore();
        System.out.println(score);
        assertEquals(0, score);
    }

    @Test
    void getShuffleScore_whenInputStringIsNull_Throw() {
        assertThrows(IllegalArgumentException.class, () -> BestShuffle.getShuffleScore(null));
    }

}