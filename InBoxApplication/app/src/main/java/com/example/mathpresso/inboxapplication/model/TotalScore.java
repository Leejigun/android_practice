package com.example.mathpresso.inboxapplication.model;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class TotalScore {
    int totalScore;
    int myScore;

    public TotalScore(int totalScore, int myScore) {
        this.totalScore = totalScore;
        this.myScore = myScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }
}
