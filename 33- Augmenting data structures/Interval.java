package com.algorithms;

public class Interval {

    private double low;
    private double high;
    
    public Interval(double inputLow, double inputHigh) {
        if (Double.isInfinite(inputLow) || Double.isInfinite(inputHigh)) {
            System.out.println("The limit of endPoints has not been met.");
        }
        if (Double.isNaN(inputLow) || Double.isNaN(inputHigh)) {
            System.out.println("Select limited endPoints.");
        }
        if (inputLow == 0) {
            inputLow = 0;
        } else if (inputHigh == 0) {
            inputHigh = 0;
        }
        if (inputLow <= inputHigh) {
            low = inputLow;
            high = inputHigh;
        } else throw new IllegalArgumentException("Illegal interval !");
    }
    public boolean junctionOfIntervals(Interval cin) {
        if (cin.high < this.low) {
            return false;
        } else if (this.high < cin.low) 
            return false;
        return true;
    }
    public boolean including(double i) {
        return (i <= high) && (low <= i);
    }
    public double length() {
        return (this.high - this.low);
    }
    public String toString() {
        return "[" + this.low + ", " + this.high + "]";
    }
    public void setLow(double inputLow) {
        this.low = inputLow;
    }
    public void setHigh(double inputHigh) {
        this.high = inputHigh;
    }
    public double getLow() {
        return this.low;
    }
    public double getHigh() {
        return this.high;
    }
}
