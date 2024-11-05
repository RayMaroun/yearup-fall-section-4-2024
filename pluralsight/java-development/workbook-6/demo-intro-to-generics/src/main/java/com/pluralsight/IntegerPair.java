package com.pluralsight;

public class IntegerPair {
    private int leftNumber;
    private int rightNumber;

    public IntegerPair(int leftNumber, int rightNumber) {
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    public int getLeftNumber() {
        return leftNumber;
    }

    public int getRightNumber() {
        return rightNumber;
    }

    public void swap() {
        int temp = leftNumber;
        leftNumber = rightNumber;
        rightNumber = temp;
    }
}
