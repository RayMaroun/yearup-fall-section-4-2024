package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        if (roomType.equals("king")) {
            this.price = 139.00;
        } else if (roomType.equals("double")) {
            this.price = 124.00;
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationTotal() {
        double totalPrice = price * numberOfNights;
        if (isWeekend) {
            totalPrice *= 1.1;
            // totalPrice = totalPrice + totalPrice * (10/100);
        }
        return totalPrice;
    }
}
