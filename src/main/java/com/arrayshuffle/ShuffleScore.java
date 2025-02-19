package com.arrayshuffle;

public class ShuffleScore {
    String originalString;
    String shuffledSting;
    int score;

    public ShuffleScore(String originalString, String shuffledSting, int score) {
        this.originalString = originalString;
        this.shuffledSting = shuffledSting;
        this.score = score;
    }

    public String getOriginalString() {
        return originalString;
    }

    public String getShuffledSting() {
        return shuffledSting;
    }

    public int getScore() {
        return score;
    }
}
