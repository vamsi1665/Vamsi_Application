package com.example.myapplication;

public class MyItem {
    int subgrade;
    int credits;

    public MyItem(int subgrade, int credits) {

        this.subgrade = subgrade;
        this.credits = credits;
    }

    public int getSubgrade() {
        return subgrade;
    }

    public void setSubgrade(int subgrade) {
        this.subgrade = subgrade;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
