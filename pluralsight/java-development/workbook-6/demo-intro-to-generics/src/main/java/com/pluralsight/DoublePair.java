package com.pluralsight;

public class DoublePair {
    private double leftNumber;
    private double rightNumber;

    public DoublePair(double leftNumber, double rightNumber) {
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    public double getLeftNumber() {
        return leftNumber;
    }

    public double getRightNumber() {
        return rightNumber;
    }

    public void swap() {
        double temp = leftNumber;
        leftNumber = rightNumber;
        rightNumber = temp;
    }
}
