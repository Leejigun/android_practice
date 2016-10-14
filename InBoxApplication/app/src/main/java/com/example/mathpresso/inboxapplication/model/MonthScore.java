package com.example.mathpresso.inboxapplication.model;

import java.util.ArrayList;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class MonthScore {
    ArrayList<Integer> scores;

    public MonthScore(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }
}
